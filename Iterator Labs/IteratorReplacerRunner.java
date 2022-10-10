//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import static java.lang.System.*;

public class IteratorReplacerRunner{
	public static void main(String[] args){
		String sentence="a b c a b c";
		String remove="a";
		String replace="+";
		IteratorReplacer i=new IteratorReplacer(sentence,remove,replace);
		out.println(i);
		i.replace();
		out.println(i);
	}
}