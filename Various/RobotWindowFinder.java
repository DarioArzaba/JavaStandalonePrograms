package Various;

import java.lang.Thread;

/**
 Robot Room Window Finder
 <p>This program demonstrates the use of an algorithm for a robot inside a room to look arround and find out the number of windows inside that room.
 <p>The robot tries to find a corner and use that as the starting and ending point of the search.
 
 @author Dario Arzaba
 @version 1.0
 */

public class RobotWindowFinder {
	
	private int rows, columns, robotX, robotY;
	
	private int[][] matrix;
	private int wall = 1, window = 2, floor = 3, robot = 4;
	private int up = 1, left = 2, down = 3, right = 4;
	private int dir = right;
	private int animationspeed = 250;
	private boolean placeWindows = false;
	
	/**
	 This constructor uses default values for the size of the room (11x12) and for the position of the robot (3,7).
	 */
	public RobotWindowFinder() {
		this.rows = 11;
		this.columns = 12;
		this.robotX = 3;
		this.robotY = 7;
		matrix = new int[rows][columns];
	}
	
	/**
	 This constructor allows the define the values needed to create the room and the robot inside.
	 
	 @param rows Number of rows or Horizontal Lenght of the room.
	 @param columns Number of columns or Vertical Width of the room.
	 @param x Horizontal position of the robot. Cannot be on the frame of the room.
	 @param y Vertical position of the robot. Cannot be on the frame of the room.
	 */
	public RobotWindowFinder(int rows, int columns, int x, int y){
		this.rows = rows;
		this.columns = columns;
		this.robotX = x;
		this.robotY = y;
		matrix = new int[this.rows][this.columns];
	}
	
	/**
	 This method returns the final countdown of the windows that where placed inside the room.
	 Note: Corner windows are counted as two separate windows.
	 @param printAnimation Boolean that determines if the search for windows is outputed as an animation to the Console.
	 @return An int with the number of windows that the robot found for that particular room.
	 */
	public int countWindows(boolean printAnimation) throws InterruptedException {
		
		this.matrix = fillRoomWithFloor(this.matrix);
		this.matrix = placeRoomWalls(this.matrix);
		this.matrix = placeRoomWindows(this.matrix);
		this.matrix = placeRoomRobot(this.matrix);
		
		boolean correctMatrix = false, sameWindow = false, finished = false, foundCorner = false;
		int wallNumber = 1, numberWindows = 0;
		
		if (isRoomBigEnoughToSearch()){
			correctMatrix = true;
		}
		
		if (correctMatrix) {
			
			while (finished == false){
				
				if (foundCorner == false){
					
					foundCorner = getRobotToButtomLeftCorner();
				
				} else {
					if (wallNumber == 1){
						
						//Go left until you hit a wall or window.
						//At the same time searching the buttom wall(1) for windows.
						
						dir = down;
						if (printAnimation){
							printRoom();
							System.out.println("\n\n Windows: " + numberWindows + " \n");
							Thread.sleep(animationspeed);
						}
						
						//When you hit a window or wall stop searching and start searching the left wall (2).
						if ( isTileWindow(robotY, robotX-1) || isTileWall(robotY, robotX-1)) {
							wallNumber = 2;
						}
						
						//If the tile on the buttom wall is a window add it to the counter.
						if (isTileWindow(robotY+1, robotX) && (wallNumber == 1)) {
							
							if (sameWindow == false) {
								numberWindows++;
							}
							
							dir = left;
							matrix[robotY][robotX] = floor;
							robotX--;
							sameWindow = true;
						
						} else if (wallNumber == 1) {
							
							dir = left;
							matrix[robotY][robotX] = floor;
							robotX--;
							sameWindow = false;
							
						}
						
					}
					else if (wallNumber == 2){
						
						//Go up until you hit a wall or window.
						//At the same time searching the left wall(2) for windows.
						
						dir = left;
						if (printAnimation) {
							printRoom();
							System.out.println("\n\n Windows: " + numberWindows + " \n");
							Thread.sleep(animationspeed);
						}
						
						//When you hit a window or wall stop searching and start searching the upper wall (3).
						if (isTileWindow(robotY-1, robotX) || isTileWall(robotY-1, robotX)) {
							wallNumber = 3;
						}
						
						//If the tile on the left wall is a window add it to the counter.
						if (isTileWindow(robotY, robotX-1) && (wallNumber == 2)) {
							
							if (sameWindow == false) {
								numberWindows++;
							}
							
							dir = up;
							matrix[robotY][robotX] = floor;
							robotY--;
							sameWindow = true;
							
						} else if (wallNumber == 2) {
							
							dir = up;
							matrix[robotY][robotX] = floor;
							robotY--;
							sameWindow = false;
							
						}
						
					}
					else if (wallNumber == 3){
						
						//Go right until you hit a wall or window.
						//At the same time searching the upper wall(3) for windows.
						
						dir = up;
						if (printAnimation) {
							printRoom();
							System.out.println("\n\n Windows: " + numberWindows + " \n");
							Thread.sleep(animationspeed);
						}
						
						//When you hit a window or wall stop searching and start searching the right wall (4).
						if (isTileWindow(robotY, robotX+1) || isTileWall(robotY, robotX+1)) {
							wallNumber = 4;
						}
						
						//If the tile on the upper wall is a window add it to the counter.
						if (isTileWindow(robotY-1, robotX) && (wallNumber == 3)) {
							
							if (sameWindow == false) {
								numberWindows++;
							}
							
							dir = right;
							matrix[robotY][robotX] = floor;
							robotX++;
							sameWindow = true;
							
						} else if (wallNumber == 3) {
							
							dir = right;
							matrix[robotY][robotX] = floor;
							robotX++;
							sameWindow = false;
							
						}
						
					}
					else if (wallNumber == 4){
						
						//Go down until you hit a wall or window.
						//At the same time searching the right wall(4) for windows.
						
						dir = right;
						if (printAnimation) {
							printRoom();
							System.out.println("\n\n Windows: " + numberWindows + " \n");
							Thread.sleep(animationspeed);
						}
						
						//When you hit a window or wall stop searching. You have search every wall!
						
						if (isTileWindow(robotY+1, robotX) || isTileWall(robotY+1, robotX)) {
							
							//If the tile on the left wall is a window add it to the counter.
							
							if (isTileWindow(robotY, robotX+1)) {
								
								if (sameWindow == false) {
									numberWindows++;
								}
								
								dir = down;
								sameWindow = true;
								
							} else {
								
								dir = down;
								sameWindow = false;
								
							}
							
							finished = true;
							
						}
						
						if (finished == false){
							
							if (matrix[robotY][robotX+1] == window) {
							
								if (sameWindow == false) {
									numberWindows++;
								}
							
								dir = down;
								matrix[robotY][robotX] = floor;
								robotY++;
								sameWindow = true;
								
							} else {
								
								dir = down;
								matrix[robotY][robotX] = floor;
								robotY++;
								sameWindow = false;
								
							}
						
						}
					}
				}
			
				if (printAnimation){
					printRoom();
					System.out.println("\n\n Windows: " + numberWindows + " \n");
					Thread.sleep(animationspeed);
				}
			
			}
			
		} else {
			
			numberWindows = 0;
			System.out.print("Error: At least 2 Columns and 1 Row needed!");
		
		}
		
		return  numberWindows;
		
	}
	
	/**
	 This method prints the contents of the room based on the int value that is inside each cell.
	 */
	private void printRoom(){
		
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
				
				} else if (isTileWindow(row, column)) {
				
					System.out.print(" + |");
				
				} else if (isTileFloor(row, column)) {
				
					System.out.print("   |");
				
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
	 This method moves the robot to the right until it finds a wall, then it moves down until if finds the lower left corner.
	 @return true if it has found the lower left corner of the room.
	 */
	private boolean getRobotToButtomLeftCorner() {
		
		boolean foundCorner = false, firstTurn = false;
		
		if (foundCorner == false){
			
			//Get to the left wall and turn down.
			if (firstTurn == false){
				
				if (isTileFloor(robotY,robotX+1)){
				
					matrix[robotY][robotX] = floor;
					robotX++;
					putRobotInTile(robotY, robotX);
				
				} else if (isTileWall(robotY, robotX+1)||isTileWindow(robotY, robotX+1)){
					
					firstTurn = true;
					dir = down;
				
				}
				
			}
			
			//Once on the left wall and turning down go down until you find the left buttom corner.
			if ((dir == down) && (foundCorner == false)) {
				
				if (isTileFloor(robotY+1, robotX)){
				
					matrix[robotY][robotX] = floor;
					robotY++;
					putRobotInTile(robotY, robotX);
				
				} else if (isTileWall(robotY+1, robotX)||isTileWindow(robotY, robotX+1)) {
				
					dir = left;
					foundCorner = true;
				
				}
			}
		}
		
		return foundCorner;
		
	}
	
	/**
	 This method fills the Room matrix with the value assigned to the floor.
	 @return New room matrix filled with floor on every coordinate.
	 */
	private int[][] fillRoomWithFloor(int[][] oldRoom) {
		
		int[][] newRoom = oldRoom;
		int lastRow = newRoom.length;
		int lastColumnInThisRow;
		
		for ( int row=0; row < lastRow; row++){
			
			lastColumnInThisRow = newRoom[row].length;
			
			for ( int column=0; column < lastColumnInThisRow; column++) {
				
				newRoom[row][column] = this.floor;
				
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
	 This method places the Windows of the room in the given coordinates.
	 Note: This method needs explicitly stated values for the coordinates of the windows.
	 @return New room matrix with the windows placed on the given coordinates.
	 */
	private int[][] placeRoomWindows(int[][] oldRoom){
		
		int[][] newRoom = oldRoom;
		int lastRow = newRoom.length;
		int lastColumnInThisRow;
		
		for ( int row=0; row < lastRow; row++){
			
			lastColumnInThisRow = newRoom[row].length;
			
			for ( int column=0; column < lastColumnInThisRow; column++) {
				
				if 		(
								(row==0&&column==3)||
								(row==0&&column==4)||
								(row==6&&column==11)||
								(row==7&&column==11)
						)
				{
					placeWindows = true;
				}
				
				if (placeWindows){
					newRoom[row][column] = this.window;
					placeWindows = false;
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
	 This method checks if there is a window on the current tile with the coordinates given.
	 @param r Value for the row of the current tile.
	 @param c Value for the column of the current tile.
	 @return true if there is a window on the coordinates (row, column).
	 */
	private boolean isTileWindow(int r, int c){
		if (matrix[r][c] == this.window) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 This method checks if there is a Floor on the current tile with the coordinates given.
	 @param r Value for the row of the current tile.
	 @param c Value for the column of the current tile.
	 @return true if there is a Floor on the coordinates (row, column).
	 */
	private boolean isTileFloor(int r, int c){
		if (matrix[r][c] == this.floor) {
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
	public int getAnimationspeed() {
		return animationspeed;
	}
	public void setAnimationspeed(int animationspeed) {
		this.animationspeed = animationspeed;
	}
	
}
