import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.Color;


public class ZombieMain {
	
	//--------------------------------------------------------
	// COLLISION DETECTION FUNCTIONS FOR ZOMBIES
	//--------------------------------------------------------
	static boolean isZombieXOverlap(EZImage zombie) {
		int zombieLeftEdge = zombie.getXCenter() - zombie.getWidth()/2;
		int zombieRightEdge = zombie.getXCenter() + zombie.getWidth()/2;
		
		return (zombieLeftEdge <= survivorLeftEdge && zombieRightEdge >= survivorLeftEdge + 30) ||
				(zombieRightEdge >= survivorRightEdge && zombieLeftEdge <= survivorRightEdge - 30);
	}
	
	static boolean isZombieYOverlap(EZImage zombie) {
		int zombieBottomEdge = zombie.getYCenter() + zombie.getHeight()/2;
		int zombieTopEdge = zombie.getYCenter() - zombie.getHeight()/2;
		
		return (zombieTopEdge <= survivorTopEdge && zombieBottomEdge >= survivorTopEdge + 40) ||
				(zombieTopEdge <= survivorBottomEdge - 30 && zombieBottomEdge >= survivorBottomEdge);
	}
	
	static boolean isZombieOverlap(EZImage zombie) {
		return isZombieXOverlap(zombie) && isZombieYOverlap(zombie);
	}
	
	static void checkCollisions() {
		for (int i = 0; i < numZombies; i++) {
			if (survivorDead = isZombieOverlap(zombiePics[i])) {
				return;
			}
		}
	}
	
	
	//---------------------------------------------------------
	// END OF COLLISTION DETECTION FUNCTIONs
	//---------------------------------------------------------
	
	//---------------------------------------------------------
	// FUNCTION FOR SPAWNING ZOMBIES
	//---------------------------------------------------------
	
	static void spawnZombie() {
		int zombieX;
		int zombieY;
		int randomSide = randomGenerator.nextInt(4);
		
		if (randomSide == 0) {
			zombieX = 0 - randomGenerator.nextInt(50);
			zombieY = randomGenerator.nextInt(screenHeight);
		}
		else if (randomSide == 1) {
			zombieX = randomGenerator.nextInt(screenWidth);
			zombieY = 0 - randomGenerator.nextInt(50);
		}
		else if (randomSide == 2) {
			zombieX = screenWidth + randomGenerator.nextInt(50);
			zombieY = randomGenerator.nextInt(screenHeight);
		}
		else {
			zombieX = randomGenerator.nextInt(screenWidth);
			zombieY = screenHeight + randomGenerator.nextInt(50);
		}
		zombiePics[numZombies] = EZ.addImage("resources/Zombie.png", 
				zombieX, 
				zombieY);
		zombieSpeeds[numZombies] = (randomGenerator.nextDouble() + 0.1) * 1.5;
		numZombies++;
		
	}
	
	//---------------------------------------------------------
	// FUNCTION FOR TRACKING SURVIVOR EDGES
	//---------------------------------------------------------
	
	static void trackSurvivor() {
		survivorRightEdge = survivor.getXCenter() + survivor.getWidth() / 2;
		survivorLeftEdge = survivor.getXCenter() - survivor.getWidth() / 2;
		survivorTopEdge = survivor.getYCenter() - survivor.getHeight() / 2;
		survivorBottomEdge = survivor.getYCenter() + survivor.getHeight() / 2;
	}
	
	//----------------------------------------------------------
	// FUNCTION FOR GETTING USER INPUT
	//----------------------------------------------------------
	
	static void getUserInput() {
		if (EZInteraction.isKeyDown('d') && survivorRightEdge < screenWidth) {
			survivor.translateBy(10, 0);
		} else if (EZInteraction.isKeyDown('a') && survivorLeftEdge > 0) {
			survivor.translateBy(-10, 0);
		} else if (EZInteraction.isKeyDown('w') && survivorTopEdge > 0) {
			survivor.translateBy(0, -10);
		} else if (EZInteraction.isKeyDown('s') && survivorBottomEdge < screenHeight) {
			survivor.translateBy(0, 10);
		}
	}
	
	//----------------------------------------------------------
	// FUNCTION FOR MOVING ZOMBIES
	//----------------------------------------------------------
	
	static void zombieAttackSurvivor() {
		for (int i = 0; i < numZombies; i++) {
			if (zombiePics[i].getXCenter() < survivor.getXCenter()) {
				zombiePics[i].translateBy(zombieSpeeds[i], 0);
			}
			if (zombiePics[i].getXCenter() > survivor.getXCenter()) {
				zombiePics[i].translateBy(-zombieSpeeds[i], 0);
			}
			if (zombiePics[i].getYCenter() < survivor.getYCenter()) {
				zombiePics[i].translateBy(0, zombieSpeeds[i]);
			}
			if (zombiePics[i].getYCenter() > survivor.getYCenter()) {
				zombiePics[i].translateBy(0, -zombieSpeeds[i]);
			}
		}
	}
	
	
	// static variables to hold our EZGraphics window dimensions
	static int screenWidth = 800;
	static int screenHeight = 600;
	
	// initialize our random number generator
	static Random randomGenerator = new Random();
	
	// variable to keep track of the time
	static long spawnTime = 0;
	
	// image to hold/track our "survivor" picture
	static EZImage survivor;
	
	// variables representing the edges of our survivor for purposes
	// of collision detection
	
	static int survivorRightEdge;
	static int survivorLeftEdge;
	static int survivorTopEdge;
	static int survivorBottomEdge;
	
	// constant representing the maximum number of zombies that we can spawn on the screen
	static final int maxZombies = 20;
	
	// arrays to hold all of our zombie images
	// and to keep track of each zombie's unique speed
	static EZImage[] zombiePics = new EZImage[maxZombies];
	static double[] zombieSpeeds = new double[maxZombies];
	
	// variable that will keep track of the number of zombies that we have spawned
	static int numZombies = 0;
	
	// boolean variable to keep track of whether the survivor is dead or alive
	static boolean survivorDead = false;
	

	public static void main(String[] args) {
		
		// initialize the EZ Graphics window
		EZ.initialize(screenWidth, screenHeight);
		
		// set the background color
		EZ.setBackgroundColor(Color.GREEN);
		
		// draw the survivor image on the screen
		survivor = EZ.addImage("resources/survivor.png", screenWidth/2, screenHeight/2);
		
		// the spawn time of the first zombie
		spawnTime = System.currentTimeMillis();
		
		// spawn the first zombie at a random position
		spawnZombie();
		
		while (!survivorDead) {
			
			// every 30 seconds spawn a new zombie on the screen and update the spawn time
			if (System.currentTimeMillis() > spawnTime + 5000 &&
					numZombies < maxZombies) {
				spawnZombie();
				spawnTime += 5000;
			}
			
			// check for user interaction to allow for the survivor to be moved with WASD
			getUserInput();
			
			// update the edges of the survivor in real time as he moves around
			// the screen
			trackSurvivor();
			
			// move the zombies towards the survivor
			zombieAttackSurvivor();
			
			// check for collisions
			checkCollisions();
						
			// update the window to show changes
			EZ.refreshScreen();
		}
		// if the game is over we remove images from the screen and display GAME OVER
		EZ.removeAllEZElements();
		EZ.addText(screenWidth/2, screenHeight/2, "GAME OVER", Color.BLACK, 50);

	}

}
