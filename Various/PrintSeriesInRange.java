import java.util.Scanner;

public class PrintSeriesInRange {
	public static void main(String[] args){
		
		Scanner inputObject = new Scanner(System.in);
		System.out.print("Write Start Number: "); 
		int startNumber = Integer.parseInt(inputObject.nextLine());
		System.out.print("Write End Number: "); 
		int finishNumber = Integer.parseInt(inputObject.nextLine());
    
		if (startNumber==finishNumber){
			System.out.print("You wrote the same integer: " + startNumber);
		} else {
			if (startNumber > finishNumber){
				int swapNumber = finishNumber; 
				finishNumber = startNumber; 
				startNumber = swapNumber;
			}
			while (startNumber < (finishNumber+1)) {
				System.out.println(startNumber); startNumber++;
			}
		}
    
		inputObject.close();
		
  }
}
