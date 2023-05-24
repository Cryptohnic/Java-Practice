//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class PartList
{
	private TreeMap<Part, Integer> partsMap;
	
	public PartList()
	{
		partsMap=new TreeMap<>();
	}
	
	public PartList(String fileName)
	{
		this();
		try
		{
			Scanner file = new Scanner(new File(fileName));
			//add code here to read from the file 
			//and add Parts to the map
			while(file.hasNextLine()){
				String line=file.nextLine();
				Part p=new Part(line);
				partsMap.put(p,partsMap.getOrDefault(p,0)+1);
			}



		}
		catch( IOException e )  //Most specific exceptions must be listed 1st
		{
			out.println(e);
		}
		catch( RuntimeException e )
		{
			out.println(e);
		}
		catch( Exception e )
		{
			out.println(e);
		}
		finally
		{
			//no code needed here
		}
	}
	
	public String toString()
	{
		String output="";
		for(Map.Entry<Part,Integer> entry : partsMap.entrySet())
			output+=entry.getKey()+" - "+entry.getValue()+"\n";
		return output;
	}
}