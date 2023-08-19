//(c) A+ Computer Science
//www.apluscompsci.com

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class GraphRunner{
	public static void main(String[] args)throws IOException{
		Scanner file=new Scanner(new File("graph.dat"));
		int times=file.nextInt();
		file.nextLine();
		for(int i=0;i<times;i++){
			Graph graph=new Graph(file.nextLine());
			String toCheck=file.nextLine();
			String firstVertex=toCheck.substring(0,1);
			String secondVertex=toCheck.substring(1);
			graph.check(firstVertex,secondVertex,"");
			out.println(firstVertex+" connects to "+secondVertex+" == "+graph);
		}
	}
}