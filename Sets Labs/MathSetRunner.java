//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.out;

public class MathSetRunner{
	public static void main(String args[])throws IOException{
		Scanner s=new Scanner(new File("mathsetdata.dat"));
		while(s.hasNext()){
			String nums=s.nextLine();
			String nums1=s.nextLine();
			MathSet m=new MathSet(nums,nums1); // create a MathSet for each of the rows
			out.println(m);
		}
	}
}
