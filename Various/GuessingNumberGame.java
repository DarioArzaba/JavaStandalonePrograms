import java.util.Random;
import java.util.Scanner;
public class GuessingNumberGame {
	public static void main(String[] args){
		
		Scanner inputObject = new Scanner(System.in);
		System.out.println("\nGuessing Game (1-100)");
		Random computerGuessObject = new Random();
		int computerGuess = computerGuessObject.nextInt(100)+1;
		int attempts = 1;
		boolean guessed = false;
		while (!guessed){
			System.out.print("What number am I thinking? ");
			int guess = Integer.parseInt(inputObject.nextLine());
			if (computerGuess == guess){
				System.out.println("\nCorrect! (After " + attempts + " guesses).");
				guessed = true;
			} else if (computerGuess > guess){
				System.out.println("\nUp! (Guess number " + attempts + ").");
			} else { 
				System.out.println("\nDown! (Guess number " + attempts + ").");
			} 
			attempts++; 
		}
		inputObject.close();
		
	}
}
