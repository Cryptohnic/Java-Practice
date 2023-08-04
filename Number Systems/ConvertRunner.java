//(c) A+ Computer Science
//www.apluscompsci.com

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class ConvertRunner{
	public static void main( String args[] ) throws IOException{
		Scanner file = new Scanner(new File("convert.dat"));
		while(file.hasNextLine()){
			String sentence=file.nextLine();
			Convert c=new Convert(sentence);
			out.println(c);
		}
	}
}