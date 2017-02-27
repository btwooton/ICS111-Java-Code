import java.util.Random;

public class Challenge {
	
	// static variables for random number generator and dice images
	static Random randomGenerator = new Random();
	//static EZImage nextDie;
	/*
	// function that returns an array of five randomly generated numbers
	static int[] getFiveNumbers() {
		int[] result = new int[5];
		for(int i = 0; i < 5; i++) {
			result[i] = randomGenerator.nextInt(6);
		}
		return result;
	}
	*/
	/*
	// function that draws a picture of a die at (x, y) with the given filename
	static void drawDieAtPosition(int x, int y, String imageFileName) {
		nextDie = EZ.addImage(imageFileName, x, y);
	}
	 */
	// function that uses an array of the image file names and the results of the helper
	// functions getFiveNumbers() and drawDieAtPosition() to randomly draw 5 dice to the
	// screen at incrementing x coordinates
	static void roll() {
		//int[] values = getFiveNumbers();
		String[] fileNames = {"1c.gif", "2c.gif", "3c.gif", "4c.gif", "5c.gif", "6c.gif"};
		int yCoord = 250;
		int xCoord = 50;
		for(int i = 0; i < 5; i++) {
			EZ.addImage(fileNames[randomGenerator.nextInt(6)], xCoord, yCoord);
			xCoord += 100;
		}
	}

	public static void main(String[] args) {
		// initialize the EZ Graphics window
		EZ.initialize(500, 500);
		
		// call Roll initially so that the dice will already be on the screen
		roll();
		
		// main loop
		while(true) {
			
			// check for user mouse click interaction
			if (EZInteraction.wasMouseLeftButtonPressed() || 
					EZInteraction.wasMouseLeftButtonReleased()) {
				
				// remove current dice and roll() to generate five new dice
				EZ.removeAllEZElements();
				roll();
			}
			// update the changes to the screen
			EZ.refreshScreen();
		} // END main loop
	}// END main() function

}// Class Challenge