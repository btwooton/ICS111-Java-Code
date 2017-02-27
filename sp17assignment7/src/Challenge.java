import java.util.Random;
import java.awt.Color;

public class Challenge {
	
	// static variable for random number Generator
	static Random randomGenerator = new Random();
	
	// static variables for screen size;
	static int screenWidth = 500;
	static int screenHeight = 500;

	// function that uses an array of the image file names
	// to randomly draw 5 dice to the screen at incrementing x coordinates
	static void roll() {
		String[] fileNames = {"1c.gif", "2c.gif", "3c.gif", "4c.gif", "5c.gif", "6c.gif"};
		int[] roll_values = new int[5];
		int next_roll = 0;
		
		int yCoord = 250;
		int xCoord = 50;
		for(int i = 0; i < 5; i++) {
			next_roll = randomGenerator.nextInt(6);
			EZ.addImage(fileNames[next_roll], xCoord, yCoord);
			roll_values[i] = next_roll; 
			xCoord += 100;
		}
		
		int[] value_counts = {0, 0, 0, 0, 0, 0};
		for(int i = 0; i < 5; i++) {
			value_counts[roll_values[i]]++;
		}
		for (int i = 0; i < value_counts.length; i++) {
			if (value_counts[i] == 6) {
				EZ.addText(screenWidth / 2, screenHeight - 150, "Yahtzee", Color.BLACK, 20);
				return;
			}
			else if(value_counts[i] == 4) {
				EZ.addText(screenWidth / 2, screenHeight - 150, "Four of a kind", Color.BLACK, 20);
				return;
			}
			else if(value_counts[i] == 3) {
				for (int j = 0; j < value_counts.length; j++) {
					if (value_counts[j] == 2) {
						EZ.addText(screenWidth / 2, screenHeight - 150, "Full house", Color.BLACK, 20);
						return;
					}
				}
				EZ.addText(screenWidth / 2, screenHeight - 150, "Three of a kind", Color.BLACK, 20);
				return;
				
			}
			else if(value_counts[i] == 2) {
				for (int j = 0; j < value_counts.length; j++) {
					if (value_counts[j] == 3) {
						EZ.addText(screenWidth / 2, screenHeight - 150, "Full house", Color.BLACK, 20);
						return;
					}
				}
				EZ.addText(screenWidth / 2, screenHeight - 150, "Two of a kind", Color.BLACK, 20);
				return;
				
			}
			else {
				int straight_val = 0;
				for (int j = 0; j < 5; j++) {
					if (value_counts[j] == 1) {
						straight_val++;
					}
				}
				if (straight_val == 5) {
					EZ.addText(screenWidth / 2, screenHeight - 150, "Straight", Color.BLACK, 20);
					return;
				}
				straight_val = 0;
				for (int j = 1; j < 6; j++) {
					if(value_counts[j] == 1) {
						straight_val++;
					}
				}
				if (straight_val == 5) {
					EZ.addText(screenWidth / 2, screenHeight - 150, "Straight", Color.BLACK, 20);
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		// initialize the EZ Graphics window
		EZ.initialize(screenWidth, screenHeight);
		
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