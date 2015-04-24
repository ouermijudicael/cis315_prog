/*
*Name: Ouermi Timbwaoga Aime Judicael
*Course: cis315
*Instructor: Chris Wilson
* hw 2 lab 1
*/
public class graph
{
	int n; // number of vertices
	Linklist[] adjList; // to hod the adj List
	
	public graph(Linklist[] aL, int numVert) // constructor
	{
		adjList = aL;
		n = numVert;
	}
	
	//calculates number shortest path
	public int shorestP(int a, int z) 
	{
		int[] Spath = new int[n]; //to hold number of paths
		Spath[a-1] = 1;
		for(int i=0; i<n; i++)
		{
			Link curr = adjList[i].getFirst();
			while (curr != null)
			{
				if((Spath[curr.data-1] == 0) && (Spath[curr.data-1]!= 1))
				{
					Spath[curr.data-1] = 1 + Spath[i];
					curr = curr.next;	
				}
				else
				{curr = curr.next;}
			}
		}	
		return Spath[z-1]-1;
	}
	// calculates the number of Longest paths
	public int longestP(int a, int z)
	{
		int[] Lpath = new int[n]; //to hold number of paths
		Lpath[a-1] = 1;
		for(int i=0; i<n; i++)
		{
			Link curr = adjList[i].getFirst();
			while (curr != null)
			{
				Lpath[curr.data-1] = 1 + Lpath[i];
				curr = curr.next; 
			}
		}	
		return Lpath[z-1]-1;
	}
	
	//calculates the number of paths
	public int numbDP(int a, int z)
	{
		int[] numb_paths = new int[n]; //to hold number of paths
		numb_paths[a-1] = 1;
		for(int i=0; i<n; i++)
		{
			Link curr = adjList[i].getFirst();
			while (curr != null)
			{
				numb_paths[curr.data-1] = numb_paths[curr.data-1] + numb_paths[i];
				curr = curr.next; 
			}
		}	
		return numb_paths[z-1];
	}
	
	
}