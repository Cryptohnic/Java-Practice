//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Relatives
{
	private Map<String,Set<String>> map;

	public Relatives()
	{
		map=new TreeMap<>();
	}

	public void setPersonRelative(String line)
	{
		String[] personRelative = line.split(" ");
		if(personRelative.length==2){		
			if(map.get(personRelative[0])==null)
				map.put(personRelative[0],new TreeSet<>());
			map.get(personRelative[0]).add(personRelative[1]);
		}
	}


	public String getRelatives(String person)
	{
		return map.get(person).toString();
	}


	public String toString()
	{
		String output="";
		for(Map.Entry<String,Set<String>> entry : map.entrySet())
			output+=entry.getKey()+" is related to "+entry.getValue().toString().replaceAll("[^\\w\\s]","")+"\n";
		return output;
	}
}