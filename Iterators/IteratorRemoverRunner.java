//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.out;

public class IteratorRemoverRunner{
	public static void main(String[] args){
		String words="a b c a b c a"; 
		String remove="a";
		IteratorRemover i=new IteratorRemover(words,remove); // creates an iterator to remove the given values
		out.println(i);
		i.remove();
		out.println(i);
		words="a b c d e f g h i j x x x x";
		remove="x";
		i=new IteratorRemover(words,remove);
		out.println(i);
		i.remove();
		out.println(i);	
		words="1 2 3 4 5 6 a b c a b c";
		remove="b";
		i=new IteratorRemover(words,remove);
		out.println(i);
		i.remove();
		out.println(i);
	}
}