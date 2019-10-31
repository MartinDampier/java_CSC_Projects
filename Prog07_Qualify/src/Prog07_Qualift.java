/*
 * This project is a system that allows the athletic department to input the hours, grades, and previous hours of a student to see if they are still eligible to be student athletes.
 * It utilizes input validation to ensure the user cannot enter values outside of the range prompted. 
 * 
 * CSC 1350 Programming project no 7
 * Section 2
 * 
 * @author Martin Dampier
 * @since 10/28/19
 * 
 */


import java.util.Scanner;
public class Prog07_Qualift {
	private static Scanner cin = new Scanner(System.in);
	
	public static int hours; 		//used to store hours of the student globally
	public static int eligible;		// used to store the state of eligibility of a student to pass the value from the result method back to the main method.
	/*
	 * This method checks to see if the variable given by the user is a integer value. If it is not an integer variable it will reprompt the user.
	 * 
	 * @author Martin Dampier
	 * @since 10/28/19
	 */
	public static int inputIValidation()
	{
		int rHolder = 0;			//result Holder just holds the result that meets the conditions
		boolean inputProof = false;
		
		while(!inputProof)
		{
			while(!cin.hasNextInt())
			{
				String wrong = cin.next();
				System.out.println( wrong + " is an incorrect input");
				System.out.println("Please enter a whole number");
			}
			rHolder = cin.nextInt();
			inputProof = true;
		}
		
		return rHolder;
	}
	/*
	 * This method checks to see if the variable given by the user is a double value. If it is not a double variable it will reprompt the user.
	 * @author Martin Dampier
	 * @since 10/28/19 
	 */
	public static double inputDValidation()
	{
		double rHolder = 0;			//result Holder just holds the result that meets the conditions
		boolean inputProof = false;
		
		while(!inputProof)
		{
			while(!cin.hasNextDouble())
			{
				String wrong = cin.next();
				System.out.println(wrong + "incorrect input");
				System.out.println("Please enter a double number");
			}
			rHolder = cin.nextDouble();
			inputProof = true;
		}
		
		return rHolder;
	}
	/*
	 * This method checks to see if the variable given by the user is a string containing y or n. If it is not a string containing y or n it will reprompt the user.
	 * @author Martin Dampier
	 * @since 10/28/19 
	 */
	public static boolean yesOrNo()
	{
		boolean done = false;
		boolean correctInput = false;
		while(!correctInput)
		{
			String answer = cin.next();
			answer = answer.toLowerCase();
			if(answer.equals("y") || answer.equals("yes"))
			{
				correctInput = true;
			} else if (answer.equals("n") || answer.equals("no"))
			{
				correctInput = true;
				done = true;
			} else
			{
				System.out.println("please input Y/N");
			}
		}
		return done;
	}
	/*
	 * This method prompts the user for their student ID and then returns it to be stored in the main method.
	 * @author Martin Dampier
	 * @since 10/28/19 
	 */	
	public static String studentID()
	{
		System.out.println("Enter student ID: ");
		String studentID = cin.next();
		return studentID;
	}
	/*
	 * This method prompts the user for their class year and will only accept inputs that fall within the bounds prompted.
	 * @author Martin Dampier
	 * @since 10/28/19 
	 */
	public static int collegeLevel()
	{
		boolean sure = false;
		int collegeLevel = 0;
		System.out.println("Enter student class (1 for freshman, 2 for sophomore, 3 for junior)");
		while(!sure)
		{
			collegeLevel = inputIValidation();
			if ((collegeLevel > 0) && (collegeLevel < 4))
			{
				sure = true;
			} else
			{
				System.out.println("please enter a year within the designated bounds");
			}
		}
		return collegeLevel;
	}
	/*
	 * This method is used to collect any and all hours, it takes a prompt to give a unique prompt to the user and checks to make sure the input was not negative 
	 * @author Martin Dampier
	 * @since 10/28/19 
	 */	
	public static int collectHours(String prompt)
	{
		boolean done = false;
		int collectHours = 0;
		System.out.println(prompt);
		while(!done)
		{
			collectHours = inputIValidation();
			if(collectHours >= 0)
			{
				done = true;
			} else
			{
				System.out.println("You cannot have negative hours, please input the correct value");
			}
		}
		return collectHours;
	}
	
	public static double calculateGPA()
	{ 
		boolean done = false;
		double grade = 0.0;
		double GPA = 0.0;
		int classHours = 0;
		double totalHours = 0;
		int sum = 0;
		while(!done) {
			classHours = 0;
			grade = 0;
			System.out.println("Enter hours for class:");
			classHours += inputIValidation();
			hours += classHours;
			totalHours += classHours;
			System.out.println("Input class grade value(4 for A, 3 for B, 2 for C, 1 for D, 0 for F)");
			grade += inputDValidation();
			sum += (grade*classHours);
			System.out.println("Do you have more classes to enter for this Student (Y/N)");
			done = yesOrNo();
		}
		GPA = (sum/totalHours);
		return GPA;
	}
	/*
	 * This method takes all of the collected data and runs it through the requirements that have been outlined. If the information proves to not meet
	 * the requirements it will tell the user they are in-eligible.
	 * 
	 * @author Martin Dampier
	 * @since 10/28/19
	 */
	public static void result(int collegeLevel, String studentID, int cumHours, double GPA)
	{
		boolean passed = false;
		System.out.println("****** Report for student " + studentID + " ******");
		System.out.println("Class: \t\t\t" + collegeLevel);
		System.out.println("Cumulative Hours: \t" + cumHours);
		System.out.printf("Current Year GPA: \t%.2f\n", GPA);
		switch(collegeLevel)
		{
		case 1: {
			if((cumHours >= 25) && (GPA >= 1.70))
			{
				passed = true;
			} 
		} break;
		case 2: {
			if((cumHours >= 50) && (GPA >= 1.85))
			{
				passed = true;
			} 
		} break;
		case 3:{
			if((cumHours >= 85) && (GPA >= 1.95))
			{
				passed = true;
			}
		} break;
		default: System.out.println("oops");
		}
		
		if (passed)
		{
			System.out.println("****** ELIGIBLE ******");
			eligible++;
		} else
		{
			System.out.println("****** INELIGIBLE ******");
		}
	}
	/*
	 * This is the main method and it contains the main loop of the program. Until the user is finished using the program
	 * it will continue to prompt the user for a student and the various variables tied to a student.
	 * When the process finishes it prints out a summary of the program to the user
	 * 
	 * @author Martin Dampier
	 * @since 10/28/19
	 * 
	 */
	public static void main(String[] args) 
	{
		int numberProcessed = 0;
		boolean done = false;
		while(!done)
		{
			String hoursBFYear = "Enter total hours compeleted before this year";
			String studentID = studentID();
			int collegeLevel = collegeLevel();
			hours = collectHours(hoursBFYear); // Not only does this set hours to a standard value but it also resets the variable to be reused for each student.
			System.out.println("Please input your classes for this semester one at a time.");
			double GPA = calculateGPA();
			result(collegeLevel, studentID, hours, GPA);
			System.out.println("Would you like to enter information for additional student(s)? (Y/N)");
			numberProcessed++;
			done = yesOrNo();
		}
		System.out.println("*******************************************************");
		System.out.println("*                  Summary Statistics                 *");
		System.out.println("*******************************************************");
		System.out.println("Number of students processed: \t" + numberProcessed);
		System.out.println("Number found to be eligible: \t" + eligible);
	}

}
