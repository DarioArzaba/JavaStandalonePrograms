package Various;

import java.io.PrintStream;
import java.util.Scanner;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Random;

public class HangmanGameClass {
	
	
	private Scanner inputObject = new Scanner(new FilterInputStream(System.in) {
		@Override public void close() throws IOException {}
	});
	private String[] hangmanList = { "manzana", "platano", "naranja", "sandias", "uvas", "peraa"};
	
	private String palabra = hangmanList[new Random().nextInt(hangmanList.length)];
	private String alfabetoUsado = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
	private String caracter = "a";
	private String palabraIncognita = palabra.replaceAll(".", "?");
	private StringBuilder letrasIntentadas = new StringBuilder();
	
	private int intentosChar = 15;
	
	public void HangmanGame(){
		
		
		System.out.println("\n****************");
    	System.out.println("* Hangman Game *");
    	System.out.println("****************");
		
		boolean quitGame = false;
    	
    	hangmanGameMenu();
    	
	   	while (!quitGame){
	   	
			System.out.print("\n> ");
			String hangmanOption = inputObject.nextLine().toLowerCase();
			
			if (hangmanOption.equals("quit")){
				
				System.out.println("\n Thanks for Playing!");
				quitGame = true;
				
			} else if  (hangmanOption.equals("restart")){
				
				System.out.println("\nReiniciando...\n");
				palabra= hangmanList[new Random().nextInt(hangmanList.length)];
		    	System.out.println("****************");
		    	System.out.println("* Hangman Game *");
		    	System.out.println("****************");
		    	alfabetoUsado = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
				caracter = "a";
				palabraIncognita = palabra.replaceAll(".", "?");
				letrasIntentadas = new StringBuilder();
				intentosChar = 15;
		    	hangmanGameMenu();
		    	
			} else if (hangmanOption.equals("menu")){
				
				hangmanGameMenu();
				
			} else if (isCharacter(hangmanOption)) {
				
				caracter = hangmanOption;
				caracter.toLowerCase();
				
				if (palabra.contains(caracter)){
					
				    palabraIncognita = hangmanGameGuess(palabra, letrasIntentadas, caracter);
					alfabetoUsado = alfabetoUsado.replace(caracter, "");
					System.out.println("\nLa letra " + caracter + " esta en la palabra: " + palabraIncognita);
					
				} else {
					
					alfabetoUsado = alfabetoUsado.replace(caracter, "");
					System.out.println("\nLa letra " + caracter + " no esta en la palabra!");
					intentosChar--;
					System.out.println("Te quedan " + intentosChar + " intentos!");
					
				}
				if (intentosChar != 0){
					
					hangmanGameMan(intentosChar);
					hangmanGameWord(palabraIncognita, alfabetoUsado, intentosChar);
					
				}
				
				
			} else {
				System.out.println("\n Comando no valido!");
			}
			if (palabraIncognita == palabra){
				
				System.out.println("\nYou won!!!");
				System.out.println("Do you want to play again? yes/no ");
				System.out.print("\n> ");
				String optionContinue = inputObject.nextLine().toLowerCase();
				
				if (optionContinue.equals("y") || optionContinue.equals("yes")) {
					System.out.println("\nRestarting ...\n");
					palabra= hangmanList[new Random().nextInt(hangmanList.length)];
			    	System.out.println("****************");
			    	System.out.println("* Hangman Game *");
			    	System.out.println("****************");
			    	alfabetoUsado = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
					caracter = "a";
					palabraIncognita = palabra.replaceAll(".", "?");
					letrasIntentadas = new StringBuilder();
					intentosChar = 15;
					hangmanGameMenu();
				} else {
					System.out.println("\nThanks for playing!");
					quitGame = true;
				}
			}
			
			if (intentosChar == 0){
				
				System.out.println("\nYou lose, the secret word was:  " + palabra);
				System.out.println("Do you want to play again? yes/no ");
				System.out.print("\n> ");
				String optionContinue = inputObject.nextLine().toLowerCase();
				
				if (optionContinue.equals("y") || optionContinue.equals("yes")) {
					System.out.println("\nRestarting ...\n");
					palabra= hangmanList[new Random().nextInt(hangmanList.length)];
			    	System.out.println("****************");
			    	System.out.println("* Hangman Game *");
			    	System.out.println("****************");
			    	alfabetoUsado = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
					caracter = "a";
					palabraIncognita = palabra.replaceAll(".", "?");
					letrasIntentadas = new StringBuilder();
					intentosChar = 15;
			    	hangmanGameMenu();
				} else {
					System.out.println("\nThanks for playing!");
					quitGame = true;
				}
			}
			
    	}
		inputObject.close();
	}
	
    private boolean isCharacter(String str) {
		
        if ( (str.length() == 1) && (str.matches("[a-zA-Z]")) ) {
        	return true;
        } else {
          return false;
        }
        
    }
	
	private void hangmanGameMenu(){
		System.out.println("\nQuit = Quits the Game ");
		System.out.println("Restart = Restarts the game. ");
		System.out.println("Menu = Prints this menu. ");
		System.out.println("Input a character:");
    }
	
	private void hangmanGameWord(String palabraIncognita, String alfabetoUsado, int intentosChar){
		System.out.println("\nPalabra: " + palabraIncognita);
		System.out.println("Alfabeto: " + alfabetoUsado);
		System.out.println("Te quedan " + intentosChar + " intentos.");
    }
	
	private String hangmanGameGuess(String palabra, StringBuilder letrasIntentadas, String caracter){
    	
    	letrasIntentadas = letrasIntentadas.append(caracter);
    	String resultado = palabra.replaceAll("[^"+letrasIntentadas.toString()+"]", "?");
    	return resultado;
    	
    }
	
	private void hangmanGameMan(int intentos){
    	switch (intentos){
	    	case 15:
	    		System.out.println("     ____             ");
	    		System.out.println("     |/               ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("  ___|----__________  ");
	    		break;
	    	case 14:
	    		System.out.println("     _______          ");
	    		System.out.println("     |/               ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("  ___|----__________  ");
	    		break;
	    	case 13:
	    		System.out.println("     ___________      ");
	    		System.out.println("     |/               ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("  ___|----__________  ");
	    		break;
	    	case 12:
	    		System.out.println("     ___________      ");
	    		System.out.println("     |/         |     ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("  ___|----__________  ");
	    		break;
	    	case 11:
	    		System.out.println("     ___________      ");
	    		System.out.println("     |/         |     ");
	    		System.out.println("     |          |     ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("  ___|----__________  ");
	    		break;
	    	case 10:
	    		System.out.println("     ___________      ");
	    		System.out.println("     |/         |     ");
	    		System.out.println("     |          |     ");
	    		System.out.println("     |         (      ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("  ___|----__________  ");
	    		break;
	    	case 9:
	    		System.out.println("     ___________      ");
	    		System.out.println("     |/         |     ");
	    		System.out.println("     |          |     ");
	    		System.out.println("     |         ( )    ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("  ___|----__________  ");
	    		break;
	    	case 8:
	    		System.out.println("     ___________      ");
	    		System.out.println("     |/         |     ");
	    		System.out.println("     |          |     ");
	    		System.out.println("     |         (_)    ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("  ___|----__________  ");
	    		break;
	    	case 7:
	    		System.out.println("     ___________      ");
	    		System.out.println("     |/         |     ");
	    		System.out.println("     |          |     ");
	    		System.out.println("     |         (_)    ");
	    		System.out.println("     |          |	    ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("  ___|----__________  ");
	    		break;
	    	case 6:
	    		System.out.println("     ___________      ");
	    		System.out.println("     |/         |     ");
	    		System.out.println("     |          |     ");
	    		System.out.println("     |         (_)    ");
	    		System.out.println("     |         \\|     ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("  ___|----__________  ");
	    		break;
	    	case 5:
	    		System.out.println("     ___________      ");
	    		System.out.println("     |/         |     ");
	    		System.out.println("     |          |     ");
	    		System.out.println("     |         (_)    ");
	    		System.out.println("     |         \\|/    ");
	    		System.out.println("     |                ");
	    		System.out.println("     |                ");
	    		System.out.println("  ___|----__________  ");
	    		break;
	    	case 4:
	    		System.out.println("     ___________      ");
	    		System.out.println("     |/         |     ");
	    		System.out.println("     |          |     ");
	    		System.out.println("     |         (_)    ");
	    		System.out.println("     |         \\|/    ");
	    		System.out.println("     |          |     ");
	    		System.out.println("     |                ");
	    		System.out.println("  ___|----__________  ");
	    		break;
	    	case 3:
	    		System.out.println("     ___________      ");
	    		System.out.println("     |/         |     ");
	    		System.out.println("     |          |     ");
	    		System.out.println("     |         (_)    ");
	    		System.out.println("     |         \\|/    ");
	    		System.out.println("     |          |     ");
	    		System.out.println("     |         /      ");
	    		System.out.println("  ___|----__________  ");
	    		break;
	    	case 2:
	    		System.out.println("     ___________      ");
	    		System.out.println("     |/         |     ");
	    		System.out.println("     |          |     ");
	    		System.out.println("     |         (_)    ");
	    		System.out.println("     |         \\|/    ");
	    		System.out.println("     |          |     ");
	    		System.out.println("     |         / \\   ");
	    		System.out.println("  ___|----__________  ");
	    		break;
	    	case 1:
	    		System.out.println("     ___________      ");
	    		System.out.println("     |/         |     ");
	    		System.out.println("     |          |     ");
	    		System.out.println("     |         (_)    ");
	    		System.out.println("     |         /|\\    ");
	    		System.out.println("     |          |      ");
	    		System.out.println("     |         / \\    ");
	    		System.out.println("  ___|----__________  ");
	    		break;
	    	default: System.out.println("\nNot Possible! "); break;
    	}
    }

    
    
    
}

class VariousTesting {
	
	public static void main(String[] args) throws InterruptedException {

		HangmanGameClass instance = new HangmanGameClass();
		instance.HangmanGame();
		
		System.exit(0);
	
	}
}
