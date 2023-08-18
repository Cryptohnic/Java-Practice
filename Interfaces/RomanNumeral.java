//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.*; 

public class RomanNumeral implements Comparable<RomanNumeral>{
	private Integer number;
	private String roman;

	private final static int[] NUMBERS={1000,900,500,400,100,90,50,40,10,9,5,4,1};

	private final static String[] LETTERS={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

	public RomanNumeral(String str){
		setRoman(str);
	}

	public RomanNumeral(Integer orig){
		setNumber(orig);
	}

	//write a set number method
	public void setNumber(int num){
		number=num;
		roman="";
		setRoman();
	}
	
	public void setNumber(){
		int romanSpot=0;
		for(int i=0;i<LETTERS.length;i++)
			if(romanSpot+LETTERS[i].length()<=roman.length() && roman.substring(romanSpot,romanSpot+LETTERS[i].length()).equals(LETTERS[i])){ // if we have enough room left in the roman for the current spot in the array and our current position matches in the roman and the array
				number+=NUMBERS[i]; 
				romanSpot+=LETTERS[i--].length(); // i-- in case of duplicate romans ex: XX
			}
	}
	
	//write a set roman method
	public void setRoman(String rom){
		roman=rom;
		number=0;
		setNumber();
	}
	
	public void setRoman(){
		int tempNumber=number;
		for(int i=0;i<NUMBERS.length;i++)
			if(NUMBERS[i]<=tempNumber){ // if we are at a number that can be turned into a roman
				roman+=LETTERS[i];
				tempNumber-=NUMBERS[i--]; // i-- in case we can still use that letter
			}
	}

	//write get methods for number and roman
	public int getNumber(){
		return number;
	}

	public String getRoman(){
		return roman;
	}
	

	public int compareTo(RomanNumeral r){
		return number-r.getNumber();
	}

	//write  toString() method
	public String toString(){
		return roman;
	}
}