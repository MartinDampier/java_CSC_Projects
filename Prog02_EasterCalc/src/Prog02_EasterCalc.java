/**
 * This program is designed to calculate the date of Easter sing the algorithm developed by Gauss
 * It will do so by asking the user what year it is and then it will use that information to determine the month and day of easter.
 * 
 * CSC 1350 Programming Project 02
 * Section 2
 * 
 * @author mdampi1
 * @since 9/16/19
 *
 */

import java.util.Scanner;

public class Prog02_EasterCalc 
{
	
    public static int yearGiven; // this will be a global variable used to hold and pass the year given by the user
     
    
  
	public static void main(String[] args) 
	{
	 prompt();
     System.out.println(yearGiven);
     int date[] = easterDate(yearGiven); // this array is being passed another array which contains the month and date
     System.out.println("In " + yearGiven + ", Easter falls on " + date[0] + "/" + date[1]);
	}
	
	/*
	 * This method will prompt the user and collect the data given by the user for the year.
	 * It will do this by using the scanner object in and putting the variable given into *yearGiver*
	 */
	public static void prompt()
	{
		Scanner in = new Scanner(System.in); //this is a declaration of a scanner object to be used in this program
		System.out.println("When is Easter, you ask?");
		System.out.print("Enter the year of your choosing: ");
		yearGiven = in.nextInt();
	}
	
	/*
	 * This method will take the global variable yearGiven and perform the algortithm to find the date of easter as developed by Carl Fredrick Gauss
	 * It will return the month and date to be store in a variable within the main method. An array will be used to store the 2 variables as they are
	 * passed back to the main method.
	 */
	public static int[] easterDate(int yearToProcess)
	{		
		int[] pair = new int[2];
		int a = yearToProcess / 100;					//dividing the yearToProcess by 100 to get the quotient a
		int b = yearToProcess % 100; 					//dividing the yearToProcess by 100 to get the remainder b
		int c = a / 4;									//dividing a by 4 to get the quotient c
		int f = a % 4;									//dividing a by 4 to get the remainder f	
		int g = ((8 * a) + 13) / 25;					//dividing 8 * a + 13 by 25 to get the quotient g
		int h = yearToProcess % 19;						//dividing the yearToProcess by 19 to get the remainder h
		int i = b / 4;									//dividing b by 4 to get the quotient i
		int j = b % 4;									//dividing b by 4 to get the remainder j
		int k = (19 * h + a - c - g + 15) % 30;			//dividing 19 * h + a - c - g + 15 by 30 to get the remainder k
		int l = (h + 11 * k) / 319;						//dividing h + 11 * k by 319 to get the quotient l
		int n = (2 * f + 2 * i - j - k + l + 32) % 7;	//dividing 2 * f + 2 * i - j - k + l + 32 by 7  to get the remainder n
		int m = (k - l + n + 90) / 25;					//dividing k - l + n + 90 by 25 to get the quotient m
		int d = (k - l + n + m + 19) % 32;				//dividing k - l + n + m + 19 by 32 to get the remainder d
		pair[0] = m;									
		pair[1] = d;									
		return pair;									//returning the array pair with m and d stored inside it
	}

}
