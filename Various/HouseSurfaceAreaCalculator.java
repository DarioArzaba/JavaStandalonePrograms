package Various;

/**
 House Surface Area Calculator.
 <p>This calculator estimates the surface area of a simple house abstraction.
 <p>It assumes the house is a box with a certain set of windows and doors of the same size.
 
 @author Dario Arzaba
 @version 1.0
*/

public class HouseSurfaceAreaCalculator {
	
	double width, length, height;
	double windowWidth, windowLength;
	double doorWidth, doorLength;
	int numberWindows, numberDoors;
	
	/**
	 This constructor creates a house surface calculator with some default values. The house is a cube of 10, windows are squares of 2 and doors are 3x1. Number of doors is 2 and number of windows is 3.
	 */
	public HouseSurfaceAreaCalculator(){
		this.width = 10;
		this.length = 10;
		this.height = 10;
		this.windowWidth = 2;
		this.windowLength = 2;
		this.doorWidth = 3;
		this.doorLength = 1;
		this.numberDoors = 2;
		this.numberWindows = 3;
	}
	
	/**
	 This constructor creates a house surface calculator with the specified values.
	 
	 @param	w Width of the house.
	 @param l Length of the house.
	 @param h Height of the house.
	 @param windowW Width of the windows.
	 @param windowL Lenfth of the windows.
	 @param doorW Width of the doors.
	 @param doorL Length of the doors.
	 @param windowN Number of Windows.
	 @param doorN Number of Doors.
	 */
	public HouseSurfaceAreaCalculator(double w, double l, double h, double windowW, double windowL, double doorW, double doorL, int windowN, int doorN){
		this.width = w;
		this.length = l;
		this.height = h;
		this.windowWidth = windowW;
		this.windowLength = windowL;
		this.doorWidth = doorW;
		this.doorLength = doorL;
		this.numberDoors = doorN;
		this.numberWindows = windowN;
	}
	
	/**
	 This method returns the total surface area of the house based on the instance data.
	 @return totalSurfaceArea Surface area of the house.
	 */
	public double getHouseSurfaceArea(){
		double areaRoof = (width*length);
		double areaFrontBack = ((length*height)*(2));
		double areaLateral = ((width*height)*(2));
		double totalArea = (areaRoof + areaFrontBack + areaLateral);
		double areaWindow = ((windowWidth * windowLength) * numberWindows) ;
		double areaDoor = ((doorWidth * doorLength) * numberDoors) ;
		double totalSurfaceArea = (totalArea - (areaWindow + areaDoor));
		return totalSurfaceArea;
	}
	
	/**
	 This method prints the surface area of this instance to the Console.
	 */
	public void printHouseSurfaceArea() {
		System.out.println("The surface area of the house is: " + getHouseSurfaceArea());
	}
	
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWindowWidth() {
		return windowWidth;
	}
	public void setWindowWidth(double windowWidth) {
		this.windowWidth = windowWidth;
	}
	public double getWindowLength() {
		return windowLength;
	}
	public void setWindowLength(double windowLength) {
		this.windowLength = windowLength;
	}
	public double getDoorWidth() {
		return doorWidth;
	}
	public void setDoorWidth(double doorWidth) {
		this.doorWidth = doorWidth;
	}
	public double getDoorLength() {
		return doorLength;
	}
	public void setDoorLength(double doorLength) {
		this.doorLength = doorLength;
	}
	public int getNumberWindows() {
		return numberWindows;
	}
	public void setNumberWindows(int numberWindows) {
		this.numberWindows = numberWindows;
	}
	public int getNumberDoors() {
		return numberDoors;
	}
	public void setNumberDoors(int numberDoors) {
		this.numberDoors = numberDoors;
	}
	
	
}

class VariousTesting8 {
	
	public static void main(String[] args) {

		HouseSurfaceAreaCalculator instance = new HouseSurfaceAreaCalculator();
		instance.printHouseSurfaceArea();

		System.exit(0);
	
	}
}