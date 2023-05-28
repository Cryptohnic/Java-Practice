//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

//ArrayList of ints
//or
//array of ints

import java.util.Arrays;

public class IntQueue
{
	//option 1
	private int[] rayOfInts;
	private int numInts;

	public IntQueue()
	{
		rayOfInts=new int[0];
		numInts=0;
	}

	public void add(int item)
	{
		rayOfInts=Arrays.copyOf(rayOfInts,++numInts);
		rayOfInts[numInts-1]=item;
	}

	public int remove()
	{
		int val=rayOfInts[0];
		rayOfInts=Arrays.copyOfRange(rayOfInts,1,numInts--);
		return val;
	}

	public boolean isEmpty()
	{
		return numInts==0;
	}

	public int peek()
	{
		return rayOfInts[0];
	}

	public String toString()
	{
		return Arrays.toString(rayOfInts);
	}
}