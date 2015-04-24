
public class Graphd1_to_n
{
	private Stack stk1 = new Stack();
	private Stack stk2 = new Stack();
	private int[][] adjMatrix;
	
	//contructor
	public Graphd1_to_n(int[][] adjM)
	{adjMatrix = adjM;}
	
	// this calculates the longest path from 1 to n
	public int longestPath()
	{
		return 1;
	}
	
	// this caculates the shortest path from 1 to n
/*	public int shortestPath(Node u, Node dest)
	{
		int dist_path = 0;
		Queue Q = new Queue();
		u.visited = true;
		Q.enQueue(u); // puts the first Node in the Queue
		while(Q.isEmpty() != false)
		{
			Node newNode = Q.deQueue();
			while(stkArray[newNode.data].isEmpty() != false)
			{
				Node n = stkArray[newNode.data].pop();
				if(n.data == dest.data)
				{
					n.dist = newNode.dist +1;
					dist_path = n.dist;
					break;
				}
				else
				{
					n.dist = newNode.dist +1;
					n.visited = true;
				}
			}
			
		}
		
		return dist_path;
	}
*/	
	// this calculates the distinc paths from 1 to n
	public int numbDisctPath(int u, int dest)
	{
		int paths_numb = 0;
		// push node in the stack
		stk1.push(u-1);
		if(u == dest-1)
		{
			int length = stk1.getLength(); // get
			stk2.push(length); // store path legnth in stk2
		}
		else
		{
			for(int i=0; i<adjMatrix.length; i++)
			{
				if(adjMatrix[u-1][i] == 1 )
				{
					adjMatrix[u-1][i] = 0; // set it to visited
					numbDisctPath(i, dest); // recursive call to number of distinc path
				}
			}
		}
		if(stk1.isEmpty() != true)
		{stk1.pop();} // remove the next element from stk1
		
		paths_numb = stk2.getLength();
		
		return paths_numb;
	}
}