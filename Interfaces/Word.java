//(c) A+ Computer Science
//www.apluscompsci.com

public class Word implements Comparable<Word>{
	
	private String word;

	public Word(String s){
		word=s;
	}

	public int compareTo(Word rhs){		
		int wordLength=word.length();
		int rhsLength=rhs.word.length();
		if(wordLength<rhsLength)
			return -1;
		else if(wordLength>rhsLength)
			return 1;
		else
			return word.compareTo(rhs.word);
	}

	public String toString(){
		return word;
	}
}