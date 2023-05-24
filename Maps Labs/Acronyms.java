//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class Acronyms
{
	private Map<String,String> acronymTable;

	public Acronyms()
	{
		acronymTable=new TreeMap<>();
	}

	public void putEntry(String entry)
	{
		String[] text=entry.split(" - ");
		acronymTable.put(text[0],text[1]);
	}

	public String convert(String sent)
	{
		Scanner chop = new Scanner(sent);
		String output="";
		while(chop.hasNext()){
			String word=chop.next();
			String noPunct=word.replaceAll("\\p{Punct}","");
			if(acronymTable.get(noPunct)!=null){
				if(word==noPunct)
					output+=acronymTable.get(word)+" ";
				else
					output+=acronymTable.get(noPunct)+". ";
					
			}
			else
				output+=word+" ";
		}
		chop.close();
		return output;
	}

	public String toString()
	{
		return "==== MAP CONTENTS ====\n\n"+acronymTable.toString()+"\n\n";
	}
}