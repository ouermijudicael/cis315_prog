// Ouermi Timbwaoga Aime Judicael 
// course: cis 315
// Lab 2 hw6
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class dynProgSplit
{
	private String givenStr; // to hold the string that need to be split
	private Linklist[] ArrValue; // to hold the subsentence obtanianed fro spliting iterative
	private Linklist[] ArrValueMe; //meoize
	private boolean[] ArrBooleanMe; // to split()already calculated Meoize
	private boolean[] ArrBoolean; //iterattive
	private int n; // holds the length of the string
	private boolean result; // holds the result of the split in Meoize
	private Hashtable<Integer, String> dictionary = new Hashtable<Integer, String>();
	
	public dynProgSplit(String s, Hashtable h) // constructor
	{
		givenStr = new String(s); // create a string object that holds the givene string
		dictionary = h;
		n = givenStr.length();
		ArrValue = new Linklist[n];
		ArrValueMe = new Linklist[n];
		ArrBoolean = new boolean[n];
		ArrBooleanMe = new boolean[n];
		for(int k=0; k<n; k++)
		{
		ArrValue[k] = new Linklist();
		ArrValueMe[k] = new Linklist();
		}
	}
	
	/**
	* This function takes a string and splits it into words 
	* using a dictionnary available
	*/
	public boolean SplitMemo(int i)throws IOException
	{
		if(i == n)
		{result = true;}
		
		else if(ArrBooleanMe[i] == true)
		{result = true;}
		
		else
		{
			for(int j=i+1; j<n; j++)
			{
				if(Dict(i,j)== true)
				{
					boolean y = SplitMemo(j+1);
					if(y != false)
					{
						ArrBooleanMe[i]= true;
						ArrValueMe[i].insertList(j);
						result = ArrBooleanMe[i];
					}
				}
			}
		}
		return result;
	}
	
	/**
	* Split function buttom up
	*/
	public boolean SplitBottoomUp()throws IOException
	{
		int k = 0;
		boolean result_bott= false;
		ArrBoolean[0]= true;
		for(k=1; k<n; k++)
		{
			for(int j = 0; j<k; j++)
			{
				if(Dict(j+1,k)== true )
				{
					if(ArrBoolean[j]== true)
					{
						ArrBoolean[k]= true;
						ArrValue[j].insertList(k);
					}
				}
			}
		}
		result_bott =ArrBoolean[n-1];
		return result_bott;
	}
	// funtion to print result
	public void printSetence()
	{
		int startS = 0;
		while(startS<n)
		{
			int endS;
			if(startS == 0)
			{endS= ArrValue[startS].getFirst().data;}
			
			else
			{endS= ArrValue[startS-1].getFirst().data;}
			
			String sentence = givenStr.substring(startS, endS+1);
			startS = endS+1;
			System.out.print(sentence+" ");
		}
	}

	/**
	* This method creates a dictionary
	*/
	/**
	* This method creates a dictionary
	*/
	public boolean Dict(int i,int j)throws IOException
	{
		String str3 = givenStr.substring(i,j+1);
		return dictionary.contains(str3);
	}                               
}