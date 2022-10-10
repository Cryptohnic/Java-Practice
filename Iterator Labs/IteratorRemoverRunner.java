//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import static java.lang.System.*;

public class IteratorRemoverRunner{
	public static void main(String[] args){
		String words="a b c a b c a";
		String remove="a";
		IteratorRemover i=new IteratorRemover(words,remove);
		out.println(i);
		i.remove();
		out.println(i);	
	}
}