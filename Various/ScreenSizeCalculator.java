package Various;

import java.text.DecimalFormat;

/**
 Screen Size Calculator
 <p>This program gets the horizontal and vertical size of a TV set based on the diagonal size and aspect ratio of width to height.
 
 @author Dario Arzaba
 @version 1.0
 */

public class ScreenSizeCalculator {
	
	private double diagonalSize, width, height, numerator, denominator;
	
	/**
	 This constructor uses a default diagonalSize of 55in and a widescreen aspect ratio of 16 to 9 inches.
	 */
	public ScreenSizeCalculator() {
		this.diagonalSize = 55;
		this.width = 16;
		this.height = 9;
	}
	
	/**
	 This constructor allows the define the values needed for the ScreenSizeCalculator.
	 
	 @param D Double for the Diagonal size of the screen in inches.
	 @param W Double for the Width aspect ratio in inches.
	 @param H Double for the Height aspect ratio in inches.
	 */
	public ScreenSizeCalculator(double D, double W, double H) {
		this.diagonalSize = D;
		this.width = W;
		this.height = H;
	}
	
	/**
	 This method returns the final width screen size in inches.
	 @return A double with the final width screen.
	 */
	public double getScreenWidth () {
		this.numerator = width * width;
		this.denominator = (height * height) + numerator;
		
		/*
			From pythagorean theorem: H^2 + W^2 = D^2
			From aspect ratio: W/H = 16/9
			Let's get the first equation in terms of W by solving H on the second one.
			16H = 9W -> H = ((9W)/(16))
			Substituting H in the first equation
			((9W)/(16))^2 + W^2 = D^2 -> ((81W^2)/(256)) + W^2 = D^2
			((81W^2)/(256)) + ((256W^2)/(256)) = D^2 -> ((337W^2)/(256)) = D^2
			337W^2 = 256D^2 -> W^2 = ((256D^2)/(337)) -> W = sqrt( ((256D^2)/(337)) )
			Substituting the value of D (55 inches)
			W = sqrt( (((256)(55^2))/(337)) ) -> W = 47.93
			Substituting the value of W
			H = ((9W)/(16)) -> H = (((9)(47.93))/(16)) -> H = 26.96
		*/
		
		double W = Math.sqrt( (((numerator)*(diagonalSize*diagonalSize))/(denominator)) );
		return W;
	}
	
	/**
	 This method returns the final Height screen size in inches.
	 @return A double with the final Height screen.
	 */
	public double getScreenHeight () {
		double H = ((height*getScreenWidth())/(width));
		return H;
	}
	
	/**
	 This method prints the final Height screen size in inches.
	 */
	public void printWidth(){
		DecimalFormat newFormat = new DecimalFormat("##.00");
		System.out.print(newFormat.format(getScreenWidth()));
	}
	
	/**
	 This method prints the final Height screen size in inches.
	 */
	public void printHeight(){
		DecimalFormat newFormat = new DecimalFormat("##.00");
		System.out.print(newFormat.format(getScreenHeight()));
	}
	
	/**
	 This method prints the final Height and Width, as well as the initial diagonal size and aspect ratio.
	 */
	public void printAll(){
		DecimalFormat WHFormat = new DecimalFormat("##");
		System.out.println("\nDiagonal Size : " + diagonalSize);
		System.out.println("Aspect Ratio :  [" + WHFormat.format(width) + ":" + WHFormat.format(height) + "]");
		DecimalFormat newFormat = new DecimalFormat("##.00");
		System.out.println("\nWidth : ");
		printWidth();
		System.out.println("\nHeight : ");
		printHeight();
	}
	
	public double getDiagonalSize() {
		return diagonalSize;
	}
	public void setDiagonalSize(double diagonalSize) {
		this.diagonalSize = diagonalSize;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
}

