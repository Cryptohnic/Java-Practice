//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class BiDirectionalGraph{
	private Map<String, Set<String>> map;
	private boolean found;

	public BiDirectionalGraph(String line){
		map=new HashMap<>();
		found=false;
		Scanner s=new Scanner(line);
		while(s.hasNext()){
			String firstVal=s.next();
			String secondVal=s.next();
			if(map.get(firstVal)==null)
				map.put(firstVal,new HashSet<String>());
			if(map.get(secondVal)==null)
				map.put(secondVal,new HashSet<String>());
			map.get(firstVal).add(secondVal);
			map.get(secondVal).add(firstVal);
		}
		s.close();
	}	

	// public boolean contains(String name){
	// 	return map.get(name)!=null;
	// }

	public void check(String first, String second, Set<String> placesUsed){
		if(map.get(first).contains(second)){
			found=true;
			return;
		}
		for(String name : map.get(first))
			if(!placesUsed.contains(name)){
				placesUsed.add(name);
				check(name,second,placesUsed);
			}
	}

	public String toString(){
		return found ? "YAH" : "NAH";
	}
}