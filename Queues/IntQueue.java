//(c) A+ Computer Science
//www.apluscompsci.com

//ArrayList of ints
//or
//array of ints

import java.util.Arrays;

public class IntQueue{
	//option 1
	private int[] rayOfInts;
	private int numInts;

	public IntQueue(){
		rayOfInts=new int[0]; // create a new empty array
		numInts=0; // set its length instance variable to zero
	}

	public void add(int item){
		rayOfInts=Arrays.copyOf(rayOfInts,++numInts); // create a copy that is one longer
		rayOfInts[numInts-1]=item; // set the last vale in the list to item
	}

	public int remove(){
		int val=rayOfInts[0]; // store the first value
		rayOfInts=Arrays.copyOfRange(rayOfInts,1,numInts--); // delete it
		return val;
	}

	public boolean isEmpty(){
		return numInts==0;
	}

	public int peek(){
		return rayOfInts[0]; // FIFO
	}

	public String toString(){
		return Arrays.toString(rayOfInts);
	}
}