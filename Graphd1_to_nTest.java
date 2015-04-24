import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Graphd1_to_nTest
{
	//Main method: reads input and calls palindrome test, prints results 
   public static void main(String[] args) throws IOException
   {
		int[][] adjMatrix; // to hold stack
//		Graphd1_to_n Graph; // to hold the graphs object


		// open the file 
		 File file = new File("inSmall.txt");
		 Scanner inputFile = new Scanner(file);
		 
		int num_graphs = Integer.parseInt(inputFile.nextLine()); //read the number of graphs
	
		for(int n=0; n<num_graphs; n++)
		{	
			
			int num_vertices = Integer.parseInt(inputFile.nextLine()); //read first the line
			adjMatrix = new int[num_vertices][num_vertices]; // create and Array of stacks to hold an adjacency list
			int num_edges = Integer.parseInt(inputFile.nextLine()); //gets the number of edges
				
			for(int i=0; i< num_edges; i++)
			{	
				
				StringTokenizer st = new StringTokenizer(inputFile.nextLine());
				int vertex1 = Integer.parseInt(st.nextToken());
				int vertex2 = Integer.parseInt(st.nextToken());		// convert to integer
				adjMatrix[vertex1-1][vertex2-1] = 1; // push node into coresponding stack		
			}
			
			Graphd1_to_n Graph =  new Graphd1_to_n(adjMatrix);
			
			// get the shortes path
						
			
			// get the longest path
			
			// get the number of distinct path
			int np = Graph.numbDisctPath(1, num_vertices);
			System.out.println(np);
		}
		
		// close the file
		 inputFile.close();
	}
}