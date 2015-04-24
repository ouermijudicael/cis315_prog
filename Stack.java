/**********************************************************
* name: Ouermi Timbwaoga Aime Judicael (TAJO)
* course: CIS 313
* Prof: Andre
* Lab 1
***********************************************************
*Stack class that can be used to implement a Queue data structure
*/
import java.util.*;

public class Stack
{
	private Node first; //refer to first CharNode
	private int count; // keep track of the size of the stack
	
	//constructor
	public void Stack()  // constructor
	{
		first = null;  // not item in the stack yet
	}
	// methode that insert element in the stack
	public void push(int n)
	{
		Node newnode = new Node(n);
		newnode.next = first;  // newLink ---> old first
		first = newnode;   // first ---> newLink
		count++; // keep track of the size of the stack
	}
	
	// methode return the first element of the stack
	public int pop()
	{
		int temp = first.data; // save the data of the node
		first = first.next;	// delete it: first ---> old next
		count--; // keep track of the size of the stack
		return temp;  // returns the deleted CharNode
	}
	
	// check if the sctak is empty
	public boolean isEmpty()
	{
		return (first==null);
	}
	
	public int getLength()
	{ return count;} // gets us the length of the stack
	
}