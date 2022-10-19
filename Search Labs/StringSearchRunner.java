//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.out;

public class StringSearchRunner{
	public static void main(String args[]){
		out.println(StringSearch.countLetters("computerscience", "t"));
		out.println(StringSearch.countWords("computerscience", "to"));
		out.println();
		out.println(StringSearch.countLetters("onetwoonetwofun", "n"));
		out.println(StringSearch.countWords("onetwoonetwofun", "one"));
		out.println();
		out.println(StringSearch.countLetters("odogdogdogdogo", "o"));
		out.println(StringSearch.countWords("niininininininininini", "ni"));
	}
}