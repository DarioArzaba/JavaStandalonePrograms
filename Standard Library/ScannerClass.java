
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerClass {
	
	public static void main(String[] args) throws IOException {
		
		//Text scanner for parsing primitive types and strings with regex
		//Breaks input into tokens via delimiter patterns (default whitespace).
		//Tokens can be converted to their intended values and types.
		//Boolean, Byte, Short, Int, Long, Float, Double, BigInteger and BigDecimal with Redix as argument.
		//Scanner.in as source for user input, \n as delimeter in NextLine.
		//Will read text from any object implementing Readable Interface
		//Readable.read method throws IOException and the scanner will asume end of input.
		//Closing a scanner closes its input source if the source implements Closeable interface.
		//Not safe for multithreaded use without synchronization.
		
		System.out.println("\n --- CONSTRUCTORS ---\n");
		
			//Create from Readable Object (StringReader)
			StringReader readableObj = new StringReader("Hello World!\n");
			Scanner constructorTest1 = new Scanner(readableObj);
			System.out.println("1.-  Readable Object:                               " + constructorTest1.nextLine());
			constructorTest1.close();
			
			File file = new File("text.txt");
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Hello World!\nHello World!\n");
			bw.close();
			
			//Create from InputStream, meaning raw bytes input.
			FileInputStream inputStreamConstructor = new FileInputStream("text.txt");
			Scanner constructorTest2 = new Scanner(inputStreamConstructor);
			System.out.println("2.-  Input Stream:                                  " + constructorTest2.nextLine());
			constructorTest2.close();
			inputStreamConstructor.close();
			
			//Create from InputStream with specified Charset to translate the bytes.
			FileInputStream inputStreamConstructor2 = new FileInputStream("text.txt");
			Scanner constructorTest3 = new Scanner(inputStreamConstructor2, StandardCharsets.UTF_8.name());
			System.out.println("3.-  Input Stream with Charset:                     " + constructorTest3.nextLine());
			constructorTest3.close();
			inputStreamConstructor2.close();
			
			//Create from File
			Scanner constructorTest4 = new Scanner(file);
			System.out.println("4.-  File:                                          " + constructorTest4.nextLine());
			constructorTest4.close();
			
			//Create from File with specified Charset to translate the bytes.
			Scanner constructorTest5 = new Scanner(file, StandardCharsets.US_ASCII.name());
			System.out.println("5.-  File with Charset:                             " + constructorTest5.nextLine());
			constructorTest5.close();
			
			//Create from system Path to source
			Scanner constructorTest6 = new Scanner(FileSystems.getDefault().getPath("text.txt"));
			System.out.println("6.-  Path:                                          " + constructorTest6.nextLine());
			constructorTest6.close();
		 
			//Create from system Path to source with specified Charset to translate the Bytes
			Scanner constructorTest7 = new Scanner(FileSystems.getDefault().getPath("text.txt"), StandardCharsets.ISO_8859_1.name());
			System.out.println("7.-  Path with Charset:                             " + constructorTest7.nextLine());
			constructorTest7.close();
			
			//Create from Readable Byte Channel
			FileInputStream inputStreamConstructor3 = new FileInputStream("text.txt");
			Scanner constructorTest8 = new Scanner(inputStreamConstructor3.getChannel());
			System.out.println("8.-  Readable Byte Channel:                         " + constructorTest8.nextLine());
			constructorTest8.close();
			inputStreamConstructor3.close();
			
			//Create from Readable Byte Channel with specified Charset to translate the Bytes
			FileInputStream inputStreamConstructor4 = new FileInputStream("text.txt");
			Scanner constructorTest9 = new Scanner(inputStreamConstructor4.getChannel(), StandardCharsets.UTF_8.name());
			System.out.println("9.-  Readable Byte Channel:                         " + constructorTest9.nextLine());
			constructorTest9.close();
			inputStreamConstructor4.close();
			
			//Create from String
			Scanner constructorTest10 = new Scanner("Hello World!");
			System.out.println("10.- String:                                        " + constructorTest10.nextLine());
			constructorTest10.close();
		
		System.out.println("\n --- METHODS ---\n");
		
	    
			String testText = "El veloz murciélago hindú comía feliz cardillo y kiwi.\nEl veloz murciélago hindú comía feliz cardillo y kiwi.";
			Scanner test = new Scanner(testText);
			System.out.println("0.-  Test Input:                                    " + test.nextLine());
			
			//Gets next token using default delimiter (whitespace)
			System.out.println("1.-  Token:                                         " + test.next());
			
			//Gets the delimeter that the scanner is currently using to parse the tokens.
			System.out.println("2.-  Delimiter Used:                                " + test.delimiter());
			
			//Changes the delimeter pattern based on a string.
			//Internamente Java utiliza el metodo Pattern.compile(String)
			String pattern = "i";
			test.useDelimiter(pattern);
			System.out.println("3.-  Change delimiter String to (i):                " + test.next());
			System.out.println("     Delimiter now:                                 " + test.delimiter());
			
			//Changes the delimeter pattern using a pattern object.
			test.useDelimiter(Pattern.compile("co"));
			System.out.println("4.-  Change delimiter w/Pattern to (co):            " + test.next());
			System.out.println("     Delimiter now:                                 " + test.delimiter());
			test.useDelimiter(Pattern.compile("\\p{javaWhitespace}+"));
	
			//Get the current Locale (Geographical Region) for the Scanner parsing.
			System.out.println("5.-  Locale:                                        " + test.locale());
			
			//Change the Locale (Geographical Region) used for the Scanner parsing.
			test.useLocale(Locale.JAPAN);
			System.out.println("6.-  Change Locale (JAPAN):                         " + test.locale());
			test.useLocale(Locale.getDefault());
			
			//Get the current Redix or system number base for the numeric parsing values.
			System.out.println("7.-  Current Radix (System Number Base):            " + test.radix());
			
			Scanner test2 = new Scanner("125 1111101\n125 1111101\n");
			System.out.println("     New Test Input:                                " + test2.nextLine());
			
			//Using current decimal Radix get the next token as an Integer (125).
			System.out.println("8.-  Get next Int (125) with radix 10:              " + test2.nextInt());
			
			//Using a binary radix of 2 get the next token (1111101) as an Integer.
			test2.useRadix(2);
			System.out.println("9.-  Change Radix (2) for next Int (1111101):       " + test2.nextInt());
			test2.close();
			
			//Skip a string or pattern beffore continuing the source parsing.
			Scanner test3 = new Scanner(testText);
			test3.skip("El veloz");
			System.out.println("10.- Skip String (El veloz):                        " + test3.next());
			test3.skip(Pattern.compile("[a-zA-Z úíé.]+"));
			
			//Test if the source has another token before attempting to get it.
			System.out.print("11.- Test if it hasNext then print it:              ");
			while(test3.hasNext()) {
					System.out.print(test3.next() + " ");
			}
			System.out.println();
			test3.close();
			
			//Searches this line of text for the pattern, if found it advances the scanner to the end of the match.
			Scanner test4 = new Scanner(testText);
			test4.findInLine("mur");
			System.out.println("12.- Advance Scanner to (mur)                       " + test4.next());
			
			//Searches the text for a pattern, ignoring delimiters and new lines.
			//If found it advances the scanner to the end of the match.
			//The specified horizon is the range of the search and it starts at the current scanner position.
			test4.findWithinHorizon("c", 8);
			test4.findWithinHorizon("c", 12);
			System.out.println("13.- Advance Scanner to (c) after (20) char:        " + test4.next());
			test4.close();
			
			//This method returns a (MatchResult) with the info of the last match performed by the scanner.
			//MatchResult has the (group) method to transform the result into a usable String
			Scanner test5 = new Scanner(testText);
			test5.findInLine("(v.l)([a-z]+)");
			System.out.println("14.- Return the Match Result of the last match:     " + test5.match().group());
			test5.close();
	    
	}
}
