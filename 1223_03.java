/**
 * Project03.java
 * This project will prompt the user to enter their name, then greet them.
 * Then it will ask them to answer a series of math questions, telling them whether they are correct or wrong. 
 * Finally, it will tell them how many they got right, and what percentage they earned. 
 *
 * @version 20170910
 * 
 */

import java.util.Scanner;

public class Project03 
{

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		//Prompts user for their name and greets them.
		System.out.print("Enter your name: ");
		String nameStr = keyboard.nextLine();
		System.out.println("Welcome " + nameStr + "! Please answer the following questions:");
		System.out.println("");
		
		//Asks a series of math questions
		int randomNum1 = (int)(20 * Math.random()) + 1;
		int randomNum2 = (int)(20 * Math.random()) + 1;
		double tally1;
		double tally2;
		double tally3;
		double tally4; 
		
		System.out.print(randomNum1 + " + " + randomNum2 + " = ");
		int addition = keyboard.nextInt();
		
		//Informs user of if they are right or wrong. 
		if (addition == randomNum1 + randomNum2)
		{
			System.out.println("Correct!");
			tally1 = 1;
		}
		else
		{
			System.out.println("Wrong!");
			System.out.println("The correct answer is " + (randomNum1 + randomNum2));
			tally1 = 0;
		}
		System.out.println();
		
		System.out.print(randomNum1 + " * " + randomNum2 + " = "); 
		int multiplication = keyboard.nextInt();
		
		if (multiplication == randomNum1 * randomNum2)
		{
			System.out.println("Correct!");
			tally2 = 1;
		}
		else
		{
			System.out.println("Wrong!");
			System.out.println("The correct answer is " + (randomNum1 * randomNum2));
			tally2 = 0;
		}
		System.out.println();
		
		System.out.print(randomNum1 + " / " + randomNum2 + " = ");
		int division = keyboard.nextInt();
		
		if (division == randomNum1 / randomNum2)
		{
			System.out.println("Correct!");
			tally3 = 1;
		}
		else
		{
			System.out.println("Wrong!");
			System.out.println("The correct answer is " + (randomNum1 / randomNum2));
			tally3 = 0;
		}
		
		System.out.println();
		
		System.out.println(randomNum1 + " % " + randomNum2 + " = ");
		int remainder = keyboard.nextInt();
		
		if (remainder == randomNum1 % randomNum2)
		{
			System.out.println("Correct!");
			tally4 = 1;
		}
		else
		{
			System.out.println("Wrong!");
			System.out.println("The correct answer is " + (randomNum1 % randomNum2));
			tally4 = 0;
		}
		
		System.out.println();
		
		//Tallies up the correct answers and informs user of percentage correct.
		double tally = (tally1 + tally2 + tally3 + tally4);
		System.out.println("You got " + (int)tally + " correct answers");
		double denominator = 4.0;
		double percentageCorrect = (tally/denominator) * 100;
		System.out.println("That's " + percentageCorrect + "%!");
		
		
	}
}
