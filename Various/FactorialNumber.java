import java.util.Scanner;
public class FactorialNumber {
	public static void main(String[] args){
		
		Scanner inputObject = new Scanner (System.in);
		System.out.print("Type a number [0-20]: ");
		int factorialNumber = Integer.parseInt(inputObject.nextLine());
		
		if (factorialNumber != 0){
			long factorialRes = 1, factorialCount = 2;
			while (factorialCount <= factorialNumber) {
				factorialRes *= factorialCount;factorialCount++;
			} System.out.println("Factorial: " + factorialRes); 
		} else {
			System.out.println("Factorial: 1"); 
		}
		inputObject.close();
	}
}