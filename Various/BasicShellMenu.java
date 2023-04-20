import java.util.Scanner;
public class BasicShellMenu {
	public static void main(String[] args){
		
		Scanner inputObject = new Scanner(System.in);
		int mainOption;
		do {
			System.out.println("\n\nMenu Title");
			System.out.println("Select the Method to Execute:");
			System.out.println("0 = Quit");
			System.out.println("1 = Method");
			System.out.print("\nOption: ");
			try{
				mainOption = Integer.parseInt(inputObject.nextLine());
			} catch (Exception e){
				mainOption = -1;
			}
			switch (mainOption){
				case 0: System.out.println("\nLater!"); break;
				case 1: MethodName(); break;		
				default: System.out.println("Invalid Option"); break;
			}
		} while (mainOption!=0);
		
		inputObject.close();
		
	}
	
	public static void MethodName(){
		System.out.println("Hello World!");
	}
	
}