import java.util.Scanner;

public class Project06a 
{

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		
		//Requests a credit card number input from the user
		System.out.print("Enter a credit card number (enter a blank line to quit): ");
		String num = keyboard.nextLine();
		
		
		//Tests for an empty string
		while(num.length() != 0)
		{
			
			
			//Tests for a 16 character string
			if(num.length() == 16)
			{
				//Declares variables we will need throughout the code; coerces the last character of the string into a digit.
				char lastDigit = num.charAt(15);
				int checkDigitIs = Character.getNumericValue(lastDigit);
				int checkDigitShould = 0 ;
				
				int pos = num.length() - 3;
				
				//Loops to sum digits and find the check digit
				while (pos >= 0)
				{
					//Tests if position is even or odd
					if (pos % 2 == 0)
					{
						int position = Character.getNumericValue(num.charAt(pos));
						int positionTimes = position * 2;
						
						//Tests if multiplied value is double digits and adds to Check Digit
						if (positionTimes > 9)
						{
							int positionMinus = positionTimes - 9;
							checkDigitShould = checkDigitShould + positionMinus;
						}
						else
						{
							
							checkDigitShould = checkDigitShould + positionTimes;
						}
						
						pos = pos - 2;
					}
					else
					{
						int position = Character.getNumericValue(num.charAt(pos));
						checkDigitShould = checkDigitShould + position;
						pos = pos -2;
					}
				}
				
				//Prints result
				if (checkDigitIs == checkDigitShould % 10)
				{
					System.out.println("Number is valid.");
				}
				else 
				{
					System.out.println("Number is not valid");
				}
			
				System.out.println();
				System.out.print("Enter a credit card number (enter a blank line to quit): ");
				num = keyboard.nextLine();
			}
			
			//If string is not 16 characters
			else
			{
				System.out.println("ERROR! Number MUST have exactly 16 digits");
				//Declares variables we will need throughout the code; coerces the last character of the string into a digit.
				System.out.println();
				System.out.print("Enter a credit card number (enter a blank line to quit): ");
				num = keyboard.nextLine();
				
			}	
			
		}
		
		//Quits the program when a blank line is entered
		if (num.length() == 0)
		{
			System.out.println("Goodbye!");
		}

	}

}
