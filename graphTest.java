/*
*Name: Ouermi Timbwaoga Aime Judicael
*Course: cis315
*Instructor: Chris Wilson
* hw 2 lab 1
*/

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class graphTest
{
	//Main method: reads input and calls palindrome test, prints results 
   public static void main(String[] args) throws IOException
   {
		String s;
		Scanner in = new Scanner(System.in); // to read from user
		System.out.println("Enter inSmall.txt or inMed.txt or inBig.txt");
		s = in.nextLine();
		// open the file 
		 File file = new File(s);
		 Scanner inputFile = new Scanner(file);
		 
		int num_graphs = Integer.parseInt(inputFile.nextLine()); //read the number of graphs
	
		for(int n=0; n<num_graphs; n++)
		{	
			int k = n+1;
			System.out.println("graph number: "+k);
			int num_vertices = Integer.parseInt(inputFile.nextLine()); //read first the line
			Linklist[]	adjList = new Linklist[num_vertices]; // create a link list array
			for(int i=0; i<num_vertices; i++)
			{
				Linklist L = new Linklist();
				adjList[i] = L;
			}
			int num_edges = Integer.parseInt(inputFile.nextLine()); //gets the number of edges
				
			for(int i=0; i< num_edges; i++)
			{	
				StringTokenizer st = new StringTokenizer(inputFile.nextLine());
				int vertex1 = Integer.parseInt(st.nextToken());
				int vertex2 = Integer.parseInt(st.nextToken());		// convert to integer
				adjList[vertex1-1].insertList(vertex2) ; // insert in corresponding list
			}
			
			graph g =  new graph(adjList, num_vertices);
			
			// get the shortes path
			int sp = g.shorestP(1, num_vertices);
			System.out.println("shortest path: "+sp);			
			// get the longest path
			int lp = g.longestP(1, num_vertices);
			System.out.println("longest path: "+lp);
			// get the number of distinct path
			int np = g.numbDP(1, num_vertices);
			System.out.println("number of paths: "+np);
			System.out.println();
		}
		
		// close the file
		 inputFile.close();
	}
}
