//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

public class OddEvenSets{
	private Set<Integer> odds;
	private Set<Integer> evens;

	public OddEvenSets(){
		odds=new TreeSet<>();
		evens=new TreeSet<>();
	}

	public OddEvenSets(String line){
		this();
		Scanner s=new Scanner(line);
		while(s.hasNext()){
			int num=s.nextInt();
			if(num%2!=0)
				odds.add(num);
			else
				evens.add(num);
		}
	}

	public String toString(){
		return "ODDS : "+odds+"\nEVENS : "+evens+"\n\n";
	}
}