//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class IteratorReplacer{
	
	private ArrayList<String> list;
	private String toRemove, replaceWith;

	public IteratorReplacer(String line,String rem,String rep){
		list=new ArrayList<String>(Arrays.asList(line.split(" ")));
		toRemove=rem;
		replaceWith=rep;
	}

	// public void setEmAll(String line,String rem,String rep){
	// }

	public void replace(){
		ListIterator<String> i=list.listIterator();
		while(i.hasNext())
			if(i.next().equals(toRemove))
				i.set(replaceWith);
	}

	public String toString(){
		return list.toString()+"\n\n";
	}
}