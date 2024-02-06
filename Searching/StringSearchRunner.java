//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.out;

public class StringSearchRunner {

    public static void main(String args[]) {
        out.println(StringSearch.countLetters("computerscience", 't')); // counts the number of 't's in computerscience
        out.println(StringSearch.countWords("computerscience", "to")); // counts the number of times "to" occurs in computerscience
        out.println();
        out.println(StringSearch.countLetters("onetwoonetwofun", 'n'));
        out.println(StringSearch.countWords("onetwoonetwofun", "one"));
        out.println();
        out.println(StringSearch.countLetters("odogdogdogdogo", 'o'));
        out.println(StringSearch.countWords("niininininininininini", "ni"));
    }
}
