package Various;

import java.lang.Thread;

/**
 Robot Lawn Mower
 <p>This program demonstrates the use of an algorithm for a robot inside a room to touch and chanve the value of every position provided it has been placed in a corner.
 
 @author Dario Arzaba
 @version 1.0
 */

public class RoboticLawnMower {
	
	private int[][] matrix;
	private int wall = 1, cutGrass = 2, grass = 3, robot = 4;
	private int rows, columns, robotX, robotY, dir = 4;
	private int up = 1, left = 2, down = 3, right = 4;
	private boolean finished = false;
	private int animationspeed = 250;
	
	/**
	 This constructor uses default values for the size of the room (9x12),for the direction (right) and position of the robot (1,1).
	 */
	public RoboticLawnMower (){
		this.rows = 9;
		this.columns = 12;
		this.robotY = 1;
		this.robotX = 1;
		matrix = new int[rows][columns];
	}
	
	/**
	 This constructor allows the define the values needed to create the room and the robot inside.
	 
	 @param rows Number of rows or Horizontal Lenght of the room.
	 @param columns Number of columns or Vertical Width of the room.
	 @param dir Direction of the robot: Up(1), Left(2), Down(3), Right(4).
	 */
	public RoboticLawnMower (int rows, int columns, int x, int y){
		this.rows = rows;
		this.columns = columns;
		if (robotIsOnCorner(x,y)){
			this.robotX = x;
			this.robotY = y;
		} else {
			this.robotX = 1;
			this.robotY = 1;
		}
		
		
		
		matrix = new int[this.rows][this.columns];
	}
	
	/**
	 This method returns the final countdown of the windows that where placed inside the room.
	 Note: Corner windows are counted as two separate windows.
	 @param printAnimation Boolean that determines if the search for windows is outputed as an animation to the Console.
	 @return An int with the number of windows that the robot found for that particular room.
	 */
	public int cutGrass(boolean printAnimation) throws InterruptedException {
		
		this.matrix = fillRoomWithGrass(this.matrix);
		this.matrix = placeRoomWalls(this.matrix);
		this.matrix = placeRoomRobot(this.matrix);
		
		boolean correctMatrix = false, finished = false;
		int numberGrass = 0;
		
		if (isRoomBigEnoughToSearch()){
			correctMatrix = true;
		}
		
		if (correctMatrix) {
				
				if ((dir == down) || (dir == left) || (dir == right)){
					dir = up;
				}
				
				while (finished == false) {
					
					numberGrass = grassLeft();
					
					if (dir == up) {
						
						if (matrix[robotY - 1][robotX] == grass) {
							matrix[robotY][robotX] = cutGrass;
							numberGrass--;
							robotY--;
						} else {
							dir = right;
						}
						
					} else if (dir == right) {
						
						if (matrix[robotY][robotX + 1] == grass) {
							matrix[robotY][robotX] = cutGrass;
							numberGrass--;
							robotX++;
						} else {
							dir = down;
						}
						
					} else if (dir == down) {
						
						if (matrix[robotY + 1][robotX] == grass) {
							matrix[robotY][robotX] = cutGrass;
							numberGrass--;
							robotY++;
						} else {
							dir = left;
						}
						
					} else if (dir == left) {
						
						if (matrix[robotY][robotX - 1] == grass) {
							matrix[robotY][robotX] = cutGrass;
							numberGrass--;
							robotX--;
						} else {
							dir = up;
						}
						
					}
					
					if (printAnimation) {
						printGrass();
						Thread.sleep(this.animationspeed);
						System.out.print("\n\n Tiles of grass left: " + numberGrass);
					}
					
					if (numberGrass == 0) {
						finished = true;
						if (printAnimation) {
							System.out.print("\n\n Robot: I finished! \n");
						}
					}
					
				}
				
			} else {
			
			numberGrass = 0;
			System.out.print("Error: At least 2 Columns and 1 Row needed!");
			
		}
		
		return  numberGrass;
		
	}
	
	/**
	 This method prints the contents of the room based on the int value that is inside each cell.
	 */
	private boolean robotIsOnCorner (int x, int y){
		if (
				( (x==1) && (y==1) )
						|| ( (x==(this.columns-2)) && (y==1) )
						|| ( (x==1) && (y==(this.rows-2)) )
						|| ( (x==(this.columns-2)) && (y==(this.rows-2)) )
				) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 This method prints the contents of the room based on the int value that is inside each cell.
	 */
	private void printGrass() {
		
		System.out.print("\n");
		
		for (int column = 0; column < this.columns; column++){
			System.out.print("----");
		}
		
		System.out.print("\n");
		
		int lastRow = this.matrix.length;
		int lastColumnInThisRow;
		
		for ( int row=0; row < lastRow; row++){
			
			System.out.print("|");
			
			lastColumnInThisRow = this.matrix[row].length;
			
			for ( int column=0; column < lastColumnInThisRow; column++){
				
				
				if (isRoomBigEnoughForRobot()){
					if (isRobotInTile(row, column)){
						putRobotInTile(row, column);
					}
				}
				
				if (isTileWall(row, column)){
					
					System.out.print(" @ |");
					
				} else if (isTileRobotUp(row, column)) {
					
					System.out.print(" ↑ |");
					
				} else if (isTileRobotLeft(row, column)) {
					
					System.out.print(" ← |");
					
				} else if (isTileRobotDown(row, column)) {
					
					System.out.print(" ↓ |");
					
				} else if (isTileRobotRight(row, column)) {
					
					System.out.print(" → |");
					
				} else if (isTileCutGrass(row, column)) {
					
					System.out.print("   |");
					
				} else if (isTileGrass(row, column)) {
					
					System.out.print(" s |");
					
				}
				
			}
			
			System.out.print("\n");
			
			for (int column = 0; column < this.columns; column++){
				System.out.print("----");
			}
			
			System.out.print("\n");
			
		}
		
		
	}
	
	/**
	 This method fills the Room matrix with the value assigned to the grass.
	 @return New room matrix filled with floor on every coordinate.
	 */
	private int[][] fillRoomWithGrass(int[][] oldRoom) {
		
		int[][] newRoom = oldRoom;
		int lastRow = newRoom.length;
		int lastColumnInThisRow;
		
		for ( int row=0; row < lastRow; row++){
			
			lastColumnInThisRow = newRoom[row].length;
			
			for ( int column=0; column < lastColumnInThisRow; column++) {
				
				newRoom[row][column] = this.grass;
				
			}
			
		}
		
		return newRoom;
		
	}
	
	/**
	 This method places the room walls all along the frame of the room.
	 @return New room matrix with wall values asigned all arround the frame of the room.
	 */
	private int[][] placeRoomWalls(int[][] oldRoom) {
		
		int[][] newRoom = oldRoom;
		int lastRow = newRoom.length;
		int lastColumnInThisRow;
		
		for (int row = 0; row < lastRow; row++) {
			
			lastColumnInThisRow = newRoom[row].length;
			
			for (int column = 0; column < lastColumnInThisRow; column++) {
				
				if 		(
						(column == 0) ||
								(column == (newRoom[row].length - 1)) ||
								(row == 0) ||
								(row == (newRoom.length - 1))
						)
				{
					newRoom[row][column] = this.wall;
				}
				
			}
		}
		
		return newRoom;
		
	}
	
	/**
	 This method places the robot inside the room on its initial given coordinates.
	 @return New room matrix with the robot on its initial coordinates.
	 */
	private int[][] placeRoomRobot(int[][] oldRoom){
		
		int[][] newRoom = oldRoom;
		int lastRow = newRoom.length;
		int lastColumnInThisRow;
		
		for ( int row=0; row < lastRow; row++){
			
			lastColumnInThisRow = newRoom[row].length;
			
			for ( int column=0; column < lastColumnInThisRow; column++) {
				
				if (isRoomBigEnoughForRobot()){
					if (isRobotInTile(row, column)){
						putRobotInTile(row, column);
					}
				}
				
			}
			
		}
		
		return newRoom;
		
	}
	
	/**
	 This method checks if number of rows and columns of the room are sufitient to place the robot inside.
	 @return true if the room has dimentions higher than 3x3
	 */
	private boolean isRoomBigEnoughForRobot(){
		if ((this.rows >= 3) && (this.columns >= 3)){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 This method checks if number of rows and columns of the room are sufitient to start searching
	 @return true if the room has dimentions higher than 2x1
	 */
	private boolean isRoomBigEnoughToSearch(){
		if ((this.rows >= 1) && (this.columns >= 2)){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 This method checks if there is a robot on the current tile with the coordinates given.
	 @param r Value for the row of the current tile.
	 @param c Value for the column of the current tile.
	 @return true if there is a robot on the coordinates (row, column).
	 */
	private boolean isRobotInTile(int r, int c){
		if ((c == this.robotX) && (r == this.robotY)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 This method checks if there is a Wall on the current tile using the coordinates given.
	 @param r Value for the row of the current tile.
	 @param c Value for the column of the current tile.
	 @return true if there is a Wall on the coordinates (row, column).
	 */
	private boolean isTileWall(int r, int c){
		if (matrix[r][c] == this.wall) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 This method checks if there is a Grass on the current tile using the coordinates given.
	 @param r Value for the row of the current tile.
	 @param c Value for the column of the current tile.
	 @return true if there is Grass on the coordinates (row, column).
	 */
	private boolean isTileGrass(int r, int c){
		if (matrix[r][c] == this.grass) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 This method checks if the Grass has been cut on the current tile using the coordinates given.
	 @param r Value for the row of the current tile.
	 @param c Value for the column of the current tile.
	 @return true if there is no Grass on the coordinates (row, column).
	 */
	private boolean isTileCutGrass(int r, int c){
		if (matrix[r][c] == this.cutGrass) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 This method checks if there is a robot on the current tile and its facing upwards.
	 @param r Value for the row of the current tile.
	 @param c Value for the column of the current tile.
	 @return true if there is a robot on the coordinates (row, column) and its facing upwards.
	 */
	private boolean isTileRobotUp(int r, int c){
		if ( isRobotInTile(r,c) && (this.dir == this.up)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 This method checks if there is a robot on the current tile and its facing downwards.
	 @param r Value for the row of the current tile.
	 @param c Value for the column of the current tile.
	 @return true if there is a robot on the coordinates (row, column) and its facing downwards.
	 */
	private boolean isTileRobotDown(int r, int c){
		if ( isRobotInTile(r,c) && (this.dir == this.down)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 This method checks if there is a robot on the current tile and its facing to the Left.
	 @param r Value for the row of the current tile.
	 @param c Value for the column of the current tile.
	 @return true if there is a robot on the coordinates (row, column) and its facing to the Left.
	 */
	private boolean isTileRobotLeft(int r, int c){
		if ( isRobotInTile(r,c) && (this.dir == this.left)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 This method checks if there is a robot on the current tile and its facing to the Right.
	 @param r Value for the row of the current tile.
	 @param c Value for the column of the current tile.
	 @return true if there is a robot on the coordinates (row, column) and its facing to the Right.
	 */
	private boolean isTileRobotRight(int r, int c){
		if ( isRobotInTile(r,c) && (this.dir == this.right)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 This method places the value assigned to the robot in the given coordinates of the Room.
	 @param r Value for the row where the robot is going to be placed.
	 @param c Value for the column where the robot is going to be placed.
	 */
	private void putRobotInTile(int r, int c){
		this.matrix[r][c] = this.robot;
	}
	
	/**
	 This method checks the number of tiles in the room with Grass left.
	 @return numGrass the number of tiles with grass that has not been mowed by the robot.
	 */
	private int grassLeft(){
		
		int numGrass = 0;
		
		int lastRow = this.matrix.length;
		int lastColumnInThisRow;
		
		for ( int row=0; row < lastRow; row++){
			
			lastColumnInThisRow = this.matrix[row].length;
			
			for ( int column=0; column < lastColumnInThisRow; column++) {
				
				if (this.matrix[row][column] == grass){
					numGrass++;
				}
				
			}
			
		}
		
		return numGrass;
	
	}
	
	public void setAnimationspeed(int animationspeed) {
		this.animationspeed = animationspeed;
	}
	
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	public int getRobotX() {
		return robotX;
	}
	public void setRobotX(int robotX) {
		this.robotX = robotX;
	}
	public int getRobotY() {
		return robotY;
	}
	public void setRobotY(int robotY) {
		this.robotY = robotY;
	}



}

