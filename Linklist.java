// Ouermi Timbwaoga Aime Judicael 
// course: cis 315
// Lab 2 hw6
public class Linklist
{
	private Link next; // pointer to next Link
	private Link first; 
	public Linklist() // constructor
	{
		next = null;
		
	}
	
	public boolean isEmpty()
	{
		return (first == null);
	}
	
	public void insertList(int data)
	{
		Link newLink = new Link(data); // creates a new link
		newLink.next = first;
		first = newLink;
	}
	
	public int deleteList()
	{
		Link temp = first;
		first = first.next;
		return temp.data;
	}
	
	public Link getFirst()
	{ return first; }
	public void displayList()
	{
		Link current = first; 
		while(current != null)
		{
			current.displayLink();
			current = current.next;
		}
	} 
}
