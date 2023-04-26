//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.out;

public class IteratorReplacerRunner{
	public static void main(String[] args){
		String sentence="a b c a b c";
		String remove="a";
		String replace="+";
		IteratorReplacer i=new IteratorReplacer(sentence,remove,replace);
		i.replace();
		out.println(i);
		sentence="a b c d e f g h i j x x x x";
		remove="x";
		replace="7";
		i=new IteratorReplacer(sentence,remove,replace);
		i.replace();
		out.println(i);
		sentence="1 2 3 4 5 6 a b c a b c";
		remove="b";
		replace="#";
		i=new IteratorReplacer(sentence,remove,replace);
		i.replace();
		out.println(i);
	}
}