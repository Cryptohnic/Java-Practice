//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Arrays;

public class UniquesDupes{
	public static Set<String> getUniques(String input){
		return new TreeSet<String>(Arrays.asList(input.split(" ")));
	}

	public static Set<String> getDupes(String input){
		Set<String> set=new HashSet<>();
		Set<String> dupes=new TreeSet<>();
		for(String s:input.split(" "))
			if(!set.add(s)) // adds everything to the set
				dupes.add(s); // if it is already in the set, add it to dupes
		return dupes;
	}
}