/**
 * Project05.java
 * 
 * @version 20180406
 * 
 */

import java.util.*;
import java.io.*;

public class Project05 
{

	public static void main(String[] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter a filename:" );
		Map<String, List<Path>> adjList = readPaths(keyboard.nextLine());
		
		displayAdjacencyList(adjList);
		
		System.out.print("Enter a start city (empty line to quit): ");
		String startingPoint = keyboard.nextLine();
		
		while(!startingPoint.isEmpty())
		{
			Map<String, Double> distances = findDistances(startingPoint, adjList);
			
			System.out.println("Distances from " + startingPoint + " to each city: ");
			displayShortest(startingPoint, distances);
			
			System.out.println("Enter a start city (empty line to quit): ");
			startingPoint = keyboard.nextLine();
			
		}
		
		System.out.println("Goodbye!");
		
		keyboard.close();
	}
	
	public static Map<String, List<Path>> readPaths(String fname)
	{
		Map<String, List<Path>> adjacencyList = new HashMap<String, List<Path>>();

		try
		{
			File fileName = new File(fname);
			Scanner inFile = new Scanner(fileName); 

			while(inFile.hasNext())
			{
				//Reads and splits the next line in the file
				String toSplit = inFile.nextLine();
				String [] arrStrings = toSplit.split(",", 3);
				
				String node1 = arrStrings[0];
				String node2 = arrStrings[1];
				String toParse = arrStrings[2];
				double distance = Double.parseDouble(toParse);
				
				//Assigns the split strings and parsed double above to appropriate variable and builds the new path
				String endpoint = node2;
				double cost = distance;
				Path newPath = new Path(endpoint, cost);
				
				//Puts the new path for node1 into the Map
				Set<String> keySet = adjacencyList.keySet();
				
				//Updates existing list of paths if node1 has already been entered
				if(keySet.contains(node1))
				{
					List<Path> toUpdate = adjacencyList.get(node1);
					toUpdate.add(newPath);
					
					adjacencyList.put(node1, toUpdate);
				}
				
				//Creates a new entry into the map if node1 does not yet exist as a key
				else
				{
					List<Path> pathList = new ArrayList<Path>();
					pathList.add(newPath);
					adjacencyList.put(node1, pathList);
				}
				
				
				//Same as for above, but with node2 as the starting point, to account for two-way trips
				endpoint = node1;
				Path revPath = new Path(endpoint, cost);
			
				if(keySet.contains(node2))
				{
					List<Path> toUpdate = adjacencyList.get(node2);
					toUpdate.add(revPath);
					
					adjacencyList.put(node2, toUpdate);
				}
				
				else
				{
					List<Path> pathList = new ArrayList<Path>();
					pathList.add(revPath);
					adjacencyList.put(node2, pathList);
				}
					
			}
			
			inFile.close();
		}
		
		catch (IOException e)
		{
			System.out.println("Unable to open file " + e);
			System.exit(0);
		}
		
		return adjacencyList;
		
	}
	
	public static void displayAdjacencyList(Map<String, List<Path>> map)
	{
		//TODO Print adjacency list
		
		Set<String> keySet = map.keySet();
		Iterator<String> keyIt = keySet.iterator();
		
		System.out.println();
		while(keyIt.hasNext())
		{
			String toPrintKey = keyIt.next();
			
			System.out.print(toPrintKey + ": ");
			List<Path> toPrint = map.get(toPrintKey);
			
			String output = toPrint.get(0).toString();
			System.out.print(output);
			
			for (int pos = 1; pos < toPrint.size(); ++pos)
			{
				System.out.print(", ");
				
				output = toPrint.get(pos).toString();
				System.out.print(output);
				
			}
			
			System.out.println();
		
		}
		
		System.out.println();
		
	}
	
	
	public static Map<String, Double> findDistances(String start, Map<String,List<Path>> adj_list)
	{
	
		//Constructs the new map of names and final path costs
		Map<String, Double> shortestDistances = new HashMap<String, Double>();
		
		//Constructs the PriorityQueue
		PriorityQueue<Path> pathCosts = new PriorityQueue<Path>();
		
		//Puts start position in the PriorityQueue
		Path startPath = new Path(start, 0.0);
		pathCosts.add(startPath);
		
		//Loops through the PriorityQueue until it is empty
		while(!pathCosts.isEmpty())
		{
			Path current = pathCosts.remove();
			String endPoint = current.getEndpoint();
			
			Set<String> shortNames = shortestDistances.keySet();
			if(!shortNames.contains(endPoint))
			{
				double d = current.getCost();
				String dest = endPoint;
				
				shortestDistances.put(dest, d);
				
				//Evaluates node/cost pairs for dest in the adjacency list
				List<Path> pairs = adj_list.get(dest);
				
				for (int pos = 0; pos < pairs.size(); ++pos)
				{
					Path n = new Path(pairs.get(pos).getEndpoint(), d + pairs.get(pos).getCost());
					pathCosts.add(n);
				}
			}
		}
		
		return shortestDistances;
	}
	
	public static void displayShortest(String start, Map<String, Double> shortest)
	{
		
		System.out.println("Dest. City               Distance");
		System.out.println("--------------           --------");
		
		Set<String> mapKey = shortest.keySet();
		Iterator<String> mapIt = mapKey.iterator();
		
		while(mapIt.hasNext())
		{
			String dest = mapIt.next();
			double dist = shortest.get(dest);
			
			System.out.printf("%-20s %8.1f", dest, dist);
			System.out.println();
		}
		
		System.out.println();
	}

}
