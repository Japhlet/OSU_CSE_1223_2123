/**
 * Project01.java
 * 
 * @version 20180119
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Project01 
{

	public static void main(String[] args) throws IOException
	{
		//Opens keyboard Scanner and initializes necessary ArrayLists
		Scanner keyboard = new Scanner(System.in);
		ArrayList<String> title = new ArrayList<String>();
		ArrayList<String> type = new ArrayList<String>();
		ArrayList<Double> price = new ArrayList<Double>();
		ArrayList<Double> quantity = new ArrayList<Double>();
		
		try
		{
			//Gets input file name and opens the file. 
			String inFile = getFile(keyboard);
			File file = new File(inFile);
			Scanner inputFile = new Scanner(file);
			
			//Prints the report header
			System.out.println("Product Summary Report");
			printLine();
			
			//Reads the file; stores data in appropriate ArrayLists
			while(inputFile.hasNext())
			{
				title.add(inputFile.nextLine());
				
				String toDouble = inputFile.nextLine();
				double toAdd = Double.parseDouble(toDouble);
				quantity.add(toAdd);
				
				toDouble = inputFile.nextLine();
				toAdd = Double.parseDouble(toDouble);
				price.add(toAdd);
				
				type.add(inputFile.nextLine());
			}
			
			//Prints data from the appropriate ArrayLists
			for(int pos = 0; pos < title.size(); ++pos)
			{
				printTitle(title, pos);
				printType(type, pos);
				printPrice(price, pos);
				printQuantity(quantity, pos);
				
				System.out.println();
			}
			
			
			
			//Prints footer summary
			printLine();
			
			System.out.println("Total products in database: " + title.size());
			
			int largeQuant = highNum(quantity);
			System.out.println("Largest quanitity item: " + title.get(largeQuant) 
								+ " (" + type.get(largeQuant) + ")");
			
			int largeDollar = highDollar(price, quantity);
			System.out.println("Highest total dollar item: " + title.get(largeDollar)
								+ " ($" + (price.get(largeDollar)*quantity.get(largeDollar)) + ")");
			
			int smallQuant = smallNum(quantity);
			System.out.println("Smallest quanitity item: " + title.get(smallQuant) 
								+ " (" + type.get(smallQuant) + ")");
			
			int smallDollar = lowDollar(price, quantity);
			System.out.println("Lowest total dollar item: " + title.get(smallDollar)
								+ " ($" + (price.get(smallDollar)*quantity.get(smallDollar)) + ")");
			
			printLine();
			
			
			//Closes Scanners
			inputFile.close();
			keyboard.close();
			
		}
		
		catch (IOException e)
		{
			System.out.println("Could not open file" + e);
		}
		
	}
	
	//Gets the file name from the console
	private static String getFile(Scanner keyboard)
	{
		System.out.print("Enter database filename: ");
		String fileName = keyboard.nextLine();
		
		return fileName;
		
	}
	
	//Prints a dashed line, used in both the header and the footer
	private static void printLine()
	{
		System.out.println("------------------------------------------------------------");
	}
	
	private static void printTitle(ArrayList<String> title, int pos)
	{
		System.out.println("Title: " + title.get(pos));
		
	}
	
	private static void printType(ArrayList<String> type, int pos)
	{
		System.out.println("        Product Type: " + type.get(pos));
		
	}
	
	private static void printPrice(ArrayList<Double> price, int pos)
	{
		System.out.println("        Price: " + price.get(pos));
		
	}
	
	private static void printQuantity(ArrayList<Double> quantity, int pos)
	{
		System.out.println("        Quantity: " + quantity.get(pos));
		
		
	}
	
	private static int highNum(ArrayList<Double> numbers)
	{
		int index = 0;
		
		for(int pos = 1; pos < numbers.size(); ++pos)
		{
			int test = Double.compare(numbers.get(index), numbers.get(pos));
			if(test < 0)
			{
				index = pos;
			}
		}
		
		return index;
		
	}
	
	private static int highDollar(ArrayList<Double> price, ArrayList<Double> quantity)
	{
		int index = 0;
		double max = price.get(0) * quantity.get(0);
		
		for(int pos = 1; pos<price.size(); ++pos)
		{
			double test = price.get(pos) * quantity.get(pos);
			
			int compare = Double.compare(max, test);
			
			if(compare < 0)
			{
				index = pos;
				max = test;
			}
				
		}
		
		return index;
		
	}
	
	private static int smallNum(ArrayList<Double> numbers)
	{
		int index = 0;
		
		for(int pos = 1; pos < numbers.size(); ++pos)
		{
			int test = Double.compare(numbers.get(index), numbers.get(pos));
			if(test > 0)
			{
				index = pos;
			}
		}
		
		return index;
		
	}
	
	private static int lowDollar(ArrayList<Double> price, ArrayList<Double> quantity)
	{
		int index = 0;
		double min = price.get(0) * quantity.get(0);
		
		for(int pos = 1; pos<price.size(); ++pos)
		{
			double test = price.get(pos) * quantity.get(pos);
			
			int compare = Double.compare(min, test);
			
			if(compare > 0)
			{
				index = pos;
				min = test;
			}
				
		}
		
		return index;
		
	}

}
