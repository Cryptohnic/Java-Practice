//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import static java.lang.System.*;
import java.util.Collections;

public class WordTwoRunner{
	public static void main(String args[])throws IOException{
		Scanner file=new Scanner(new File("wordstwo.dat"));
		List<WordTwo> list=new ArrayList<>();
		int size=file.nextInt();
		for(int i=0;i<size;i++){
			String s=file.next();
			list.add(new WordTwo(s));
		}
		Collections.sort(list);
		out.println(list);
	}
}