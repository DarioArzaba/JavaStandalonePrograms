package Various;

/**
 Ancient Square Root Calculator.
 <p>Babylonians use an algorithm to determining the square root of a number using an initial guess of a/2, then finding the avarage of your guess(g) and (a/g) as the next guess.
 <p>This program represents the usage of that aproximation system.
 
 @author Dario Arzaba
 @version 1.0
 */

public class AncientSquareRoot {

	private double number;
	
	/**
	 This constructor creates an Ancient Square Root calculator with a default value of 140.
	 */
	public AncientSquareRoot(){
		this.number = 140;
	}
	
	/**
	 This constructor creates an Ancient Square Root calculator based on a given double value.
	 @param num Double with the number to obtain the square root from.
	 */
	public AncientSquareRoot(double num){
		this.number = num;
	}
	
	/**
	 This method calculates the square root using the ancient Babylonian algorithm.
	 It uses a default precision value of 0.001 between guesses.
	 @return guess Double with the best guess for the square root of the number.
	 */
	public double getSquareRoot(){
		
		double firstGuess = 0, secondGuess = 0;
		
		firstGuess = (number / 2.0);
		secondGuess = ( ( (firstGuess) + (number/firstGuess) ) / (2.0) );
		
		while ( (firstGuess-secondGuess) > 0.001){
			firstGuess = secondGuess;
			secondGuess = ( ( (firstGuess) + (number/firstGuess) ) / (2.0) );
		}
		
		return secondGuess;
	}
	
	/**
	 This method calculates the square root using the ancient Babylonian algorithm.
	 It allows for a precision value to be given.
	 @param precision Precision value used as the minimun distance between guesses so that the second guess can be considered the right answer.Ej. 0.001.
	 @return guess Double with the best guess for the square root of the number.
	 */
	public double getSquareRoot(double precision){
		double firstGuess = 0, secondGuess = 0;
		
		firstGuess = (number / 2);
		secondGuess = ( ( (firstGuess) + (number/firstGuess) ) / (2) );
		
		while ( (firstGuess-secondGuess) > precision){
			firstGuess = secondGuess;
			secondGuess = ( ( (firstGuess) + (number/firstGuess) ) / (2) );
		}
		
		return secondGuess;
	}
	
	/**
	 This method prints a sentence with the final square root of the given number.
	 
	 */
	public void printSquareRoot(){
		
		System.out.println("The square root of " + number + " is approximately: " + getSquareRoot());
	
	}
	
	/**
	 This method prints a sentence with the final square root of the given number and given precision.
	 @param precision Precision value used as the minimun distance between guesses so that the second guess can be considered the right answer.Ej. 0.001.
	 */
	public void printSquareRoot(double precision){
		
		System.out.println("The square root of " + number + " is approximately: " + getSquareRoot(precision));
		
	}
	
	public double getNumber() {
		return number;
	}
	public void setNumber(double number) {
		this.number = number;
	}
	
}

class VariousTesting12 {
	
	public static void main(String[] args) throws InterruptedException {

		AncientSquareRoot instance = new AncientSquareRoot();
		instance.printSquareRoot();
		
		System.exit(0);
	
	}
}
