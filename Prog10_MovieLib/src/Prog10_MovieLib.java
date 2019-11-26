import java.util.Scanner;

/**
 * This program prompts the user for a number of movies and then ask the user to identify each movie in their personal library. It then
 * sorts the movies into alphabetical order and will provide the user with the place in the organized list that their desired movie is. 
 * 
 * CSC 1350 Programming project No 10
 * Section 2 
 * 
 * @author Martin Dampier
 * @since 11/25/2019
 */
public class Prog10_MovieLib {
	private static Scanner cin = new Scanner(System.in);
	private static String[] movieLibrary; 	//This is an array which will contain all of the movie names. It is filled later in the program.
	private static int numOfMovies = 0;		//This variable contains the number of movies that is in the movieLibrary array.
	/**
	 * Developed: 10/28/19
	 * Modified: 11/25/19 Incorporates a global variable to compare the integer given to. It is also edited to be able to input the numOfMovies.
	 * This method checks to see if the variable given by the user is a integer value. If it is not an integer variable it will reprompt the user.
	 * @author Martin Dampier
	 * 
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
			if(!(numOfMovies == 0))
			{
				if((rHolder < numOfMovies) && (rHolder >= 0))
				{
					inputProof = true;
				} else
				{
					System.out.println("Please input a number between 0 and " + numOfMovies);
				}
			} else
			{
				if((rHolder > 0))
				{
					inputProof = true;
				} else
				{
					System.out.println("Please input a number above 0");
				}
			}
			
		}
		return rHolder;
	}
	/**
	 * Acts as the intial prompt to store the number of movies that will be stored in the array that is made later on.
	 * Developed: 11/25/2019 
	 * @author Martin Dampier
	 */
	public static void createLibrary() 
	{
		System.out.println("How many movies are in your personal library?");
		numOfMovies = validateInt();
		
	}
	/** This method prompts the user to input a movie title in order to fill the movie library array.
	 * 	Developed: 11/26/2019
	 * 
	 */
	public static void inputMovies()
	{
		int c = 0;
		cin.nextLine();
		do
		{
			System.out.println("Enter Movie Title (" + (c+1) +" out of "+ numOfMovies+")"); 
			movieLibrary[c] = cin.nextLine();
			c++;
		} while(c < numOfMovies);
	}
	/** This method takes an array and swaps the first given element with the second. 
	 * 	Developed: 11/26/2019
	 * 	@param list		An array of type String that the swapping will take place in.
	 * 	@param first	The index of the first value that is to be swapped
	 * 	@param second	The index of the second value that is to be swapped
	 */
	public static void swap(String[] list,int first, int second)
	{
		String hold = list[second];
		list[second] = list[first];
		list[first] = hold;
	}
	/** This method takes the movie library array and sorts it in alphabetical order.
	 * 	Developed: 11/26/2019
	 * 
	 */
	public static void organizeMovies()
	{
		boolean sorted = false;
		int i = 1;
		while (!sorted) {
			if (i == movieLibrary.length)
			{
				sorted = true;
			}
			else 
			{
				sorted = true;
				for(int j = 0; j < movieLibrary.length-i; j++)
				{
					if(1 < ((movieLibrary[j].toLowerCase()).compareTo((movieLibrary[j+1]).toLowerCase())))
					{
						swap(movieLibrary, j, j+1);
						sorted = false;
					}
				}
			}
		i++;
		}
	}
	/** A method that prompts the user for what they want to find and the method checks to see if the name is in the library.
	 * 	Developed: 11/26/2019
	 * 
	 */
	public static void findMovie()
	{
		boolean done = false;
		int c = 0;
		while(!done)
		{
			System.out.println("Enter a movie title to search or Q to stop: ");
			String input = cin.nextLine();
			if(!(input.contentEquals("Q"))) //Q is acting as the sentinel value.
			{
				for(int i = 0; i < numOfMovies; i++)
				{
					if((movieLibrary[i].toLowerCase()).equals(input)) //.toLowerCase() is used to give the user some small range of error when inputting movie titles.
					{
						System.out.printf("The %s movie is in the library at position %d", movieLibrary[i],i);
						System.out.println();
						c++;
					} 
				}
				if(c == 0)
				{
					System.out.printf("The %s movie is not in the library", input);
					System.out.println();
				}
			} else
			{
				done = true;
			}
		}
	}
	public static void main(String[] args) 
	{
		createLibrary();							//Prompts the user to get the number of movies that will be in the movie library array.
		movieLibrary = new String[numOfMovies];		//Creates a new array in the heap and then assigns movie library to the address
		inputMovies();								//Prompts the user to input a movie for each index of the array
		organizeMovies();							//Once the user fills the array, this method sorts the array for ease of searching
		findMovie();								//Asks the user for what they would like to find and then searches the array
		System.out.println("Movie Library");		//Final print of the movies inside of the movie library
		for(int i = 0; i < numOfMovies; i++) 
		{
			System.out.println(movieLibrary[i]);
		}
	}
		

}
