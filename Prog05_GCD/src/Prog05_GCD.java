/*
 * 
 * This program will take two positive integers given by the user and find the Greatest Common Denominator among them.
 * it will only work with two positive integers and will re-prompt the user if they enter an invalid integer.
 * 
 *  CSC 1350 Programming project No 5
 *  Section 2
 * 
 *  @author Martin Dampier
 *  
 *  @since 10/14/2019
 * 
 * 
 */

import java.util.Scanner;
public class Prog05_GCD {

	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		String prompt1 = "Please enter a positive non-zero integer: ";
		String errorStatement = "a positive non-sero integer: ";
		String prompt2 = "Please enter another positive non-zero integer: ";
		int valueOne = inputIValidation(prompt1, errorStatement);
		int valueTwo = inputIValidation(prompt2, errorStatement);
		System.out.println();
		System.out.println();
		findFactors(valueOne, valueTwo);
	}
	/*
	 * This method performs 3 functions.
	 * 1. It find the GCD of the two given Integers
	 * 2. It prints out the factors of the first integer given
	 * 3. It prints out the factors of the second integer given
	 */
	public static void findFactors(int num1, int num2)
	{
		int gcd = 0;
		int toCompOne = 0;
		int toCompTwo= 0;
		
		for(int i = 1; i <= num1; i++)
		{
			if(num1 % i == 0)
			{
				toCompOne = i;
			}
			
			for(int j = 1; j <= num2; j++)
			{
				if(num2 % j == 0)
				{
					toCompTwo = j;
					if(toCompOne == toCompTwo)
					{
						gcd = toCompTwo;
					}
				}
			}
		}
		System.out.printf("The greatest common divisor of %d and %d is %d \n", num1, num2, gcd);
		System.out.println();
		System.out.println();
		System.out.println("Divisors for " + num1);
		for(int i = 1; i <= num1; i++)
		{
			
			if(num1 % i == 0)
			{
				System.out.println(i);
			}
		}
		System.out.println();
		System.out.println();
		System.out.println("Divisors for " + num2);
		for(int i = 1; i <= num2; i++)
		{
			
			if(num2 % i == 0)
			{
				System.out.println(i);
			}
		}
	}
	/*
	 * This method acts to validate the input of the user and takes a prompt and an error statement to be displayed to the user.
	 */
	public static int inputIValidation(String prompt, String errorStatement)
	{
		int rHolder = 0;			//result Holder just holds the result that meets the conditions
		boolean inputProof = false;
		
		System.out.println(prompt);
		while(!inputProof)
		{
			while(!in.hasNextInt())
			{
				String wrong = in.next();
				System.out.println("incorrect input");
				System.out.println("Please enter " + errorStatement);
			}
			int place = in.nextInt();
			if(place > 0)
			{
				rHolder = place;
				inputProof = true;
		
			} else
			{
				int tooLow = place;
				System.out.println("incorrect input");
				System.out.println("Please enter " + errorStatement);
			}
		}
		
		return rHolder;
	}

}
