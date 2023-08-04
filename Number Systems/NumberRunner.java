//(c) A+ Computer Science
//www.apluscompsci.com
 
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import static java.lang.System.*;

public class NumberRunner{
	public static void main ( String[] args ) throws IOException{
		Scanner s=new Scanner(new File("number.dat"));
		int times=s.nextInt();
		ArrayList<Number> numList=new ArrayList<>();
		s.nextLine();
		for(int i=0;i<times;i++){
			String[] line=s.nextLine().split(" ");
			numList.add(new Number(line[0],Integer.parseInt(line[1])));
		}
		Collections.sort(numList);
		for(Number n : numList)
			out.println(n);
	}
}