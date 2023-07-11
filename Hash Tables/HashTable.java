//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.LinkedList;

public class HashTable
{
	private LinkedList[] table;

	public HashTable()
	{
		this(10);
	}

	public HashTable(int size)
	{
		table=new LinkedList[size]; // create your table
		for(int i=0;i<table.length;i++)
			table[i]=new LinkedList(); // create a new LinkedList at each spot in the table
	}

	public void add(Object obj)
	{
		int i = obj.hashCode()%table.length;
		if(!table[i].contains(obj)) // if we don't already have this object stored
			table[i].add(obj);
	}

	public String toString()
	{
		String output="HASHTABLE\n";
		int i=0;
		for(LinkedList l : table)
			output+="bucket "+i+++" "+l.toString().replaceAll("[^\\w\\s\\d]","")+"\n"; // add the list as a string but remove any list formatting use regex
		return output;
	}
}