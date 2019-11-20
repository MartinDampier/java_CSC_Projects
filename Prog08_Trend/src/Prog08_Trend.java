/*
 * This program will help users see how their stock investments have been trending over time.
 * The user will enter daily closing stock values over a specified interval of time. Then 
 * the program will calculate the average closing value and then print each day's DISTANCE 
 * from the average value.
 * 
 * 
 * @author Martin S. Dampier
 * @since 11/11/19
 */
import java.util.Scanner;
public class Prog08_Trend {
	private static Scanner cin = new Scanner(System.in);
	/*
	 * This method checks to see if the variable given by the user is a double value. If it is not a double variable it will reprompt the user.
	 * @author Martin Dampier
	 * @since 10/28/19 
	 */
	public static double validateDouble()
	{
		double rHolder = 0;			//result Holder just holds the result that meets the conditions
		boolean inputProof = false;
		
		while(!inputProof)
		{
			while(!cin.hasNextDouble())
			{
				String wrong = cin.next();
				System.out.println("incorrect input");
				System.out.println("Please enter a double number");
			}
			rHolder = cin.nextDouble();
			inputProof = true;
		}
		
		return rHolder;
	}
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
	/*
	 * This method prompts the user to input each stock value per day and stores the inputs into an array.
	 * @input stock values
	 * @output array containing inputs
	 * @author Martin Dampier
	 * @since 11/11/19
	 */
	public static double[] openingPrompt(int days)
	{
		double[] closingValues = new double[days];
		for(int i = 0; i < closingValues.length; i++)
		{
			System.out.println("Enter closing value for day " + (i+1));
			closingValues[i] = validateDouble();
		}
		return closingValues;
	}
	/*
	 * This method takes an array and calculates the average of all of the numbers stored within the array. 
	 * @param stock values
	 * @output average of all values stored in array given
	 * @author Martin Dampier
	 * @since 11/11/19
	 */
	public static double averageOfArray(double[] values)
	{
		double sum = 0;
		for(int i = 0; i < values.length; i++)
		{
			sum += values[i];
		}
		return (sum / values.length); 
	}
	/*
	 * This method prints out the values stored in the array in order to visually display the difference between the average and the value. 
	 * It also formats the closing average value. 
	 * @param double array, average of array
	 * @author Martin Dampier
	 * @since 11/11/19
	 */
	public static void compareTrend(double[] values, double average)
	{
		int day = 0;
		double trend = 0.0;
		System.out.println("Day\tClosingValue\tTrend");
		for(int i = 0; i < values.length; i++)
		{
			day = 1+i;
			trend = values[i] - average;
			System.out.printf("%d\t%5.2f\t\t%5.2f \n", day, values[i], trend);
		}
		System.out.printf("Average Daily Closing Value: %6.2f", average);
	}
	public static void main(String[] args) 
	{
		System.out.println("How many days would you like to trend?");
		int days = validateInt();
		double[] closingValues = openingPrompt(days);
		double average = averageOfArray(closingValues);
		compareTrend(closingValues, average);
	}

}
