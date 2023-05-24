//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class AcroRunner
{
	public static void main( String args[] ) throws IOException
	{
		Acronyms acronyms=new Acronyms();
		Scanner s=new Scanner(new File("acro.dat"));
		int count=s.nextInt();
		s.nextLine();
		for(int i=0;i<count;i++)
			acronyms.putEntry(s.nextLine());
		out.println(acronyms);
		out.println("====\tREAD CONTENTS\t====\n");
		while(s.hasNextLine())
			out.println(acronyms.convert(s.nextLine()));
	}
}