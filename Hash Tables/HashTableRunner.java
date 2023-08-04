//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.Scanner;
import java.io.File;
import static java.lang.System.*;

public class HashTableRunner{
  public static void main ( String[] args ){
		try{
			Scanner s=new Scanner(new File("numbers.dat"));
			int times=s.nextInt();
			HashTable ht=new HashTable();
			for(int i=0;i<times;i++)
				ht.add(new Number(s.nextInt()));
			out.println(ht+"\n");
			s=new Scanner(new File("words.dat"));
			times=s.nextInt();
			ht=new HashTable();
			for(int i=0;i<times;i++)
				ht.add(new Word(s.next()));
			out.println(ht);
		}
		catch(Exception e)
		{
			System.out.println("Houston, we have a problem!");
		}
  }
}