package Various;

/**
 Simple Hello World.
 <p>Prints on the system output Console the string "Hello, World!"

 @author Dario Arzaba
 @version 1.0
 */

public class HelloWorld {
	
	/**
	 Prints "Hello, World!" to the Console
	 */
	public void printDefaultMessage(){
		
		System.out.print("Hello, World!");
		
	}
	
}

class VariousTesting9 {
	
	public static void main(String[] args) {

		HelloWorld instance = new HelloWorld();
		instance.printDefaultMessage();

		System.exit(0);
	
	}
}