import java.util.Scanner;

/**
 * This program prompts the user for a number of movies and then ask the user to identify each movie in their personal library. It then
 * sorts the movies into alphabetical order and will provide the user with the place in the organized list that their desired movie is. 
 * 
 * CSC 1350 Programming project No 11
 * Section 2 
 * 
 * @author Martin Dampier
 * @since 12/2/2019
 */
public class Prog11_MovieLibrary {
	private static Scanner cin = new Scanner(System.in);
	private static int numOfMovies = 0;
	private static Movie[] movieLibrary;
	/*
	 * This method checks to see if the variable given by the user is a integer value. If it is not an integer variable it will reprompt the user.
	 * 
	 * @author Martin Dampier
	 * @since 10/28/19
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
			inputProof = true;
		}
		
		return rHolder;
	}
	/** This method takes a user input and will keep taking user input until the user inputs a valid rating
	 * 
	 * @return returns a validate string 
	 */
	public static String validateRating()
	{
		String rHolder = "";			//result Holder just holds the result that meets the conditions
		boolean inputProof = false;
		cin.nextLine();
		while(!inputProof)
		{
			rHolder = cin.nextLine();
			switch(rHolder)
			{
			case "G" : inputProof = true; break;
			case "PG" : inputProof = true; break;
			case "PG-13" : inputProof = true; break;
			case "R" : inputProof = true; break;
			case "Not Rated" : inputProof = true; break;
			default: 
				System.out.print("Please input a valid rating");
			}
		}
		return rHolder;
	}	
	/** This method creates an array that will hold X amount of movie objects. X is a user defined number.
	 * 
	 */
	public static void createLibrary()
	{
		
		for (int i = 0; i < numOfMovies; i++) {
			movieLibrary[i] = new Movie();
			}

	}
	/** This method prompts the user to enter information for every movie object in the movieLibrary array.
	 * 
	 */
	public static void inputInformation()
	{
		cin.nextLine();
		for(int i = 0; i < numOfMovies; i++)
		{
			System.out.println("Enter a movie title (" + (i+1) + " / " + numOfMovies +"): ");
			movieLibrary[i].setMovieTitle(cin.nextLine());
			System.out.println("Enter the year that the movie was released: ");
			movieLibrary[i].setReleaseYear(validateInt());
			System.out.println("Enter the movie rating (G, PG, PG-13, R, or Not Rated): ");
			movieLibrary[i].setRating(validateRating());
		}
	}
	/** This method swaps two elements in the movieLibrary array. 
	 * 
	 */
	public static void swap(int first, int second)
	{
		Movie hold = movieLibrary[second];
		movieLibrary[second] = movieLibrary[first];
		movieLibrary[first] = hold;
	}
	/** This method organizes all of the elements in the movieLibrary array into alphabetical order.
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
		else {
				for(int j = 0; j < movieLibrary.length-i; j++)
				{
					if(1 < (((movieLibrary[j].getMovieTitle()).toLowerCase()).compareTo(((movieLibrary[j+1].getMovieTitle()).toLowerCase()))))
					{
						System.out.println(movieLibrary[j].getMovieTitle());
						System.out.println(movieLibrary[j+1].getMovieTitle());
						swap( j, j+1);
						sorted = false;
					}
				}
			}
		i++;
		}
	}
	public static void main(String[] args) 
	{
		System.out.println("How many movies are in your library?");
		numOfMovies = validateInt();
		movieLibrary = new Movie[numOfMovies];
		createLibrary();
		inputInformation();
	 	organizeMovies();
		System.out.println("Movie Library");
		for(int i = 0; i < numOfMovies; i++) 
		{
			System.out.print("Movie Title: ");
			System.out.println(movieLibrary[i].getMovieTitle());
			System.out.print("Release Year: ");
			System.out.println(movieLibrary[i].getReleaseYear());
			System.out.print("Rating: ");
			System.out.println(movieLibrary[i].getRating());
			System.out.println();
		}
	}
		

}
