//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.Scanner;
import static java.lang.System.*;

public class SkeletonRunner{
	public static void main(String args[]){
		Scanner keyboard = new Scanner(in);
		for(int i=0;i<3;i++){
			//ask for name and size
			out.print("Enter 1st monster's name : ");
			String name=keyboard.next();
			out.print("Enter 1st monster's size : ");
			int size=keyboard.nextInt();
			//instantiate monster one
			Monsterable one=new Skeleton(name,size);

			//ask for name and size
			out.print("Enter 2nd monster's name : ");
			name=keyboard.next();
			out.print("Enter 2nd monster's size : ");
			size=keyboard.nextInt();
			
			//instantiate monster two
			Monsterable two=new Skeleton(name,size);

			out.println("\nMonster 1 - "+one);
			out.println("Monster 2 - "+two);

			out.println("\n"+(one.isSmaller(two) ? "Monster one is smaller than Monster two" : "Monster one is bigger than Monster two"));
			out.println(one.namesTheSame(two) ? "Monster one has the same name as Monster two\n\n" : "Monster one does not have the same name as Monster two\n\n");
		}
	}
}