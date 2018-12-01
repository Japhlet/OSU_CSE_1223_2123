/**
 * Project04.java
 * This program plays the game Dragon Trainer with user.
 * It's like Rock, Paper, Scissors... but with dragons. 
 * 
 * @version 20170915
 * 
 */

import java.util.Scanner;

public class Project04 
{

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please select one of your dragons [Fire/Plant/Water]: ");
		String dragonPick = keyboard.nextLine();
		int userPick = 0;
		
		//Reads user input to determine which dragon they have chosen; outputs their selection. 
		
		if (dragonPick.equalsIgnoreCase("fire") || dragonPick.equalsIgnoreCase("f")) 
		{
			userPick = 1;
			System.out.println("You chose: Fire dragon");
		}
		else if (dragonPick.equalsIgnoreCase("water") || dragonPick.equalsIgnoreCase("w"))
		{
			userPick = 2;
			System.out.println("You chose: Water dragon");
		}
		else if (dragonPick.equalsIgnoreCase("plant") || dragonPick.equalsIgnoreCase("p"))
		{
			userPick = 3;
			System.out.println("You chose: Plant dragon");
		}
		else 
		{
			System.out.println("You do not have a " + dragonPick + " dragon, so you choose no dragons.");
		}
		
		//Assigns each dragon type to a number
		int fireDragon = 1;
		int waterDragon = 2;
		int plantDragon = 3; 
		
		//Computer picks a random number between 1 and 3 to choose its dragon
		int compPick = (int)(3 * Math.random()) + 1; 
		
		
		//Computer picks Fire dragon and outputs match results
		if (compPick == 1)
		{
			if (userPick == 1)
			{
				System.out.println ("I chose: Fire dragon");
				System.out.println("A Tie!");
			}
			else if (userPick == 2)
			{
				System.out.println ("I chose: Fire dragon");
				System.out.println("Water defeats Fire - you win!");
			}
			else if (userPick == 3)
			{
				System.out.println ("I chose: Fire dragon");
				System.out.println("Fire defeats Plant - you lose!");
			}
			else // if user did not pick a valid dragon option 
			{
				System.out.println ("I chose: Fire dragon");
				System.out.println ("You lose by default!");
			}
		
		}
		
		//Computer picks Water dragon and outputs match results
		if (compPick == 2)
		{
			if (userPick == 1)
			{
				System.out.println("I chose: Water dragon");
				System.out.println("Water defeats Fire - you lose!");
			}
			else if (userPick == 2)
			{
				System.out.println("I chose: Water dragon");
				System.out.println("A Tie!");
			}
			else if (userPick == 3)
			{
				System.out.println("I chose: Water dragon");
				System.out.println("Plant defeats Water - you win!");
			}
			else // if user did not pick a valid dragon option
			{
				System.out.println ("I chose: Water dragon");
				System.out.println ("You lose by default!");
			}
		}
		
		//Computer picks Plant dragon and outputs match results
		if (compPick == 3)
		{
			if (userPick == 1)
			{
				System.out.println("I chose: Plant dragon");
				System.out.println("Fire defeats Plant - you win!");
			}
			else if (userPick == 2)
			{
				System.out.println("I chose: Plant dragon");
				System.out.println("Plant defeats Water - you lose!");
			}
			else if (userPick == 3)
			{
				System.out.println("I chose: Plant dragon");
				System.out.println("A Tie!");
			}
			else //if user did not pick a valid dragon option
			{
				System.out.println ("I chose: Plant dragon");
				System.out.println ("You lose by default!");
			}
		}

	}

}
