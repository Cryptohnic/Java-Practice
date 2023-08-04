//(c) A+ Computer Science
//www.apluscompsci.com


//ArrayList of ints
//or
//array of ints

import java.util.Arrays;

public class IntStack{
	//pick your storage for the stack
	//you can use the an array or an ArrayList

	//option 1
	private int[] rayOfInts;
	private int numInts;

	public IntStack(){
		rayOfInts=new int[0]; // create a zero length array
		numInts=0; // set the length instance variable to zero
	}

	public void push(int item){
		rayOfInts=Arrays.copyOf(rayOfInts, ++numInts); // increase the length by one
		rayOfInts[numInts-1]=item; // set the last value to item
	}

	public int pop(){
		int num=rayOfInts[numInts-1]; // store the value
		rayOfInts=Arrays.copyOf(rayOfInts,--numInts); // remove it
		return num;
	}

	public boolean isEmpty(){
		return numInts==0;
	}

	public int peek(){
		return rayOfInts[numInts-1];
	}

	public String toString(){
		return Arrays.toString(rayOfInts);
	}
}