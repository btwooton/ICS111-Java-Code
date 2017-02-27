
import java.util.Random;


import java.io.InputStreamReader;
import java.util.Scanner;


public class Part2 {
	
	static void evaluateNumbers(int guess, int randomInteger) {
		if (guess == randomInteger) {
			System.out.println("BINGO!");
		}
		else if (guess == randomInteger - 1 || guess == randomInteger + 1) {
			System.out.println("hot!");
		}
		else if (guess == randomInteger - 2 || guess == randomInteger + 2) {
			System.out.println("warm");
		}
		else if (guess == randomInteger - 3 || guess == randomInteger + 3) {
			System.out.println("warm-ish");
		}
		else {
			System.out.println("cold");
		}
	}

	public static void main(String[] args) {
	
		// 1. Computer thinks of a random number.
		Random randomGenerator; // Declare a variable called randomGenerator of type Random
		randomGenerator = new Random(); // make a random number generator and store it in the variable called randomGenerator
		int randomInteger = randomGenerator.nextInt(10); // make a random number from 0 to 10 and store it in the variable randomInteger
		
		int guess; // create an integer variable called guess
		int count = 0; // create an integer variable called count and set it to zero

		
		// make something called a scannner that will let the computer let me type into it
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		
		
		do {
			// 2. You tell the computer the number.
			// 2a Computer asks you to type in a number.
			System.out.println("Guess a number from 0 to 10? ");
			guess = scanner.nextInt();  // Wait for the user to type in a number

			// YOUR CHANGES SHOULD BE APPLIED TO THE SEGMENT BELOW

			// call the evaluateNumbers function to test the guess against the answer
			evaluateNumbers(guess, randomInteger);

			// AND STOP HERE
			
			// 4. Computer goes back to step 2 if you didnʻt get it. Otherwise
			// it tells you how many guesses you took.
			// 4a Computer keeps count of how many tries you made.

			count++;

			// 4c If your guess was wrong then go back to 2.
		} while (guess != randomInteger);

		// 4b If your guess was right then it tells you how many tries you
		// made.

		System.out.println("You took " + count + " guesses!");


		
		// If you took more than or exactly 5 guesses say: "DUMMY ASS!"
		if (count >= 5){
			System.out.println("DUMB ASS");
		}
		
		// If you took less than 5 guesses but more than 3 guesses: "LAME"
		if (count > 3 && count < 5){
			System.out.println("LAME");
		}
		
		// If you took fewer than the above then say: "YOU"RE PSYCHIC TELL JASON TO GIVE YOU AN A AND SKIP THE REST OF THE CLASS"
		if (count < 3) {
			System.out.println("YOUʻRE PSYCHIC TELL JASON TO GIVE YOU AN A AND SKIP THE REST OF THE CLASS");
		}
	}

}