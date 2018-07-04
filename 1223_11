/*
 * Project11.java
 * 
 *   A program that reads in a text file that uses a specific input format and uses it to
 *   produce a formatted report for output.
 * 
 * @version 20171118
 * 
 */

import java.io.*;
import java.util.*;

public class Project11 
{
	
	public static void main(String[] args) throws IOException
	{
		
		Scanner keyboard = new Scanner(System.in);
		String inFileName = getInFileName(keyboard); //Gets name of input file
		String outFile = getOutFileName(keyboard); //Gets name of output file
		
		//Initializes useful variables
		String hiAvgName = "";
		String loAvgName = "";
		int hiAvg = 0; 
		int loAvg = 10000;
		int tally = 0;
		
		try
		{
			File inFile = new File(inFileName);
			Scanner inScanner = new Scanner(inFile); //Initializes input Scanner
			
			ArrayList<Integer> scores = new ArrayList<Integer>(); 
			ArrayList<String> names = new ArrayList <String>();
			
			PrintWriter output = new PrintWriter(outFile); //Initializes output writer
			
			//Prints output header
			output.println("Final Overall Scores Report");
			output.println();
			output.println("Name                    Mean  Median   Max   Min");
			output.println("------------------    ------  ------  ----  ----");
			
			//Runs blocks and prints to output file
			while(inScanner.hasNext())
			{
				String playerName = inScanner.nextLine();
				names.add(playerName);
				scores = readNextSeries(inScanner); //Reads block until negative number input
				int mean = getAverage(scores); //Finds the average of block
				int median = getMedian(scores); //Finds the median of the block
				int max = getMax(scores); //Finds maximum score in block
				int min = getMin(scores); //Finds minimum score in block
				 
				
				//Prints details for player
				output.printf("%-21s %6d %7d %6d %4d", playerName, mean, median, max, min);
				output.println();
				
				if (mean > hiAvg) //Tests for highest average score
				{
					hiAvg = mean;
					
					if (tally > 0)
					{
						hiAvgName = names.get(tally);
					}
					else
					{
						hiAvgName = names.get(0);
					}
						
					
				}
				
				if (mean < loAvg) //Tests for lowest average score
				{
					loAvg = mean;
					
					if (tally > 0)
					{
						loAvgName = names.get(tally);
					}
					else
					{
						loAvgName = names.get(0);
					}
				}
				
				tally = tally + 1; //Counts iterations of loop to determine number of players
				
			}
			
			//Prints footer summary details
			output.println();
			output.println("Total number of participants: " + tally);
			output.println("Higest average score: " + hiAvgName  + " (" + hiAvg + ")");
			output.println("Lowest average score: " + loAvgName + " (" + loAvg + ")");
			
			//Closes files
			inScanner.close();
			output.close();
			
		}
		
		catch (IOException e)
		{
			System.out.println("Could not open file.");
		}
		
		catch (IllegalStateException e)
        {
            System.out.println("IllegalStateException: " + e.getMessage());
        }
	}
	
	private static String getInFileName(Scanner keyboard)
	{
		System.out.print("Enter input file name: ");
		String fileName = keyboard.nextLine();
		
		return fileName; 
	}
	
	private static String getOutFileName(Scanner keyboard)
	{
		System.out.print("Enter output file name: ");
		String fileName = keyboard.nextLine();
		
		return fileName; 
	}
	
	// Given a Scanner as input read in a list of integers one at a time until a negative
	// value is read from the Scanner.  Store these integers in an ArrayList<Integer> and
	// return the ArrayList<Integer> to the calling program.
	
	private static ArrayList<String> getPlayerNames(Scanner inScanner)
	{
		ArrayList<String> names = new ArrayList<String>();
		
		String coerce = inScanner.nextLine();
		
		while (inScanner.hasNext())
		{
			if (!(coerce.charAt(0)=='0') && !(coerce.charAt(0)=='1') && !(coerce.charAt(0)=='2') &&
					!(coerce.charAt(0)=='3') && !(coerce.charAt(0)=='4') && !(coerce.charAt(0)=='5')
					&& !(coerce.charAt(0)=='6') && !(coerce.charAt(0)=='7') && !(coerce.charAt(0)=='8')
					&& !(coerce.charAt(0)=='9') && !(coerce.charAt(0)=='-'))
			{
				names.add(coerce);
				inScanner.nextLine();
			}
			
			else
			{
				inScanner.nextLine();
			}
		}
		
		return names;
		
	}
	
	
	private static ArrayList<Integer> readNextSeries(Scanner inScanner) 
	{
		ArrayList<Integer> scores = new ArrayList<Integer>();
		
		String coerce = inScanner.nextLine(); //Reads the next line
		
		if (!(coerce.charAt(0)=='0') && !(coerce.charAt(0)=='1') && !(coerce.charAt(0)=='2') &&
				!(coerce.charAt(0)=='3') && !(coerce.charAt(0)=='4') && !(coerce.charAt(0)=='5')
				&& !(coerce.charAt(0)=='6') && !(coerce.charAt(0)=='7') && !(coerce.charAt(0)=='8')
				&& !(coerce.charAt(0)=='9') && !(coerce.charAt(0)=='-'))
		{
			
			coerce = inScanner.nextLine();
		}
		
		int test = Integer.parseInt(coerce); //Converts String value to integer
		
		while ((inScanner.hasNext()) && (test >=0)) //Tests for existence of next line and presence of a negative number
		{
			scores.add(test); //Adds score to Array
			
			
			coerce = inScanner.nextLine();
			
			test = Integer.parseInt(coerce);
		}
		
		return scores;
		
	}
	
	// Given a ArrayList<Integer> of integers, compute the median of the list and return it to
	// the calling program.
	private static int getMedian(ArrayList<Integer> inList) 
	{
		Collections.sort(inList);
		int median = 0;
		
		if (inList.size()%2 == 0)
		{
			
		}
		else
		{
			int position = inList.size()/2;
			median = inList.get(position);
		}
		
		return median; 
		
		
	}
	
	// Given a ArrayList<Integer> of integers, compute the average of the list and return it to
	// the calling program.
	private static int getAverage(ArrayList<Integer> inList) 
	{
		int add = 0; 
		int mean = 0; 
		for(int pos = 0; pos < inList.size(); ++pos)
		{
			add = add + inList.get(pos);
			
		}
		
		mean = add/inList.size(); 
		
		return mean; 
		
	}
	
	private static int getMin(ArrayList<Integer> inList)
	{
		int min = inList.get(0); 
		
		
		for (int pos = 1; pos < inList.size(); ++ pos)
		{
			int test = inList.get(pos);
			
			if (test < min)
			{
				min = test;
			}
			
		}
		
		return min;
	}
	
	private static int getMax(ArrayList<Integer> inList)
	{
		int max = inList.get(0); 
		
		
		for (int pos = 1; pos < inList.size(); ++ pos)
		{
			int test = inList.get(pos);
			
			if (test > max)
			{
				max = test;
			}
			
		}
		
		return max;
	}
	
	public static boolean isInteger(String str) 
	{
	    try 
	    {
	        Integer.parseInt(str);
	        return true;
	    } 
	    catch (NumberFormatException nfe) 
	    {
	        return false;
	    }
	}
	

}
