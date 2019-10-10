/*
 * 
 * CSC 1350 Programming project No. 4
 * Section 2
 * 
 *  @author Martin Dampier
 *  @since 10/7/19 
 * 
 * This program utilizes the algorithm detailed in the class hand-out, which is a simplified version of a much larger algorithm. This algorithm is designed to output the principal amount and the 
 * interest amount. It also prints out a remaining balance owed. It has a known error that sometimes results in an extra month being needed to complete the payment. 
 * 
 */
import java.util.Scanner;
public class Prog04_LoanCalc {

	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		double loanAmt;
		int years;
		double annualRate;
		String loanPrompt = "Please enter your loan amount: ";
		String loanError = "a NUMBER greater than 0.00";
		String yearsPrompt = "Enter loan duration in years (whole number greater than 0)";
		String yearsError = "whole number greater than 0";
		String annualRatePrompt = "Enter a number between 0.0 and 100.0";
		String annualRateError = "number BETWEEN 0.0 and 100.0";
		loanAmt = inputDValidation(loanPrompt, loanError);
		years = inputIValidation(yearsPrompt, yearsError);
		annualRate = inputUniqueValidation(annualRatePrompt, annualRateError);
		paymentFinder(loanAmt, years, annualRate);
	}
	
	public static void paymentFinder(double loanAmt, int years, double annualRate)
	{
		double monthlyRate = (((loanAmt / years)*(1+(annualRate/100)))/12);
		double trueRate = annualRate * 0.01;
		System.out.println("Loan Amount: \t\t$" + loanAmt);
		System.out.println("Number of Years: \t" + years);
		System.out.printf("Annual Interest Rate: \t$%.2f%%\n", annualRate);
		System.out.printf("Monthly Payment: \t$%.2f \n\n",monthlyRate);
		System.out.println("Payment# \t Interest \t Principal \t Balance");
		while(loanAmt > 0)
		{
			int counter = 1;
			double interest = (trueRate * loanAmt)/12;
			double principal = monthlyRate - interest;
			if(loanAmt < principal)
			{
				interest = (trueRate * loanAmt)/12;
				principal = loanAmt;
				loanAmt = loanAmt - loanAmt;
			}else 
			{
				loanAmt = loanAmt - principal;
				
			}
			System.out.printf("%d \t\t $%8.2f \t $%8.2f \t $%8.2f \n", counter, interest, principal, loanAmt);
			counter++;
		}
	}
	
	public static double inputUniqueValidation(String prompt, String errorStatement)
	{
		double rHolder = 0.0;			//result Holder just holds the result that meets the conditions
		boolean inputProof = false;
		
		System.out.println(prompt);
		while(!inputProof)
		{
			while(!in.hasNextDouble())
			{
				String wrong = in.next();								//this variable is used ONLY to store the incorrect variable and has no usage.
				System.out.println("incorrect input");
				System.out.println("Please enter " + errorStatement);
			}
			double place = in.nextDouble();
			if(place > 0 && place < 100)
			{
				rHolder = place;
				inputProof = true;
		
			} else
			{
				double tooLow = place;
				System.out.println("incorrect input");
				System.out.println("Please enter " + errorStatement);
			}
		}
		
		return rHolder;
	}
	
	public static double inputDValidation(String prompt, String errorStatement)
	{
		double rHolder = 0.0;			//result Holder just holds the result that meets the conditions
		boolean inputProof = false;
		
		System.out.println(prompt);
		while(!inputProof)
		{
			while(!in.hasNextDouble())
			{
				String wrong = in.next();
				System.out.println("incorrect input");
				System.out.println("Please enter " + errorStatement);
			}
			double place = in.nextDouble();
			if(place > 0)
			{
				rHolder = place;
				inputProof = true;
		
			} else
			{
				double tooLow = place;
				System.out.println("incorrect input");
				System.out.println("Please enter " + errorStatement);
			}
		}
		
		return rHolder;
	}
	
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
