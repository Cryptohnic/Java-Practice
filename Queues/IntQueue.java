//(c) A+ Computer Science
//www.apluscompsci.com

//ArrayList of ints -> LinkedList is better O()
//or
//array of ints

import java.util.List;
import java.util.LinkedList;

public class IntQueue{
	//option 2
	private List<Integer> rayOfInts;
	private int numInts;

	public IntQueue(){
		rayOfInts=new LinkedList(); // create a new empty list
		numInts=0; // set its length instance variable to zero
	}

	public void add(int item){
		rayOfInts.add(item);
		numInts++;
	}

	public int remove(){
		numInts--;
		return rayOfInts.remove(0);
	}

	public boolean isEmpty(){
		return numInts==0;
	}

	public int peek(){
		return rayOfInts.get(0); // FIFO
	}

	public String toString(){
		return rayOfInts.toString();
	}
}