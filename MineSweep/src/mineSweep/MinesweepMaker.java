/**
 * This project was to create a minesweeper grid. It has to be randomly generated and at least a 5x5 grid. It also
 * required user input and to be displayed to the user in a text format.
 * 
 * @author Martin Dampier
 * @since 11/18/2019
 * 
 */
package mineSweep;
import java.util.Scanner;

public class MinesweepMaker {

	private static Scanner cin = new Scanner(System.in);
	/**
	 * This method checks to see if the variable given by the user is a integer value. If it is not an integer variable it will reprompt the user.
	 * 
	 * @author Martin Dampier
	 * @since 10/28/2019
	 */
	public static int validateInt()
	{
		int rHolder = 0;			//result Holder just holds the result that meets the conditions
		boolean inputProof = false;
		while(!inputProof)
		{
			while(!cin.hasNextInt())
			{
				String wrong = cin.next();
				System.out.println("incorrect input");
				System.out.println("Please enter a whole number");
			}
			rHolder = cin.nextInt();
			if(rHolder > 4)		//Because the minimal input must be greater than 4 and an integer. > 4 was added to the method.
			{
				inputProof = true;
			} else
			{
				System.out.println("Please input a number above 4");
			}
		}
		return rHolder;
	}
	/**
	 * This method takes in 3 inputs and uses them to randomly generate where each "bomb" will be placed within the matrix.
	 * @param field 		= A matrix that the method will place "bombs" in.
	 * @param rows			= The user defined # of rows
	 * @param columns		= The user defined # of columns
	 * @since 11/20/2019
	 * Was changed to internally calculate what 10 percent of the matrix is.
	 */
	public static void fieldFiller(int[][] field, int rows, int columns)
	{
		boolean done = false;
		int count = 0;
		int numOfBombs = (rows * columns)/10; //This is 10 percent of the matrix and will be used as a guide to the number of bombs needed.
		while(!done)
		{
			int ranRow = (int)(Math.random() * (rows) + 1);			//Creates an integer that exists in the range of [1,rows] 
			int ranColumn = (int)(Math.random() * (columns) + 1);	//Creates an integer that exists in the range of [1, columns]
			//Note: both random values have to be subtracted by one to ensure ti stays within the range of the matrix.
			if(!(field[ranRow-1][ranColumn-1] == -1))
			{
				field[ranRow-1][ranColumn-1] = -1;
				count++;
			} 
			if (count == numOfBombs)
			{
				done = true;
			}
		}

	}
	/**
	 * This method looks at the matrix and will label a blank space in the matrix with the # of "bombs" that surround it.
	 * The method bombFound is used extensively throughout this method so that a space can be properly labelled.
	 * @param field		= The matrix that is being read and labeled
	 * @param rows		= The current row the method is looking at
	 * @param columns	= The current column the method is looking at
	 * @param maxR		= The maximum number that a row can be indexed as
	 * @param maxC		= The maximum number that a column can be indexed as
	 * @since 11/20/2019
	 * Made changes to the structure for ease of reading and to debug.
	 */
	public static void fieldLabeler(int[][] field, int rows, int columns, int maxR, int maxC)
	{
		if ((rows == 0) && (columns == 0))						 // top left corner
		{
			field[rows][columns] = (bombFound(field[rows+1][columns]) 
			+ bombFound(field[rows][columns+1])+ bombFound(field[rows+1][columns+1]));
			
		}else if ((rows == 0) && (columns == maxC)) 			// top right corner
		{
			field[rows][columns] = (bombFound(field[rows][maxC-1]) 
			+ bombFound(field[rows+1][maxC-1]) + bombFound(field[rows+1][maxC]));
		} else if ((rows == maxR && columns == 0)) 				// bottom left corner
		{
			field[rows][columns] = (bombFound(field[maxR-1][columns]) 
			+ bombFound(field[maxR-1][columns+1]) + bombFound(field[maxR][columns+1]));
		}else if ((rows == maxR && columns == maxC)) 			// bottom right corner
		{
			field[rows][columns] = (bombFound(field[maxR-1][maxC]) 
			+ bombFound(field[maxR-1][maxC-1]) + bombFound(field[maxR][maxC-1]));
		} else if(rows == 0) 									// ceiling
		{
			field[rows][columns] = (bombFound(field[rows][columns-1]) 
			+ bombFound(field[rows+1][columns-1])+ bombFound(field[rows+1][columns])
			+ bombFound(field[rows+1][columns+1]) + bombFound(field[rows][columns+1]));
		} else if(rows == maxR) 								// floor
		{
			field[rows][columns] = (bombFound(field[rows][columns-1]) 
			+ bombFound(field[rows-1][columns-1])+ bombFound(field[rows-1][columns])
			+ bombFound(field[rows-1][columns+1]) + bombFound(field[rows][columns+1]));
		} else if(columns == 0) 								// left wall
		{
			field[rows][columns] = (bombFound(field[rows-1][columns]) 
			+ bombFound(field[rows-1][columns+1])+ bombFound(field[rows][columns+1])
			+ bombFound(field[rows+1][columns+1]) + bombFound(field[rows+1][columns]));
		} else if(columns == (maxC)) 							// right wall
		{
			field[rows][columns] = (bombFound(field[rows-1][columns])
			+ bombFound(field[rows-1][columns-1])+ bombFound(field[rows][columns-1])
			+ bombFound(field[rows+1][columns-1]) + bombFound(field[rows+1][columns]));
		} else													//center
		{
			field[rows][columns] = (bombFound(field[rows-1][columns-1]) 
			+ bombFound(field[rows-1][columns])+ bombFound(field[rows-1][columns+1])
			+ bombFound(field[rows][columns-1]) + bombFound(field[rows][columns+1])
			+ bombFound(field[rows+1][columns-1])+ bombFound(field[rows+1][columns])
			+ bombFound(field[rows+1][columns+1]));
		}


	}
	/**
	 * This method checks a given integer and sees if it is -1. -1 is the identifier for a "bomb" within the matrix
	 * @param potentialBomb
	 * @return 1 if there is a "bomb" nearby, 0 if there is no "bomb"
	 */
	public static int bombFound(int potentialBomb)
	{
		int bomb = 0;
		if (potentialBomb == -1)
		{
			bomb = 1;
		}
		return bomb;
	}
	/**
	 * This method takes a matrix and prints it to the user in a boxed design. It also changes all -1's into * to represent a "bomb"
	 * @param field		= The matrix that will be printed
	 * @param rows		= The number of rows the matrix has
	 * @param columns	= The number of columns the matrix has
	 * @since 11/20/2019
	 * I had a logic error in which the printer printed out all of the columns and rows except for the last one. 
	 * Updated verison fixed that bug.
	 */
	public static void  printer(int[][] field, int rows, int columns)
	{
		System.out.print("-");
		for (int i = 0; i <= columns; i++) 
		{
			System.out.print("----");
		}
		System.out.println();
		//print each row
		for (int row = 0; row <= rows; row++ ) 
		{
			System.out.print("|");
			for (int col = 0; col <= columns; col++) 
			{
				if (field[row][col] == -1)
				{
					System.out.printf("%2s |", "*");
				}else
				{
					System.out.printf("%2d |", field[row][col]);
				}
			}
			System.out.println();
			//print row separator
			System.out.print("-");
			for (int i = 0; i <= columns; i++) 
			{
				System.out.print("----");
			}
			System.out.println();
		}



	}
	/**
	 *  Main method. This will act as the backbone of the program and will contain the flow structure of the system. 
	 * 	@since 11/18/2019
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to Minesweeper!");
		System.out.println("Enter the number of rows in the matrix (must be more than 4)");
		int rows = validateInt(); // collects user input for rows
		System.out.println("Enter the number of rows in the matrix (must be more than 4)");
		int columns = validateInt(); //collects user input for columns
		int[][] field = new int[rows][columns]; //creates the matrix that the program will use to create the minesweeper field
		fieldFiller(field, rows, columns); // inputs all of the "bombs"
		rows = rows-1;
		columns = columns-1;
		// iterates through each coordinate in the matrix.
		for (int i = 0; i <= rows; i++)
		{
			for (int j = 0; j <= columns; j++)
			{
				if(!(field[i][j]==-1))
				{
					fieldLabeler(field, i, j, rows, columns); //Labels all empty coordinates with the # of adjacent bombs.
				}
			}
		}
		printer(field, rows, columns); //prints the field.
	}

}
