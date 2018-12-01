/*
 * Project10.java
 * 
 *   A program that plays and scores a round of the game Poker Dice.  In this game,
 *   five dice are rolled.  The player is allowed to select a number of those five dice
 *   to re-roll.  The dice are re-rolled and then scored as if they were a poker hand.  
 *   The following hands MUST be scored in this assignment:
 *   	* High card
 *   	* One Pair
 *   	* Two Pair
 *   	* Three of a Kind
 *   	* Full House
 *   	* Four of a Kind
 *   	* Five of a Kind
 *   For extra credit, you may also implement:
 *   	* Straight
 * 
 ( @version 20171108
 * 
 */
import java.util.Scanner;

public class Project10 
{

	public static void main(String[] args) 
	{
		boolean again = true;
		Scanner keyboard = new Scanner(System.in);
		int[] rolls = new int[5];
		
		while (again)
		{
			for (int pos=0; pos < rolls.length; ++pos)
			{
				rolls[pos] = (int)(Math.random()*10)+1;
			}
			
			
			String currentDice = diceToString(rolls); 
			System.out.println("Your current dice: " + currentDice);
			rolls = promptForReroll(rolls, keyboard);
			System.out.println("Rerolling...");
			rolls = rollDice(rolls);
			currentDice = diceToString(rolls);
			System.out.println("Your final dice: " + currentDice);
			String result = getResult(rolls);
			System.out.println(result);
			again = promptForPlayAgain(keyboard);
			
		}
		
		System.out.println();
		System.out.println("Goodbye!");
		
		
		
	}
	
	// Given an array of integers as input, sets every element of the array to zero.
	private static void resetDice(int[] dice) 
	{
		for (int pos = 0; pos < dice.length; ++pos)
		{
			dice[pos] = 0; 
		}
	}
	
	// Given an array of integers as input, checks each element of the array.  If the value
	// of that element is zero, generate a number between 1 and 10 and replace the zero with
	// it.  Otherwise, leave it as is and move to the next element.
	private static int[] rollDice(int[] dice) 
	{
		for (int pos = 0; pos < dice.length; ++pos)
		{
			while (dice[pos] == 0)
			{
				dice[pos] = (int)(Math.random()*10)+1;
			}
		}
		
		return dice;
	}
	
	// Given an array of integers as input, create a formatted String that contains the
	// values in the array in the order they appear in the array.  For example, if the 
	// array contains the values [0, 3, 7, 5, 2] then the String returned by this method
	// should be "0 3 7 5 2".
	private static String diceToString(int[] dice) 
	{
		String rolls = Integer.toString(dice[0]); 
		for (int pos = 1; pos < dice.length; ++pos)
		{
			rolls = rolls + " " + Integer.toString(dice[pos]);
		}
		
		return rolls; 
		
	}
	
	
	// Given an array of integers and a Scanner as input, prompt the user with a message
	// to indicate which dice should be re-rolled.  If the user enters a valid index (between
	// 0 and the total number of dice -1) then set the die at that index to zero.  If the 
	// user enters a -1, end the loop and return to the calling program.  If the user enters
	// any other invalid index, provide an error message and ask again for a valid index.
	private static int[] promptForReroll(int[] dice, Scanner inScanner) 
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Select a die to re-roll (-1 to keep remaining dice): ");
		int reroll = keyboard.nextInt();
		
		while (!(reroll == -1))
		{
			while ((!(reroll == 0)) && (!(reroll == 1)) && (!(reroll == 2)) && (!(reroll == 3)) && (!(reroll == 4)))
			{
				System.out.println("Error: Index must be between 0 and 4 (-1 to quit)!");
				System.out.println("Select a die to re-roll (-1 to keep remaining dice): ");
				reroll = keyboard.nextInt();
			}
			
			dice[reroll] = 0;
			System.out.println("Select a die to re-roll (-1 to keep remaining dice): ");
			reroll = keyboard.nextInt();
		}
		
		System.out.println("Keeping remaining dice...");
		
		return dice;
		
			
		}
		
	
	// Given a Scanner as input, prompt the user to play again.  The only valid entries
	// from the user are 'Y' or 'N', in either upper or lower case.  If the user enters
	// a 'Y' the method should return a value of true to the calling program.  If the user
	// enters a 'N' the method should return a value of false.  If the user enters anything
	// other than Y or N (including an empty line), an error message should be displayed
	// and the user should be prompted again until a valid response is received.
	private static boolean promptForPlayAgain(Scanner keyboard) 
	{
		boolean replay = false; 
		System.out.print("Would you like to play again [Y/N]?: ");
		String yoN = keyboard.nextLine();
		
		while (!(yoN.equalsIgnoreCase("y")) && !(yoN.equalsIgnoreCase("n")))
		{
			System.out.println("ERROR! Only 'Y' or 'N' allowed as input!");
			
			System.out.print("Would you like to play again [Y/N]?: ");
			yoN = keyboard.nextLine();
		}
		
		if (yoN.equalsIgnoreCase("y"))
		{
			replay = true; 
		}
		
		return replay;
	}
	
	// Given an array of integers, determines the result as a hand of Poker Dice.  The
	// result is determined as:
	//	* Five of a kind - all five integers in the array have the same value
	//	* Four of a kind - four of the five integers in the array have the same value
	//	* Full House - three integers in the array have the same value, and the remaining two
	//					integers have the same value as well (Three of a kind and a pair)
	//	* Three of a kind - three integers in the array have the same value
	//	* Two pair - two integers in the array have the same value, and two other integers
	//					in the array have the same value
	//	* One pair - two integers in the array have the same value
	//	* Highest value - if none of the above hold true, the Highest Value in the array
	//						is used to determine the result
	//
	//	The method should evaluate the array and return back to the calling program a String
	//  containing the score from the array of dice.
	//
	//  EXTRA CREDIT: Include in your scoring a Straight, which is 5 numbers in sequence
	//		[1,2,3,4,5] or [2,3,4,5,6] or [3,4,5,6,7] etc..
	
	private static String getResult(int[] dice) 
	{
		String score = "";
		
		int[] x = getCounts(dice);
        
		int[] count = new int[5];
		for (int a = 0; a < 5; ++a)
		{
		    if (x[a]-1 >= 0)
		    {
		    	++count[x[a]-1];
		    }	
			
		}
		
		if (count[(5)-1] == 1)
		{
			score = "Five of a Kind";
		}
		else if (count[(4)-1] == 1)
		{
			score = "Four of a Kind";
		}
		else if (count[(3)-1] == 1 && count[(2)-1] == 1)
		{
			score = "Full House";
		}
		else if (count[(3)-1] == 1 && count[(2)-1] == 0)
		{
			score = "Three of a Kind";
		}
		else if (count[(2)-1] == 2)
		{
			score = "Two pair";
		}
		else if (count[(2)-1] == 1 && count[(1)-1] == 3)
		{
			score = "One pair";
		}
		else 
		{
			int highest = dice[0];
			for (int pos = 1; pos < dice.length; ++pos)
			{
				
				if (dice[pos] > highest)
				{
					highest = dice[pos];
				}
				
			}
			
			String highestStr = Integer.toString(highest);
			
			score = "Highest card" + highestStr;
		}
		
		boolean straight = false;
		for (int a = 0; a < 10-(5-1); ++a)
		{
		    if (x[a] == 1)
		    {
		        boolean success = true;
		        for (int b = a+1; b < a+5; ++b)
		        {
		            if (x[b] != 1)
		            {
		                success = false;
		            }
		        }
		        if (success)
		        {
		            straight = true;
		        }
		    }
		}
		
		if (straight)
		{
			score = "Straight";
		}
		
		
		
		
		return score; 
		
	}
	
	// Given an array of integers as input, return back an array with the counts of the
	// individual values in it.  You may assume that all elements in the array will have 
	// a value between 1 and 10.  For example, if the array passed into the method were:
	//   [1, 2, 3, 3, 7]
	// Then the array of counts returned back by this method would be:
	// [1, 1, 2, 0, 0, 0, 1, 0, 0, 0]
	// (Where index 0 holds the counts of the value 1, index 1 holds the counts of the value
	//  2, index 2 holds the counts of the value 3, etc.)
	// HINT:  This method is very useful for determining the score of a particular hand
	//  of poker dice.  Use it as a helper method for the getResult() method above.
	private static int[] getCounts(int[] dice) 
	{
		int[] count = new int[10];
		for (int a = 0; a < 5; ++a)
		{
		    ++count[dice[a]-1];
		}
		return count;
	}


}
