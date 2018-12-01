/** Project02.java
 * 
 * This program:
 * Requests a long string from the user. 
 * Requests a substring from the user. 
 * Returns the length of string, length of substring, starting position of substring, string before and after the substring. 
 * Requests a position between the first and last character of the string. 
 * Returns the character at that is at that position.
 * Requests a replacement string. 
 * Replaces the first substring with the replacement string in the main string and returns the new string.
 *
 * @version 20170903
 * 
 */

import java.util.Scanner;

public class Project02 
{

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a long string: ");
    
		String mainString = keyboard.nextLine();
		System.out.print("Enter a substring: ");
    
		String subMainString = keyboard.nextLine();
		int lengthMainString = mainString.length();
    
		System.out.println("Length of your string: " + lengthMainString);
		int lengthSubMainString = subMainString.length();
		System.out.println("Length of your substring: " + lengthSubMainString);
		int startingPosition = mainString.indexOf(subMainString);
		int endingPosition = startingPosition + lengthSubMainString;
		System.out.println("Starting position of your substring in string: " + startingPosition);
		System.out.println("String before your substring: " + mainString.substring(0, startingPosition));
		System.out.println("String after your substring: " + mainString.substring(endingPosition));
		System.out.print("Enter a position between 0 and " + (lengthMainString - 1) + " : ");
		int posChar = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println("The character at position " + posChar + " is: " + mainString.charAt(posChar));
		System.out.print("Enter a replacement string: ");
		String subMainReplace = keyboard.nextLine();
		String newMainString = mainString.replace(subMainString, subMainReplace);
		System.out.println("Your new string is: " + newMainString);

	}

}
