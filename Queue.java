/**********************************************************
* name: Ouermi Timbwaoga Aime Judicael (TAJO)
* course: CIS 315
* Prof: 
* Lab 1
***********************************************************
* This a Queue class  that can be used for implementation of a 
* Queue like data structure
*/

import java.util.*;

public class Queue
{	
	private Node first; //refer to first CharNode
	private Node last; //refer to the last charNode
	// this methode insert an elemment in the Queue
	
	public Queue() // constructor
	{
		first = null; 
		last = null;   // no element in the Queue yet
	}
	
	// This methode insert element in the Queue
	public void enQueue(Node c)
	{
		Node newNode =c; // creates a charNode object
		if (isEmpty())		// oif the queue is empty
		{
			first = newNode;		// first---> newCharNode
		}
		
		else
		{
			last.next =newNode;  // od last ---->newCharNode
		}
		last = newNode;		// last ---> newCharNode
	}
	
	// this methode removes an element from the queue
	public Node deQueue()
	{
		Node temp = first; 			// this assume that the queue is not empty
		if(first.next == null)
		{
			last = null;  // last---> null
		}	
			first = first.next; // first---> first.next
			return temp;
	}
	
	// this methode checks if the queue is empty
	public boolean isEmpty()
	{
		return first == null;
	}
}