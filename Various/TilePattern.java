package various_programs;

/**
 Black and white tile pattern creator.
 <p>Creates a matrix with a black and white square tile pattern.
 <p>There is a black frame all arround and two or three centered black tiles.
 
 @author Dario Arzaba
 @version 1.0
 */

public class TilePattern {
	
	int rows, columns, middleRow, middleColumn;
	boolean[][] matrix;
	boolean columnsEven;
	
	/**
	 This constructor creates a pattern with 7 rows and 9 columns as its default.
	 Note: Rows should always be an odd number.
	 */
	public TilePattern(){
		this.rows = 7;
		this.columns = 9;
		middleRow = rows/2;
		middleColumn = columns/2;
		matrix = new boolean[rows][columns];
	}
	
	/**
	 This constructor creates a pattern with a specified number of rows and columns.
	 Note: Rows should always be an odd number.
	 
	 @param	rowsInput number of rows in the matrix.
	 @param columnsInput number of columns in the matrix.
	 */
	public TilePattern(int rowsInput, int columnsInput){
		if (rowsInput % 2 == 0){
			rowsInput += 1;
		}
		this.rows = rowsInput;
		this.columns = columnsInput;
		middleRow = rows/2;
		middleColumn = columns/2;
		matrix = new boolean[rows][columns];
	}
	
	/**
	 Creates the boolean matrix with the black and white pattern.
	 @return A matrix with a black (false) and white (true) pattern.
	 */
	public boolean[][] createMatrix(){

		columnsEven = areColumnsEven();
		matrix = fillMatrixWithWhite(rows, columns);
		
		int lastRow = matrix.length;
		int lastColumnInThisRow;
		boolean blackTile = false;
		
		for ( int row=0; row < lastRow; row++){
		
			lastColumnInThisRow = matrix[row].length;
			for ( int column=0; column < lastColumnInThisRow; column++){
		
				if ( isCurrentTileBorder(row , column) ){
		
					matrix[row][column] = blackTile;
		
				} else if ((columnsEven==true) && (isCurrentTileCenter(row, column))) {
					
					matrix[row][column] = blackTile;
					matrix[row][column-1] = blackTile;
				
				} else if ((columnsEven==false) && (isCurrentTileCenter(row, column))) {
				
					matrix[row][column] = false;
					matrix[row][column-1] = blackTile;
					matrix[row][column+1] = blackTile;
				
				}
			
			}
		
		}
		
		return matrix;
		
	}
	
	/**
	 This method prints a boolean matrix to the Console.
	 @param boolean[][] The matrix that is going to be printed.
	 */
	public void printMatrix(boolean[][] matrix){
		
		System.out.print("\n\n");
		
		for (int column = 0; column < this.columns; column++){
			System.out.print("----");
		}
		
		System.out.print("\n");
		int lastRow = matrix.length;
		int lastColumnInThisRow;
		
		for (int row = 0; row < lastRow; row++){
		
			System.out.print("|");
			lastColumnInThisRow = matrix[row].length;
			
			for (int column = 0; column < lastColumnInThisRow; column++){
				
				if (matrix[row][column] == false){
					System.out.print(" @ |");
				} else {
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
	 This method checks if the number of columns in the pattern is an even number.
	 @return true If the number of columns inputed is even.
	 @return false If the number of columns inputed is odd.
	 */
	private boolean areColumnsEven(){
		if (columns % 2 == 0){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 This method checks if the current tile is part of the border of the matrix.
	 @param rows Number of rows in the matrix.
	 @param columns Number of columns in the matrix.
	 @return true If the tile is part of the border..
	 @return false If the tile isn't part of the border.
	 */
	private boolean isCurrentTileBorder(int row, int column){
		boolean isCurrentTileUpBorder = (row == 0);
		boolean isCurrentTileDownBorder = (row == (matrix.length-1));
		boolean isCurrentTileLeftBorder = (column == 0);
		boolean isCurrentTileRightBorder = (column == (matrix[row].length-1));
		if (isCurrentTileLeftBorder||isCurrentTileRightBorder||isCurrentTileUpBorder || isCurrentTileDownBorder) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 This method checks if the current tile is at the very center of the matrix
	 @param rows Number of rows in the matrix.
	 @param columns Number of columns in the matrix.
	 @return true If the tile is in the center.
	 @return false If the tile isn't in the center.
	 */
	private boolean isCurrentTileCenter(int row, int column){
		boolean isCurrentTileMiddleRow = (row == middleRow);
		boolean isCurrentTileMiddleColumn = (column == middleColumn);
		if (isCurrentTileMiddleRow && isCurrentTileMiddleColumn) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 This method fills a boolean matrix with true values.
	 @param rows Number of rows in the matrix.
	 @param columns Number of columns in the matrix.
	 */
	private boolean[][] fillMatrixWithWhite(int rows, int columns){
		boolean[][] whiteMatrix = new boolean[rows][columns];
		int lastRow = whiteMatrix.length;
		int lastColumnInThisRow;
		boolean whiteTile = true;
		for ( int row=0; row < lastRow; row++){
			lastColumnInThisRow = whiteMatrix[row].length;
			for ( int column=0; column < lastColumnInThisRow; column++){
				whiteMatrix[row][column] = whiteTile;
			}
		}
		return whiteMatrix;
	}
	
}
