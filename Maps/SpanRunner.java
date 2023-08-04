//(c) A+ Computer Science
//www.apluscompsci.com

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class SpanRunner{
	public static void main( String args[] ) throws IOException{
		SpanishToEnglish spanishToEnglish=new SpanishToEnglish();
		Scanner s=new Scanner(new File("spantoeng.dat"));
		int count=s.nextInt();
		s.nextLine();
		for(int i=0;i<count;i++)
			spanishToEnglish.putEntry(s.nextLine());
		out.println(spanishToEnglish);
		while(s.hasNextLine())
			out.println(spanishToEnglish.translate(s.nextLine()));
	}
}