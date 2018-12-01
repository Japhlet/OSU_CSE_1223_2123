/*
 * Project07.java
 * 
 * A program that plays the dice game high/low
 * 
 * @version 20171012
 * 
 */

import java.util.Scanner;


public class Project07 
{


	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in); 
		int currentPool = 100;
		int bet = getBet(keyboard, currentPool);
		
		while (currentPool > 0 && bet > 0)
		{
			char highLow = getHighLow(keyboard);
			int die1 = getRoll(); 
			
			System.out.println("Die 1 rolls: " + die1);
			int die2 = getRoll(); 
			System.out.println("Die 2 rolls: " + die2);
			
			int roll = die1 + die2; 
			System.out.println("Total of two dice is: " + roll);
			
			int winnings = determineWinnings(highLow, bet, roll); 
			currentPool = currentPool + winnings;
			bet = getBet(keyboard, currentPool);
		}
		
		System.out.println();
		System.out.println("You have " + currentPool + " dollars left");
		System.out.println("Goodbye!");
		
	}
	
	
	// Given a Scanner and a current maximum amount of money, prompt the user for
	// an integer representing the number of dollars that they want to bet.  This
	// number must be between 0 and to maximum number of dollars.  If the user enters
	// a number that is out of bounds, display an error message and ask again.
	// Return the bet to the calling program.
	
	private static int getBet(Scanner keyboard, int currentPool) 
	{
		System.out.println("You have " + currentPool + " dollars.");
		System.out.print("Enter an amount to bet (0 to quit): ");
		int bet = keyboard.nextInt();
		
		if (bet < 0 || currentPool <= bet)
		{
			System.out.println("Your bet MUST be between 0 and  " + currentPool + "dollars.");
			System.out.println("You have " + currentPool + "dollars.");
			System.out.print("Enter an amount to bet (0 to quit): ");
			bet = keyboard.nextInt();
		}
		
		return bet; 	
	}
	
	// Given a Scanner, prompt the user for a single character indicating whether they
	// would like to bet High ('H'), Low ('L') or Sevens ('S').  Your code should accept
	// either capital or lowercase answers, but should display an error if the user attempts
	// to enter anything but one of these 3 values and prompt for a valid answer.
	// Return the character to the calling program.
	private static char getHighLow(Scanner keyboard) 
	{
		char hls = ' ';
		String hlsStr = ""; 
		System.out.print("High, low or sevens (H/L/S): ");
		hlsStr = keyboard.nextLine();
		
		if (hlsStr.equalsIgnoreCase("h") || hlsStr.equalsIgnoreCase("l") || hlsStr.equalsIgnoreCase("s"))
		{
			hls = hlsStr.charAt(0);
		}
		
		else 
		{
			System.out.println("ERROR: Choice must either be 'H', 'L', or 'S'.");
			System.out.print("High, low or sevens (H/L/S): ");
			hlsStr = keyboard.nextLine();
			
			hls = hlsStr.charAt(0);
		}
		return hls;
		
	}
	
	// Produce a random roll of a single six-sided die and return that value to the calling
	// program
	private static int getRoll() 
	{
		int diceRoll =  (int)(6 * Math.random()) + 1;
		return diceRoll;
	}
	
	// Given the choice of high, low or sevens, the player's bet and the total result of
	// the roll of the dice, determine how much the player has won.  If the player loses
	// the bet then winnings should be negative.  If the player wins, the winnings should
	// be equal to the bet if the choice is High or Low and 4 times the bet if the choice
	// was Sevens.  Return the winnings to the calling program.
	private static int determineWinnings(char highLow, int bet, int roll) 
	{
		int winnings = 0;
		
		if (highLow == 'h')
		{
			if (roll >= 8)
			{
				System.out.println("Yon won " + bet + " dollars!");
				winnings = bet; 
			}
			else
			{
				System.out.println("You lost!");
				winnings = 0 - bet; 
			}
		}
		
		else if (highLow == 'l')
		{
			if (roll <= 6)
			{
				System.out.println("Yon won " + bet + " dollars!");
				winnings = bet; 
			}
			else
			{
				System.out.println("You lost!");
				winnings = 0 - bet; 
			}
			
		}
		
		else if (highLow == 's')
		{
			if (roll == 7)
			{
				System.out.println("Yon won " + bet + " dollars!");
				winnings = bet * 4; 
			}
			else
			{
				System.out.println("You lost!");
				winnings = 0 - (bet * 4); 
			}
		}
		
		return winnings; 
	}

}
