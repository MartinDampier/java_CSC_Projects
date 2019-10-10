	/* 
	 * This program is written to experiment with the use of 'print' and 'println' methods, variable declarations,
	 * string concatenation dividing integers and dividing real numbers or mixed operands.
	 * 
	 * CSC 1350 Programming Project no.2
	 * Section [2]
	 * @author Martin Dampier
	 * @since 9/9/19
	 */
public class Prog01_ExploringJava {
	
public static void main(String[]args)
{
	//step7, 8, 9, 10
	//this was to demonstrate the numerous ways you can initialize a variable.
	//You can initialize the variable then add a value later. You can do multiple variables on the same line
	//You can also declare variables on seperate lines
	int first = 3, second = 8;
	
	//step2
	//this was to demonstrate how System.out.println is used
    System.out.println("first name: John"); //need '(',')', and the double quotes
    System.out.println(" last name: Tyler");   //the leading space aligns the ":"s
    
    //step6 part 1
    //This is to create a break in the output 
    System.out.println();
    
    //step4
    //this is a copy of step2 to demonstrate copying
    System.out.println("first name: John");
    System.out.println(" last name: Tyler");
    
    //step6 part 2
    System.out.println();
    System.out.println("first name: John");
    System.out.println(" last name: Tyler");
    
    //step11
    //an example of using strings and numbers in the same line and using one line to print out two seperate lines of output
    System.out.println();
    System.out.println("first = " + first + ", second = " + second);
    
    //step15
    //an example of using basic math
    double average = (first + second)/2.0;
    System.out.println();
    System.out.println("Average = " + average);
    
    //step16
    //an example that demonstrates the remainder operator
    int quotient = second / first;
    int remainder = second % first;
    System.out.println();
    System.out.println("Quotient of second/first = " + quotient);
    System.out.println("Remainder of second/first = " + remainder);
    
    //step17
    //an example of the String type
    System.out.println();
    String firstname = "John";
    System.out.println("first name: " + firstname);
    
    //step19
    //another example of the String type
    String name = "John Tyler";
    System.out.println();
    System.out.println("name: " + name);
}
}
