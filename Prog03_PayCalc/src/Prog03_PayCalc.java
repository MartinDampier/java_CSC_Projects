/*
 * 
 * In this project, I will take three inputs from the user and calculate the wages they made. The inputs given to me will be the employee's number, hours worked, and 
 * hourly rate. I will then use all three variables to determine what calculation is required and then perform the calculation. Finally, the program will then notify the user how much 
 * they made in wages. 
 * 
 * CSC 1350 Programming Project No 3
 * Section 2
 * 
 * @author Martin Dampier
 * 
 * @since 9/30/2019
 * 
 */
import java.util.Scanner;
public class Prog03_PayCalc {

	public static void main(String[] args) 
	{
		int idNumber; 		// the employees ID #
		int hoursWorked;	//the hours worked by the employee
		double rate;		//hourly rate of the employee
		double annualRate;	//annual Salary of the employee
		double pay;			//a variable to store the wage that will be displayed to the user.
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Employee ID: ");
	    idNumber = in.nextInt();
	    
	    if(idNumber >= 1000) // checks to see if the employee receives an annual salary instead of hourly pay
	    {
	    	System.out.println("Enter Annual Salary: ");
	    	annualRate = in.nextDouble();
	    	pay = calcSal(idNumber,annualRate);
	    	System.out.printf("Your weekly pay is: %.2f \n", pay);
	    	if(idNumber > 2000) //checks to see if a bonus needs to be stated in the Salary Calculation
	    	{
	    		System.out.printf("Salary Calculation: %.2f annual salary with a 10 percent bonus / 52 = %.2f", annualRate, pay);
	    	} else
	    	{
	    		System.out.printf("Salary Calculation: %.2f annual salary / 52 = %.2f", annualRate, pay);
	    	}
	    	
	    } else 
	    {
	    	double overtime;
	    	double overtimePay;
	    	System.out.println("Enter the number of hours worked during the week: ");
	    	hoursWorked = in.nextInt();
	    	overtime = hoursWorked - 40;
	    	System.out.println("Enter the hourly rate: ");
	    	rate = in.nextDouble();
	    	overtimePay = rate * 1.5;
	    	pay = calcWage(idNumber, hoursWorked, rate); 
	    	System.out.printf("Your weekly pay is: %.2f %n", pay);
	    	if (overtime > 0) //checks to see if overtime needs to be included in the Salary Calculation output
	    	{
	    		System.out.printf("Salary Calculation: %d hours worked x $%.2f hourly rate %n \t\t +%.2f hours worked x $%.2f hourly rate = %.2f", hoursWorked, rate, overtime, overtimePay, pay);
	    	} else 
	    	{
	    		System.out.printf("Salary Calculation: %d hours worked x $%.2f hourly rate = %.2f", hoursWorked, rate, pay);
	    	}
		    
	    }
	    
	}
	
	
	/*
	 * This method will take in three variables and run them through a series of if/else statements and calculations to determine the wage of the user.
	 * The algorithm used was defined by the payroll department and I will add no alterations to the algorithm given. 
	 */
	public static double calcWage(int id, int hours, double ratePay)
	{
		double wage = 0.0;
		int overtime = 0;
		double overtimePay = 0.0;
		
		if (hours > 40)
		{
			overtime = hours - 40;
			overtimePay = (overtime * (ratePay * 1.5));
		}
		
		wage = ((hours - overtime)* ratePay) + overtimePay;
		return wage;
	}
	
	/*
	 * This method calculates the weekly salary of an employee who is designated to have annual salary instead of hourly pay. It also adds a 10% bonus to everyone with higher than 
	 * $75,000 in salary for the year. 
	 */
	public static double calcSal(int id, double salary)
	{
		double weeklySal;
		double annualSalary = salary; 
		
		if(id > 2000)
		{
			weeklySal = (annualSalary * 1.1) / 52;
		} else
		{
			weeklySal = annualSalary / 52;
		}
		return weeklySal;
	}
}
