import java.awt.Color;

import java.util.Random;
import java.awt.event.KeyEvent;

public class Part3 {

	public static void main(String[] args) {

		 // Setup EZ graphics system.
		  EZ.initialize(700,500);
		  EZ.setBackgroundColor(new Color(0,100,0));
		  EZImage bugPicture = EZ.addImage("bug.png", 350,250);
		  EZSound fartSound = EZ.addSound("fart.wav");
		  
		  // initialize random number generator
		  Random randomGenerator = new Random();
		  
		  // the array of poop images that will hold our ten poops
		  EZImage[] poop_array = new EZImage[10];
		  
		  // variable that will keep track of which array index to put our poop into
		  int poop_array_index = 0;
		  
		  // the x and y coordinates of our poop pictures
		  int poopX, poopY;

		  while(true) {
				if (EZInteraction.isKeyDown('d')) {
					bugPicture.turnRight(5);
				} else if (EZInteraction.isKeyDown('a')) {
					bugPicture.turnLeft(5);
				} else if (EZInteraction.isKeyDown('w')) {
					bugPicture.moveForward(10);
				} else if (EZInteraction.isKeyDown('s')) {
					bugPicture.moveForward(-10); 
				} else if (EZInteraction.wasKeyReleased(KeyEvent.VK_SPACE) &&
						poop_array_index < 10) {
					poop_array[poop_array_index] = EZ.addImage("poop.png", bugPicture.getXCenter(), bugPicture.getYCenter());
					poop_array[poop_array_index].pushToBack();
					fartSound.play();
					poop_array_index++;
				}
				for(int i = 0; i < poop_array_index; i++) {
					poopX = poop_array[i].getXCenter();
					poopY = poop_array[i].getYCenter();
						
					poopX += -2+randomGenerator.nextInt(5);
					poopY += -2+randomGenerator.nextInt(5);
						
					poop_array[i].translateTo(poopX, poopY);
				}
			  EZ.refreshScreen();
		  }
	}

}