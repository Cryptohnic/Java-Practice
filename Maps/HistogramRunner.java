//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.Scanner;
import java.io.File;
import java.io.IOException;;

public class HistogramRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner s=new Scanner(new File("histogram.dat"));
		String[] letters=new String[]{"a","h","1","6","Y","T","#"}; // check characters for certain testcases
		int i=0;
		while(s.hasNextLine()){ // loop through data file
			String line=s.nextLine();
			Histogram H=new Histogram(line);
			System.out.println(H);
			System.out.println(line);
			if(i==6){
				System.out.println(letters[6]+" count = "+H.getValue(letters[6]));
				break;
			}
			System.out.println(letters[i]+" count = "+H.getValue(letters[i]));
			System.out.println(letters[i+1]+" count = "+H.getValue(letters[i+1])+"\n");
			i+=2;
		}
	}
}