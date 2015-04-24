// Ouermi Timbwaoga Aime Judicael 
// course: cis 315
// Lab 2 hw6
import java.util.Scanner;
import java.util.*;
import java.io.*;
/**
* This is just to test the dynProgSplit 
*/
public class dynProgSplit_test
{
	public static void main(String args[])throws IOException
	{
		Hashtable dict = Dictionary();	
		
		// open the file 
		File file = new File("inSampleSmall.txt");
		Scanner inputFile = new Scanner(file);
		
		int num_string = Integer.parseInt(inputFile.nextLine());
		 
		for(int t=0; t< num_string; t++)
		{
			String str0 = inputFile.nextLine();
			System.out.println("phrase number: "+(t+1));
			System.out.println(str0+"\n");
			
			dynProgSplit object = new dynProgSplit(str0,dict);
			System.out.println("Iterative attempt:");
			if(object.SplitBottoomUp() == true)
			{
				System.out.println("YES, can be split");
				object.printSetence();
				System.out.println("\n");
			}
			else
			{
				System.out.println("NO, can't be split");
				System.out.println("\n");
			} 
			
			System.out.println("Memoize attempt:");
			if(object.SplitMemo(0) == true)
			{
				System.out.println("YES, can be split");
				object.printSetence();
				System.out.println("\n");
			}
			else
			{
				System.out.println("NO, can't be split");
				System.out.println("\n");
			}
		}
		// close the file
		inputFile.close();
	}
	// this buids the dictionary	
	private static Hashtable Dictionary()throws IOException
	{
		Hashtable<Integer, String> h = new Hashtable<Integer, String>();
		// open the file 
		 File file = new File("diction10k.txt");
		 Scanner inputFile = new Scanner(file);
		 int k =1;
		 while(inputFile.hasNext())
		 {
		 	String str2 = inputFile.nextLine();
			h.put(k,str2);
			k++;
		 }
		 // close the file
		 inputFile.close();
		 
		return h;
	}
}