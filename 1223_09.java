/**
 * Project09.java
 *
 *   A program that converts binary numbers into decimal numbers.
 *
 *   @author Elliot Ping
 *   @version 20171022
 */

import java.util.Scanner;

public class Project09 
{

    public static void main(String[] args) 
    {
        System.out.println("Converting from Binary to Decimal");
    	Scanner input = new Scanner(System.in); 
    	String binaryVal = promptForBinary(input);
    	
    	while (binaryVal.length() != 0)
    	{
    		int decimal = binaryToDecimal(binaryVal);
    		System.out.println("The binary value " + binaryVal + " is " + decimal + " in decimal (base 10).");
    		System.out.println();
    		
    		binaryVal = promptForBinary(input);
    		
    	}
    	
    	System.out.println("Goodbye");
    }

    /**
     * Given a Scanner as input, prompt the user to enter a binary value. Use
     * the function checkForValidBinary below to make sure that the value
     * entered is actually a binary value and not junk. Then return the value
     * entered by the user as a String to the calling method.
     *
     * @param input
     *            A scanner to take user input from
     * @return a String representing a binary value read from the user
     */
    public static String promptForBinary(Scanner input) 
    {
    	System.out.print("Enter a binary value (empty line to quit): " );
        String binaryVal = input.nextLine();
    	
        while (!checkForBinaryValue(binaryVal) && binaryVal.length() > 0)
        {
            	System.out.println("ERROR - invalid binary value");
            	System.out.println();
            	
            	System.out.print("Enter a binary value (empty line to quit): " );
                binaryVal = input.nextLine();
        }
        
        return binaryVal;
    	
        
    }

    /**
     * Given a String as input, return true if the String represents a valid
     * binary value (i.e. contains only the digits 1 and 0). Returns false if
     * the String does not represent a binary value.
     *
     * @param value
     *            A String value that may contain a binary value
     * @return true if the String value contains a binary value, false otherwise
     */
    public static boolean checkForBinaryValue(String value) 
    {
        boolean isOrIsnt = true;
        int pos = 0; 
    	
    	while (pos < value.length() && isOrIsnt == true)
    	{
    		if (value.charAt(pos) == '0' || value.charAt(pos) == '1')
    		{
    			isOrIsnt = true; 
    			++pos; 
    		}
    		else
    		{
    			isOrIsnt = false;
    		}
    	}
    	
    	return isOrIsnt; 
    }

    /**
     * Given a binary value, return an int value that is the base 10
     * representation of that value. Your implementation must use the algorithm
     * described in the Project 9 write-up. Other algorithms will receive no
     * credit.
     *
     * @param value
     *            A String containing a binary value to convert to integer
     * @return The base 10 integer value of that binary in the String
     */
    public static int binaryToDecimal(String value) 
    {
    	int decimal = 0; 
    	int n = value.length()-1; 
    	String parseSub = "";
    	int pos = 0;
    	
    	while (n >= 0)
    	{
    		int bin = Character.getNumericValue(value.charAt(pos));;
    		int mult = bin * (int) Math.pow(2, n);
    		decimal = decimal + mult; 
    		
    		n = n-1;
    		pos = pos+1; 
    		
    	}
    	
    	return decimal; 
        
    }
}
