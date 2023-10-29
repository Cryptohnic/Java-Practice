//(c) A+ Computer Science  -  www.apluscompsci.com

//define class Palin
public class Palin{
	//instance variable - String
	String s;
	//constructors
	public Palin(){
		s="";
	}

	public Palin(String word){
		s=word;
	}
	//getLength method - returns an int
	public int getLength(){
		return s.length();
	}

	//getWord method - returns a String
	public String getWord(){
		return s;
	}

	//isPalin method - returns a boolean
	public boolean isPalin(){
		String reverse="";
		for(char c : s.toCharArray())
			reverse=c+reverse;
		return s.equals(reverse); // checks if string is the same forwards and backwards
	}

	//toString method - returns a String
	public String toString(){
		return s;
	}
}