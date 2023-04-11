package Various;

import java.text.DecimalFormat;

/**
 Leibniz Pi Calculator
 <p>The Leibniz formula is an infinite series algorithm that calculates the value of pi. It starts with 1 and then alternates between adding and substracting decimal numbers with the numerator always 1 and the denominator as every odd number. Finally it multiplies everything by four.
 <pre>
 	Pi = 1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11 ... * 4
 </pre>
 
 @author Dario Arzaba
 @version 1.0
 */

public class LeibnizFormula {
	
	int counter = 10000000;
	
	/**
	 This constructor creates a new Leibniz Infinite Series to calculate Pi.
	 @param iterations Number of decimal numbers that will be added or substracted from the infnite series.
	 */
	public LeibnizFormula(int iterations){
		this.counter = iterations;
	}
	
	/**
	 This method calculates Pi using the Leibniz Formula.
	 @return Pi Double with the aproximate value of Pi given the iterations allocated.
	 */
	public double calculatePi(){
		
		double denominator = 1;
		double result = 0;
		
		for (int i = 0; i < this.counter; i++) {
			
			if ((i % 2) == (0)){
		
				result += (1/denominator);
		
			} else {
		
				result -= (1/denominator);
			}
		
			denominator += 2;
		
		}
		
		result *= 4;
		return result;
	}
	
	
	/**
	 Prints the results from calculating Pi using the Leibniz Formula up to six decimal places.
	 */
	public void printPiResult(){
		
		DecimalFormat newFormat = new DecimalFormat("##.000000");
		System.out.println("The approximate value of Pi is: " + newFormat.format(calculatePi()));
		
	}
	
}

