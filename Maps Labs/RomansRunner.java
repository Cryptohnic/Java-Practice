//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.out;

public class RomansRunner{
	public static void main(String args[]){
		Romans w = new Romans();
		out.println(w.getNumber("V"));
		out.println(w.getNumber("D"));
		out.println(w.getNumber("M")+"\n");
		out.println(w.getTotal("V I I"));
		out.println(w.getTotal("X X"));
		out.println(w.getTotal("C D M"));
		out.println(w.getTotal("L"));
	}
}