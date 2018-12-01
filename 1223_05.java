/**
 * Project05.java
 * This program plays "Guess the Number" with the user, giving the user feedback as they play, and then insulting them when they finally get it.
 * 
 * @version 20170921
 * 
 */

import java.util.Scanner;

public class Project05 
{

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		//Computer randomly generates a number between 1 and 200
		int compPick = (int)(200 * Math.random()) + 1;
		
		//Requests a guess from the user
		System.out.print("Enter a guess between 1 and 200: ");
		int userPick = keyboard.nextInt();
		int tally = 1;
		
		
		//Compares compPick to userPick
		while (userPick != compPick)
		{
			if (userPick > 200 || userPick < 1)
			{
				System.out.println("Your guess is out of range. Pick a number between 1 and 200.");
				tally = tally + 1;
				System.out.println();
				System.out.print("Enter a guess between 1 and 200: ");
				userPick = keyboard.nextInt();
			}
			
			
			else if (userPick < compPick)
			{
				System.out.println("Your guess was too low. Try again.");
				System.out.println();
				tally = tally + 1;
				System.out.print("Enter a guess between 1 and 200: ");
				userPick = keyboard.nextInt();
			}
			
			else if (userPick > compPick)
			{
				System.out.println("Your guess was too high. Try again.");
				System.out.println();
				tally = tally + 1;
				System.out.print("Enter a guess between 1 and 200: ");
				userPick = keyboard.nextInt();
			}
		}
		
		if (userPick == compPick)
		{
			System.out.println("Congratulations! Your guess was correct!");
			System.out.println();
			System.out.println("I had chosen " + compPick + " as the target number.");
			System.out.println("You guessed it in " + tally + " tries.");
			
			if (tally == 1)
			{
				System.out.println("That was astounding!");
			}
			
			else if (tally > 1 && tally < 5)
			{
				System.out.println("That was lucky!");
			}
			
			else if (tally > 4 && tally < 7)
			{
				System.out.println("That was pretty good.");
			}
			
			else if (tally == 7)
			{
				System.out.println("That was not that impressive.");
			}
			
			else if (tally > 7 && tally < 10)
			{
				System.out.println("Are you sure this is the right game for you?");
			}
			
			else if (tally > 9)
			{
				System.out.println("This just isn't your game, is it?");
			}
		}

	}

}
