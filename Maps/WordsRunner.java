//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.out;

public class WordsRunner{
	public static void main(String args[]){
		Words w=new Words(); // test the class we made
		out.println(w.getNumber("one"));
		out.println(w.getNumber("five"));
		out.println(w.getNumber("eight"));
		out.println(w.getNumber("nine"));
	}
}