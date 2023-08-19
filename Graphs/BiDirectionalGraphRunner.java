//(c) A+ Computer Science
//www.apluscompsci.com

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashSet;
import static java.lang.System.*;

public class BiDirectionalGraphRunner{
	public static void main(String[] args)throws IOException{
		Scanner s=new Scanner(new File("bidgraph.dat"));
		int times=s.nextInt();
		s.nextLine();
		for(int i=0;i<times;i++){
			BiDirectionalGraph bdg=new BiDirectionalGraph(s.nextLine());
			String[] toCheck=s.nextLine().split(" ");
			String firstValue=toCheck[0];
			String secondValue=toCheck[1];
			bdg.check(firstValue,secondValue,new HashSet<String>());
			out.println(firstValue+" CONNECTS TO "+secondValue+" == "+bdg);
		}
	}
}