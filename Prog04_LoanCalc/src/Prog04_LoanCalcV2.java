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
public class Prog04_LoanCalcV2 {

	private static Scanner in = new Scanner(System.in); //a 'class declaration of the Scanner 'in' to prevent retyping it
	public static void main(String[] args) 
	{
		boolean inputProof = false;
		double loanAmt = 0.0;
		int years = 0;
		double annualRate = 0.0;
		String loanPrompt = "Please enter your loan amount: ";
		String loanError = "a NUMBER greater than 0.00";
		loanAmt = inputDValidation(loanPrompt, loanError);
		
		System.out.println("Enter loan duration in years (whole number greater than 0)");
		inputProof = false;
		while(!inputProof)
		{
			while(!in.hasNextInt())
			{
				String wrong = in.next();
				System.out.println("incorrect input");
				System.out.println("Enter a whole number greater than 0: ");
			}
			int place = in.nextInt();
			if(place > 0)
			{
				years = place;
				inputProof = true;
		
			} else
			{
				int tooLow = place;
				System.out.println("incorrect input");
				System.out.println("Enter a whole number greater than 0:  ");
			}
		}
		inputProof = false;
		System.out.println("Enter annual rate (value between 0.0 and 100.0)");
		while(!inputProof)
		{
			while(!in.hasNextDouble())
			{
				String wrong = in.next();
				System.out.println("incorrect input");
				System.out.println("Enter a value between 0.0 and 100.0: ");
			}
			double place = in.nextDouble();
			if(place > 0 && place < 100)
			{
				annualRate = place;
				inputProof = true;
		
			} else
			{
				double tooLow = place;
				System.out.println("incorrect input");
				System.out.println("Enter a value between 0.0 and 100.0:  ");
			}
		}
		
		System.out.println("Loan Amount: \t\t$" + loanAmt);
		System.out.println("Number of Years: \t" + years);
		System.out.printf("Annual Interest Rate: \t$%.2f%%\n", annualRate);
		
		double monthlyRate = (((loanAmt / years)*(1+(annualRate/100)))/12);
		System.out.printf("Monthly Payment: \t$%.2f \n\n",monthlyRate);
		
		System.out.println("Payment# \t Interest \t Principal \t Balance");
	    double trueRate = annualRate * 0.01;
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
			System.out.printf("%d \t $%8.2f \t $%8.2f \t $%8.2f \n", counter, interest, principal, loanAmt);
			counter++;
		}
		
	}
	
	public static void paymentFinder()
	{
		
	}
	
	/*
	 * InputDValidation stands for input double validation. This works only to validate double values. 
	 */
	public static double inputDValidation(String prompt, String errorStatement)
	{
		double rHolder = 0.0;			//result Holder just holds the result that meets the conditions
		boolean inputProof = false;
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
	
	/*
	 * InputDValidation stands for input integer validation. This works only to validate integer values. 
	 */
	public static int inputIValidation()
	{
		int pHolder = 0;
		return pHolder;
	}
	
}
