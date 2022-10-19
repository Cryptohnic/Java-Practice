//(c) A+ Computer Science  -  www.apluscompsci.com

import static java.lang.System.out;

public class PalinRunner{
	public static void main(String args[]){
		String[] words="dog dad racecar goofy madam alligator benjamin".split(" ");
		for(String s:words){
			Palin one = new Palin(s);
			out.print(one.isPalin()?one+" is a palindrome.\n":one+" is not a palindrome.\n");
		}
	}
}