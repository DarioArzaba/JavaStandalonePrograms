import java.util.Scanner;
public class ConsoleXmasTree {
	public static void main(String[] args){
		dividerLine();
		printStars(20); 
    	dividerLine();
		printStarsSquare(4); 
    	dividerLine();
		printStarsSquare(5,10); 
    	dividerLine();
		printTriangle(5); 
   		dividerLine();
		printInvertedTriangle(5); 
    	dividerLine();
		xmasTree(7);
	}
	
	public static void dividerLine(){
		System.out.println("\n--------------------\n");
  	}
	public static void printStars(int numStars){
		int i=0; 
		while(numStars>i){
			System.out.print("*");
			i++;
		}
	}
	public static void printStarsSquare(int size){
		int i = 0; 
		while (size > i){
			printStars(size); 
			System.out.print("\n"); 
			i++;
		}
	}
	public static void printStarsSquare (int height, int width){
		int i = 0; 
		while (height > i){
			printStars(width); 
			System.out.print("\n"); 
			i++;
		}
	}
	public static void printTriangle (int height){
		int i = 0; 
		while (height > i){
			printStars((i+1)); 
			System.out.print("\n"); 
			i++;
		}
	}
	public static void printWhiteSpace (int numSpaces){
		int i = 0; 
		while (numSpaces > i ){
			System.out.print(" "); 
			i++;
		}
	}
	public static void printInvertedTriangle (int height){
		int i = 0; 
		int j = height; 
		while (height > i){
			printWhiteSpace((j-1));
			printStars((i+1));
			System.out.print("\n");
			j--;
			i++;
		}
	}
	public static void xmasTree (int height){
		int i = 0;
		int j = height;
		while (height > i){
			printWhiteSpace((j-1));
			printStars((i+1));
			printStars(i);
			printWhiteSpace((j-1));
			System.out.print("\n");
			j--;
			i++;
			if (height == i){
				int h = 0;
				int k = height;
				while(h < height/2){
					printWhiteSpace((k-2));
					printStars(3);
					System.out.print("\n");
					h++;
				}
			}
		}
	}
}
