//(c) A+ Computer Science
//www.apluscompsci.com

import java.io.File; 
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class WordRunner{
	public static void main(String args[]) throws IOException{
		Scanner file=new Scanner(new File("words.dat"));
		int size=file.nextInt();
		file.nextLine();
		Word[] wordArr=new Word[size];
		for(int i=0;i<size;i++){
			wordArr[i]=new Word(file.next());
			file.nextLine();
		}
		Arrays.sort(wordArr);
		out.print(Arrays.toString(wordArr));
	}
}