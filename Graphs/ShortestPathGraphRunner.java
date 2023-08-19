//(c) A+ Computer Science
//www.apluscompsci.com

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class ShortestPathGraphRunner{
	public static void main(String[] args)throws IOException{
		Scanner file=new Scanner(new File("graph1.dat"));
		int times=file.nextInt();
		file.nextLine();
		for(int i=0;i<times;i++){
			ShortestPathGraph graph=new ShortestPathGraph(file.nextLine());
			String toCheck=file.nextLine();
			String firstVertex=toCheck.substring(0,1);
			String secondVertex=toCheck.substring(1);
			graph.check(firstVertex,secondVertex,"",1);
			out.println(firstVertex+" connects to "+secondVertex+" == "+graph);
		}
	}
}