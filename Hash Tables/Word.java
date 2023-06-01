//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Word
{
	private String theValue;
	
	//write a constructor method
	public Word(){
		this("");
	}
	
	public Word(String value){
		theValue=value;
	}	
	//write the getValue method
	public String getValue(){
		return theValue;
	}
	
	
	//write the equals method
	public boolean equals(Object obj){
		return theValue.equals(((Word)obj).theValue);
	}
	
	
	//write the hashCode method
	public int hashCode(){
		Set<String> vowelSet=new HashSet<>(Arrays.asList("a","e","i","o","u"));
		int vowels=0;
		for(String s : theValue.split(""))
			if(vowelSet.contains(s))
				vowels++;
		return (vowels*theValue.length())%10;
	}
	
	
	//write the toString method
	public String toString(){
		return theValue;
	}
}