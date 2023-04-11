
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

public class StringClass {
	
	public static void main(String[] args) {
		
		//Strings are inmutable after created.
		//Concatenation uses StringBuilder.append() internally
		//Conversions uses toString() from the Object Class
		
		System.out.println("\n --- CONSTRUCTORS ---\n");
		
			//Create empty
			String constructorTest0 = new String();
			System.out.println("0.-  Empty: " + constructorTest0);
			
			//Create from Literal
			String constructorTest1 = "String";
			System.out.println("1.-  Literal:                           " + constructorTest1);
			
			//Create from (new) keyword
			String constructorTest2 = new String("String");
			System.out.println("2.-  New Keyword:                       " + constructorTest2);
			
			//Create from char[] (Char Array)
			char[] charArrayConstructor = {'S', 't', 'r', 'i', 'n', 'g'};
			String constructorTest3 = new String(charArrayConstructor);
			System.out.println("3.-  Char Array:                        " + constructorTest3);
			
			//Create from subset of 3 elements starting at index 1 of char[] (Char Array)
			String constructorTest4 = new String(charArrayConstructor, 1, 3);
			System.out.println("4.-  Char Array Subset:                 " + constructorTest4);
			
			//Create from byte[](Byte Array) with Decimal for UTF-16
			byte[] byteArrayConstructor = {83, 116, 114, 105, 110, 103};
			String constructorTest5 = new String(byteArrayConstructor);
			System.out.println("5.-  Byte Array UTF16:                  " + constructorTest5);
			
			//Create subset of 3 elements starting at index 2 of byte[] (Byte Array)
			String constructorTest6 = new String(byteArrayConstructor, 2, 3);
			System.out.println("6.-  Byte Array Subset UTF16:           " + constructorTest6);
			
			//Create from byte[](Byte Array) with Decimal for standard UTF-8
			String constructorTest7 = new String(byteArrayConstructor, StandardCharsets.UTF_8);
			System.out.println("7.-  Byte Array Standard UTF8:          " + constructorTest7);
			
			//Create subset of 3 elements starting at index 2 of byte[] with Decimal for standard UTF-8
			String constructorTest8 = new String(byteArrayConstructor, 2, 3, StandardCharsets.UTF_8);
			System.out.println("8.-  Byte Array Subset Standard UTF8:   " + constructorTest8);
			
			//Create from byte[](Byte Array) with Decimal for ASCII
			String constructorTest9 = new String(byteArrayConstructor, Charset.forName("ASCII"));
			System.out.println("9.-  Byte Array ASCII:                  " + constructorTest9);
			
			//Create subset of 3 elements starting at index 2 of byte[] with Decimal for UTF-8
			String constructorTest10 = new String(byteArrayConstructor, 2, 3, Charset.forName("UTF-8"));
			System.out.println("10.- Byte Array Subset UTF8:            " + constructorTest10);
			
			//Create from StringBuffer (mutable strings)
			StringBuffer sBuffer = new StringBuffer("String");
			String constructorTest11 = new String(sBuffer);
			System.out.println("11.- StringBuffer:                      " + constructorTest11);
			
			//Create from StringBuilder (String Buffer Alternative)
			StringBuilder sBuilder = new StringBuilder("String");
			String constructorTest12 = new String(sBuilder);
			System.out.println("12.- StringBuilder:                     " + constructorTest12);
			
			//Create subset of 6 elements starting at index 0 int[](Integer Array) with Hexadecimal for UTF-16
			int[] encodingBytes = new int[]{0x0053, 0x74, 0x0072, 0x69, 0x006E, 0x67};
			String constructorTest13 = new String(encodingBytes, 0, 6);
			System.out.println("13.- Int Array UTF16 Hex:               " + constructorTest13);
			
			//Create from Java source code, Unicode scape code literals.
			String constructorTest14 = new String("S" + "\u0074" + "\u0072" + "\u0069" + "\u006E" + "g");
			System.out.println("14.- Unicode Scape Codes:               " + constructorTest14);
			
			//Create from String[] (String Array). Print with: Arrays.toString(String[] strArray)
			String[] rawStrings = {"A", "hello", "b", "f", "d", "Ea", "C"};
			System.out.println("15.- String Array:                      " + Arrays.toString(rawStrings));
			
			//Sort a String[] (String Array) in an Alphabetical, Case Insensitive Order).
			Arrays.sort(rawStrings, String.CASE_INSENSITIVE_ORDER);
			System.out.println("16.- String Array Alphabetical:         " + Arrays.toString(rawStrings));
			
			//NOTE: If you want to catch UnsupportedEncodingException e it is adviced to: e.printStackTrace();
		
		System.out.println("\n --- METHODS ---\n");
		
			String test = "Hello World!";
			
			//Print the String.
			System.out.println("1.-  Print:                             " + test);
			
			//Convert String to String (Useless method inherited from Object).
			System.out.println("2.-  To String (Useless):               " + test.toString());
			
			//Returns the number of characters in the String.
			System.out.println("3.-  Get Length:                        " + test.length());
			
			//Tests if the String is an Empty String, meaning it has 0 characters.
			System.out.println("4.-  Is Empty:                          " + test.isEmpty());
			
			//Returns the character at index 4 of the String, starting at 0
			System.out.println("5.-  Char at index 4:                   " + test.charAt(4));
			
			//Deletes any whitespace at the end or the start of the String
			System.out.println("6.-  Trim Trailing Whitespace:          " + test.trim());
			
			//Adds or concatenates another string at the end of the current one.
			System.out.println("7.-  Concatenate (Bye):                 " + test.concat(" Bye"));
			
			//Find and replace every matching substring.
			System.out.println("8.-  Replace every (l) with (zz):       " + test.replace("l", "zz"));
			
			//True if every character of the String matches the Regex
			//Without the final plus sign it will match a subset instead of the hole string.
			System.out.println("9.-  Match with Regex (Hello):          " + test.matches("[HELLO]+"));
			System.out.println("10.- Match with Regex (a-zA-Z,! ):      " + test.matches("[a-zA-Z! ]+"));
		
			//Test if String contains a subset based on a CharSequence object.
			CharSequence testCharSequence = "World";
			System.out.println("11.- Contains CharSequence (World):     " + test.contains(testCharSequence));
			
			//Replace the first ocurrance of the subset that matches a regex with another string.
			System.out.println("12.- Replace First (lo) with (ar):      " + test.replaceFirst("lo", "ar"));
			
			//Replace all ocurrances of a subset that matches a regex with another string.
			System.out.println("13.- Replace Every ([A-Z]) with (x):    " + test.replaceAll("[A-Z]", "x"));
			
			//Split the String into multiple strings and store them in a String array using a regex separator.
			String[] splitArray = test.split("\\s+");
			System.out.println("14.- Split into a String Array (\\s):    " + Arrays.toString(splitArray));
			
			//Tests if the string is equal to another string object with the same char info.
			System.out.println("15.- Equals (tree):                     " + test.equals("tree"));
			
			//Tests if the string is equal to a String Buffer object with the same char info.
			StringBuffer testStringBuffer = new StringBuffer("Hello World!");
			System.out.println("16.- Equals sBuffer (Hello World!):     " + test.contentEquals(testStringBuffer));
			
			//Tests if the string is equal to a Char Sequence object with the same char info.
			CharSequence testCharSequence2 = "Hello";
			System.out.println("17.- Equals cSequence (Hello):          " + test.contentEquals(testCharSequence2));
		
			//Tests if the string is equal to another string object with the same char info ignoring upper case.
			System.out.println("18.- Equals (HELLO WORLD!) no case:     " + test.equalsIgnoreCase("HELLO WORLD!"));
			
			//Tests if a subset of another string matches a region on the original string
			System.out.println("19.- Region matches (llo Wo) :          " + test.regionMatches(2, "Subllo Working", 3, 6));
		
			//Tests if a subset of another string matches a region from the original string ignoring upper case
			System.out.println("20.- Region matches (LO WOR) no case:   " + test.regionMatches(true, 3, "SUBLLO WORKING", 4, 6));
			
			//Tests if the string starts with a subset
			System.out.println("21.- Starts With (Hel):                 " + test.startsWith("Hel"));
		
			//Tests if the string has a subset using the start of the string and an offset
			System.out.println("22.- Starts With (llo) with a 2 offset: " + test.startsWith("llo", 2));
		
			//Tests if the string ends with a subset
			System.out.println("23.- Ends With (orld!):                 " + test.endsWith("orld!"));
		
			//Returns the same string but with lower case codes for every character
			System.out.println("24.- String to Lower Case:              " + test.toLowerCase());
		
			//Returns the same string but with upper case codes for every character
			System.out.println("25.- String to Upper Case:              " + test.toUpperCase());
		
			//Returns the same string but with lower case codes using a specific locale
			System.out.println("26.- To Lower Case (Default Locale):    " + test.toLowerCase(Locale.getDefault()));
		
			//Returns the same string but with upper case codes using a specific locale
			System.out.println("27.- To Upper Case (Turkish Locale):    " + test.toUpperCase(new Locale("tr", "TR")));
		
			//Returns the index of the first subset that matches the argument string
			System.out.println("28.- Index of (or):                     " + test.indexOf("or"));
		
			//Returns the index of the first subset that matches the argument string starting with an offset
			System.out.println("29.- Index of (o) from 5:               " + test.indexOf("o", 5));
		
			//Returns the index of the last subset that matches the argument string
			System.out.println("30.- Last Index of (el):                " + test.lastIndexOf("el"));
		
			//Returns the index of the last subset that matches starting with an offset from the end.
			System.out.println("31.- Last Index of (o) from 5:          " + test.lastIndexOf("o", 5));
			
			//Returns the decimal UTF16 Codepoint at some index
			System.out.println("32.- Decimal UTF-16 codepoint at 1:     " + test.codePointAt(1));
			
			//Returns the decimal UTF16 Codepoint at the character just before the specified index
			System.out.println("33.- Decimal UTF-16 codepoint before 1: " + test.codePointBefore(1));
			
			//Returns the number of Codepoints in the specified subset of the string.
			//UTF16 sometimes uses surrogate pairs for high codepoints. Lenght method will also get confused!
			String test2 = new String("H" + "\uD83C\uDF54" + "\uD83C\uDF55" + "I");
			System.out.println("34.- Codepoints from index 0 to 6:      " + test2.codePointCount(0, 6));
		
			//Returns the index of the character that is a number of codepoints away starting from a codepoint offset
			System.out.println("35.- Index of char 4 CP away from 1:    " + test.offsetByCodePoints(1, 4));
		
			//Returns the subset that starts at the specified index and ends with the string.
			System.out.println("36.- Sub-String from index 7:           " + test.substring(7));
		
			//Returns the subset within the specified start and ending index
			System.out.println("37.- Sub-String from index 2 - 8:       " + test.substring(2, 8));
		
			//Returns the subset within the specified start and ending index as a Char Sequence
			System.out.println("38.- Sub-CharSeq from index 2 - 8:      " + test.subSequence(2, 8));
			
			//Computes and returns a unique hash for the specified string using the int values of the characters
			System.out.println("39.- Computes a Hash for the String:    " + test.hashCode());
		
			//Transforms the string into a byte array using the default Charset of UTF16
			System.out.println("40.- To Byte Array (Default UTF-16):    " + Arrays.toString(test.getBytes()));
		
			//Transforms the string into one of the standard Charsets, in this case UTF16BE
			System.out.println("41.- To Byte Array in STD UTF-16BE:     " + Arrays.toString(test.getBytes(StandardCharsets.UTF_16BE)));
		
			//Transforms the string into a Char Array
			System.out.println("42.- To Char Array:                     " + Arrays.toString(test.toCharArray()));
		
			//Copies the chars from a substring of the parent string and places them in a char array.
			//The last argument is the offset of the char array from which to start placing characters
			char[] charArrayTest = {'.', '.', '.', '.', '.', ' ', 'W', 'o', 'r', 'l', 'd', '!'};
			System.out.println("Create New Char Array:                  " + Arrays.toString(charArrayTest));
			test.getChars(0, 5, charArrayTest, 0);
			System.out.println("43.- Copy subset (0-5) into cArray:     " + Arrays.toString(charArrayTest));
			
			//Lexicographic Order: Comparacion entre dos strings usando sus valores unicode UTF16
			//Si dos strings son diferentes entonces hay tres posibilidades:
			//1.- Tienen el mismo largo pero distintos caracteres
			//2.- Tienen distinto largo
			//3.- Tienen distinto largo y distintos caracteres.
			//Si comparamos los strings y encontramos un index (n) con distintos caractes decimos que:
			//El string con el caracter en (n) que tiene el menor valor unicode es lexicograficamente menor.
			//El metodo (Compareto) regresa la diferencia entre los valores unicode del primer caracter distinto.
			//El metodo (CompareToIgnoreCase) regresa lo mismo pero ignora el upper case.
		
			//En este caso la diferencia unicode entre (!) y (espacio) es de 1 (21 y 20)
			System.out.println("43.- Compare to (Hello World Too!):     " + test.compareTo("Hello World Too!"));
		
			//En este caso la diferencia unicode entre (W) y (p) ignorando case es de 7 (119 y 112)
			System.out.println("44.- Compare (hello pluto!) no case:    " + test.compareToIgnoreCase("hello pluto!"));
		
		
		System.out.println("\n --- STATIC METHODS --- \n");
		
			String staticTest = "Hello World!";
			
			//Joins CharSequence (Strings) starting with the delimiter.
			System.out.println("1.- Join strings with delimiter:        " + String.join("-", "Hello", "World", "!"));
			
			//Join an Iterable CharSequence (LinkedHashSet)
			Set<String> iterableStringSet = new LinkedHashSet<>();
			iterableStringSet.add("Hello");
			iterableStringSet.add("World");
			iterableStringSet.add("!");
			System.out.println("2.- Join Iterable with delimiter:       " + String.join("-", iterableStringSet));
			
			//Print arguments with specified format.
			//This string format prints the first 8 characters from a string.
			System.out.println("3.- Apply string formating:             " + String.format("%.8s", staticTest));
			
			//This string format prints the first 3 characters from a string using JAPAN Locale format.
			//https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
			System.out.println("4.- String formating with locale:       " + String.format(Locale.JAPAN, "%.4s", staticTest));
			
			char[] charArrayTest2 = test.toCharArray();
			
			//Return the string representation of a general object
			//The value of the Object.toString method is returned.
			System.out.println("5.- Value of Object (String):           " + String.valueOf(test));
		
			//Return the string representation of a Char Array
			//Note that the char array elements are joined.
			System.out.println("6.- Value of Char Array:                " + String.valueOf(charArrayTest2));
		
			//Return the string representation of a Char Array with an offset.
			System.out.println("7.- Value of cArray offset 2 - size 4:  " + String.valueOf(charArrayTest2, 2, 4));
		
			//Equivalent to String.valueOf(char[]).
			System.out.println("8.- Copy Value of Char Array:           " + String.copyValueOf(charArrayTest2));
		
			//Equivalent to String.valueOf(char[], offset, size).
			System.out.println("9.- Copy Value of Char Array (Offset):  " + String.copyValueOf(charArrayTest2, 2, 4));
			
			//Returns the string representation of the Char value.
			//Generates a string of size (1) with a unique character equal to the one specified
			System.out.println("10.- Value of Char (a):                 " + String.valueOf('a'));
		
			//Returns the string representation of the Int value.
			//Identical to Int.toString method.
			System.out.println("11.- Value of Int:                      " + String.valueOf(3));
		
			//Returns the string representation of the Long value.
			//Identical to Long.toString method.
			System.out.println("12.- Value of Long:                     " + String.valueOf(10L));
		
			//Returns the string representation of the Float value.
			//Identical to Float.toString method.
			System.out.println("13.- Value of Float:                    " + String.valueOf(15.1f));
			
			//Returns the string representation of the Double value.
			//Identical to Double.toString method.
			System.out.println("14.- Value of Double:                   " + String.valueOf(15.12));
			
			//Returns the string representation of the Boolean value.
			// Meaning (true) or (false) as a string.
			System.out.println("15.- Value of Boolean:       " + String.valueOf(false));
	  
		System.out.println("\n --- STRING POOLING ---");
		
			//String literales se internalizan con String.intern().
			//Dos strings literales con la misma data seran referencias a un mismo objeto del String Pool.
			//Esto ultimo es posible gracias a la informacion del objeto es inmutable.
			//Esto se denomina canonicalizacion (string canonicalization)
			//Ya que se generan representaciones canonicas de un solo objeto con la misma informacion.
			//Una de las principales razones es para que el GC limpie las copias (interns) sin ocupar.
			
			//This string is created from a literal and therefore is internalized into the String Pool.
			String StringM1 = "String 1";
			System.out.println("\nFirst Literal String:            " + StringM1);
			
			//This string is created from a literal and it is also internalized.
			//Having different information from the first string means it has a different location in the pool
			String StringM2 = "String 2";
			System.out.println("Second Literal String:           " + StringM2);
			
			//This string is canonicalized with the information of StringM1
			//Same information means Java copies the Memory Location Reference of StringM1 into this String variable.
			//Now StringM1 and StringM3 are references to the same String Object in the pool.
			String StringM3 = "String 1";
			System.out.println("Third Literal String:            " + StringM3);
			
			//Comparing StringM1 and StringM3 Java sees that they reference the same object in the pool.
			//Java concludes that therefore their content must be the same.
			System.out.println("\nStringM1 == StringM3:            " + (StringM1==StringM3));
			
			//This string is not created from a literal, so its not internalized.
			//However its content its the same as StringM1.
			//When comparing the variables Java sees that they reference different objects.
			//Java concludes that if they reference different objects therefore their content must be different.
			//Even though both objects contain the same information.
			String StringM4 = new String("String 1");
			System.out.println("\nFourth New String:               " + StringM4);
			System.out.println("\nStringM1 == StringM4:            " + (StringM1==StringM4));
			
			//Using the string method Equals is slower.
			//But will make sure we are comparing the information and not the references of the String object variables.
			System.out.println("\nStringM1.equals(StringM4):       " + (StringM1.equals(StringM4)));
		
	}
	
}
