//(c) A+ Computer Science
//www.apluscompsci.com

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class OddRunner{
	public static void main(String args[])throws IOException{
		Scanner s=new Scanner(new File("oddevent.dat"));
		while(s.hasNext()){
			String nums=s.nextLine();
			OddEvenSets o=new OddEvenSets(nums);
			out.println(o);
		}
	}
}