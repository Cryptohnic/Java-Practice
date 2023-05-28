//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

//ArrayList of ints
//or
//array of ints

import java.util.Arrays;

public class IntStack
{
	//pick your storage for the stack
	//you can use the an array or an ArrayList

	//option 1
	private int[] rayOfInts;
	private int numInts;

	public IntStack()
	{
		rayOfInts=new int[0];
		numInts=0;
	}

	public void push(int item)
	{
		rayOfInts=Arrays.copyOf(rayOfInts, ++numInts);
		rayOfInts[numInts-1]=item;
	}

	public int pop()
	{
		int num=rayOfInts[numInts-1];
		rayOfInts=Arrays.copyOf(rayOfInts,--numInts);
		return num;
	}

	public boolean isEmpty()
	{
		return numInts==0;
	}

	public int peek()
	{
		return rayOfInts[numInts-1];
	}

	public String toString()
	{
		return Arrays.toString(rayOfInts);
	}
}