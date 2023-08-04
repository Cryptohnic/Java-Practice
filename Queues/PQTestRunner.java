//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.*;

public class PQTestRunner{
	public static void main ( String[] args ){
		PQTester pqt=new PQTester("one two three four five six seven");
		out.println(pqt);		
		pqt=new PQTester("1 2 3 4 5 one two three four five");
		out.println(pqt);
		pqt=new PQTester("a p h j e f m c i d k l g n o b");
		out.println(pqt);	
	}
}