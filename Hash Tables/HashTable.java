//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.LinkedList;

public class HashTable
{
	private LinkedList[] table;

	public HashTable( )
	{
		table=new LinkedList[10];
		for(int i=0;i<table.length;i++)
			table[i]=new LinkedList();
	}

	public void add(Object obj)
	{
		int i = obj.hashCode()%table.length;
		if(!table[i].contains(obj))
			table[i].add(obj);
	}

	public String toString()
	{
		String output="HASHTABLE\n";
		int i=0;
		for(LinkedList l : table)
			output+="bucket "+i+++" "+l.toString().replaceAll("[^\\d\\s\\w]","")+"\n";
		return output;
	}
}