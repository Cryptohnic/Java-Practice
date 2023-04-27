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
		Set<String> ans=new TreeSet<>();
		for(String s:input.split(" "))
			if(!set.add(s))
				ans.add(s);
		return ans;
	}
}