import java.util.Arrays;


public class StringBuilderClass {

	public static void main(String[] args){
		
		//Mutable Strings.
		//Compatible with StringBuffer at no garantee of synchronization.
		//Faster alternative to StringBuffer when the buffer is limited to a single thread.
		
		System.out.println("\n --- CONSTRUCTORS ---\n");
		
			//Create empty. Capacity of 16 Char.
			StringBuilder constructorTest0 = new StringBuilder();
			System.out.println("0.-  Empty (16 Char):                                  " + constructorTest0);
			
			//Create empty with initial capacity specified.
			StringBuilder constructorTest1 = new StringBuilder(30);
			System.out.println("1.-  Empty (Specific Char):                            " + constructorTest1);
			
			//Create from CharSequence.
			CharSequence charSequence = "Hello World!";
			StringBuilder constructorTest2 = new StringBuilder(charSequence);
			System.out.println("2.-  From Char Sequence:                               " + constructorTest2);
			
			//Create from String
			StringBuilder constructorTest3 = new StringBuilder("Hello World!");
			System.out.println("3.-  From String:                                      " + constructorTest3);
		
		System.out.println("\n --- METHODS ---\n");
		
			StringBuilder test = new StringBuilder("Hello World!");
			
			//Appends the string representation of a boolean at the end of the String Builder.
			System.out.println("1.- Appends a boolean (true):                          " + test.append(true));
			
			//Appends the string representation of a Char at the end of the String Builder.
			System.out.println("2.- Appends a Char (Z):                                " + test.append('Z'));
			
			//Appends a String at the end of the String Builder.
			System.out.println("3.- Appends a String (zZz):                            " + test.append("zZz"));
			
			//Appends the string representation of a Char Array at the end of the String Builder.
			char[] charArrayTest = {'B', 'y', 'e'};
			System.out.println("4.- Appends a Char Array (Bye):                        " + test.append(charArrayTest));
			
			//Appends a subset of the Char Array at the end of the String Builder with a specific Offset and Size.
			System.out.println("5.- Appends a cArray with offset and len (y):          " + test.append(charArrayTest, 1, 1));
			
			//Appends the string representation of a Char Sequence at the end of the String Builder.
			CharSequence charSequenceTest = "Bye";
			System.out.println("6.- Appends a Char Sequence (Bye):                     " + test.append(charSequenceTest));
			
			//Appends a Subset of the cSequence at the end of the String Builder with a specific Offset and Size.
			System.out.println("7.- Appends a cSequence with offset and len (y):       " + test.append(charSequenceTest, 1, 1));
			
			//Appends a the string representation of a Double at the end of the String Builder.
			System.out.println("8.- Appends a Double (15.2):                           " + test.append(15.2));
			
			//Appends a the string representation of a Float at the end of the String Builder.
			System.out.println("9.- Appends a Float (3.1f):                            " + test.append(3.1f));
			
			//Appends a the string representation of a Int at the end of the String Builder.
			System.out.println("10.- Appends a Int (96):                               " + test.append(96));
			
			//Appends a the string representation of a Long at the end of the String Builder.
			System.out.println("11.- Appends a Long (43L):                             " + test.append(43L));
			
			//Appends a the string representation of a StringBuffer at the end of the String Builder.
			StringBuffer stringBufferTest = new StringBuffer("Hi");
			System.out.println("12.- Appends a StringBuffer (Hi):                      " + test.append(stringBufferTest));
			
			//Appends a the string representation of a Decimal UTF16 Codepoint at the end of the String Builder.
			test.appendCodePoint(0xD83C);
			System.out.println("13.- Appends a CodePoint Char (0xD83C Pizza):          " + test.appendCodePoint(0xDF55));
			
			StringBuilder test2 = new StringBuilder("Hello World!");
			
			//Inserts the string rep of a Boolean at the offset (2) of the String Builder
			System.out.println("14.- Inserts offset (2) boolean (false):               " + test2.insert(2, false));
			
			//Inserts the string rep of a Char at the offset (2) of the String Builder
			System.out.println("15.- Inserts offset (2) Char (Z):                      " + test2.insert(2, 'Z'));
			
			//Inserts the string rep of a String at the offset (2) of the String Builder
			System.out.println("16.- Inserts offset (2) String (zZz):                  " + test2.insert(2, "zZz"));
			
			//Inserts the string representation of a Char Array at the offset (2) of the String Builder
			char[] charArrayTest2 = {'B', 'y', 'e'};
			System.out.println("17.- Inserts offset (2) Char Array (Bye):              " + test2.insert(2, charArrayTest2));
			
			//Inserts a subset of the cArray at the offset (2) of the String Builder with a specific Offset and Size.
			System.out.println("18.- Inserts offset (2) cArray offset (y):             " + test2.insert(2, charArrayTest2, 1, 1));
			
			//Inserts the string representation of a Char Sequence at the offset (2) of the String Builder
			CharSequence charSequenceTest2 = "Bye";
			System.out.println("19.- Inserts offset (2) Char Sequence (Bye):           " + test2.insert(2, charSequenceTest2));
			
			//Inserts a Subset with an Offset and Size from the cSequence into the offset (2) of the String Builder
			System.out.println("20.- Inserts offset (2) cSequence offset(y):           " + test2.insert(2, charSequenceTest2, 1,1));
			
			//Inserts the string rep of a Double at the offset (2) of the String Builder
			System.out.println("21.- Inserts offset (2) Double (15.2):                 " + test2.insert(2, 15.2));
			
			//Inserts the string rep of a Float at the offset (2) of the String Builder
			System.out.println("22.- Inserts offset (2) Float (3.1f):                  " + test2.insert(2, 3.1f));
			
			//Inserts the string rep of a Int at the offset (2) of the String Builder
			System.out.println("23.- Inserts offset (2) Int (96):                      " + test2.insert(2, 96));
			
			//Inserts the string rep of a Long at the offset (2) of the String Builder
			System.out.println("24.- Inserts offset (2) Long (43L):                    " + test2.insert(2, 43L));
			
			//This method returns the current char capacity of the string builder
			System.out.println("25.- Get StringBuilder Capacity:                       " + test2.capacity());
			
			//Returns the character at the specified index
			System.out.println("26.- Character at index (0):                           " + test2.charAt(0));
			
			//Returns the Code Point of the character at the specified index
			System.out.println("27.- Codepoint at index (4):                           " + test2.codePointAt(4));
			
			//Returns the Code Point of the character just before the specified index
			System.out.println("28.- Codepoint before index (4):                       " + test2.codePointBefore(4));
			
			//Returns the number of CodePoints between the specified Subset of the StringBuilder
			System.out.println("29.- How many codepoints between (0-3):                " + test2.codePointCount(0,3));
			
			//Deletes the characteres in the specified Subset of the StringBuilder
			System.out.println("30.- Delete characters between (5-10):                 " + test2.delete(5, 10));
			
			//Deletes the character in the specified index of the StringBuilder
			System.out.println("31.- Delete character at index (7):                    " + test2.deleteCharAt(7));
			
			//This void method ensures that the capacity is at least equal to the specified number
			//If the number is lower than the current capacity then the new capacity is the current double plus two
			test2.ensureCapacity(60);
			System.out.println("32.- Expand the capacity to at least 60 char (Void):   " + test2.capacity());
			
			//Copies the characters in the subset of the StringBuilder into a Char Array with an offset
			//Note that the Char Array needs to be bigger than the Subset to acomodate every character.
			char[] charArrayTest3 = {'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'b', 'i', 'g'};
			test2.getChars(2, 5, charArrayTest3, 2);
			System.out.println("33.- Copy characters from sBuilder into cArray:        " + Arrays.toString(charArrayTest3));
			
			//Return the index of the first ocurrance of the specified string inside the String Builder.
			System.out.println("34.- Index of first ocurrance of (e):                  " + test2.indexOf("e"));
			
			//Return the index of the first ocurrance of the specified string inside the String Builder.
			//Start searching for the ocurrance from a specified index of the String Builder.
			System.out.println("35.- Index of first ocurrance of (e), offset (10):     " + test2.indexOf("e", 10));
			
			//Return the index of the last ocurrance of the specified string inside the String Builder
			System.out.println("36.- Index of last ocurrance of (e):                   " + test2.lastIndexOf("e"));
			
			//Return the index of the last ocurrance of the specified string inside the String Builder.
			//Start searching for the ocurrance from a specified offset at the end of the String Builder.
			System.out.println("37.- Index of last ocurrance of (e), offset (10):      " + test2.lastIndexOf("e", 10));
			
			//Return the lenght of the String Builder starting from 1 and counting codepoints.
			System.out.println("38.- Lenght of the String Builder:                     " + test2.length());
			
			//Return the index of the character with the offset of codepoints relative to another index.
			//Here we start at index 0 and move 3 codepoints to arribe to "some" char. The method returns the char index.
			//Useful if charAt(i) is wrong because of surrogate codepoints.
			System.out.println("39.- Index of char with a codepoint offset of (3):     " + test2.offsetByCodePoints(0,3));
			
			//Replace the characters from a subset with the characters of the string.
			System.out.println("40.- Replace char from subset with char from string:   " + test2.replace(2,7, "Hello"));
			
			//Returns the reversed character sequence of this String Builder
			System.out.println("41.- Reverse the String Builder:                       " + test2.reverse());
			
			//Replaces the character at the specified index with another character.
			test2.setCharAt(0, 'X');
			System.out.println("42.- Replace character at some index:                  " + test2);
			
			//Replaces the character at the specified index with another character.
			test2.setLength(40);
			System.out.println("43.- Sets a new length for the String Builder:         " + test2.length());
			
			//Gets the characters from the specified Subset and returns a CharSequence equal to those characters.
			System.out.println("44.- Get Char Sequence from Subset (2-5):              " + test2.subSequence(2,5));
			
			//Gets the chars from this offset until the end of the sBuilder and returns a String from those char.
			System.out.println("45.- Get String from subset offset (7):                " + test2.substring(7));
			
			//Gets the chars from this index range of the sBuilder and returns a String from those char.
			System.out.println("46.- Get String from subset (7 - 11):                  " + test2.substring(7, 11));
			
			//Return a literal string based on the object representation of the data in the String Builder.
			System.out.println("47.- Get String from String Builder:                   " + test2.toString());
			
			//Return the index of the last ocurrance of the specified string inside the String Builder
			test2.trimToSize();
			System.out.println("48.- Reduce capacity to minimum required:              " + test2);
		
		
	}
}
