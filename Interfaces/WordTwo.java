//(c) A+ Computer Science
//www.apluscompsci.com

public class WordTwo implements Comparable<WordTwo>{
	private String word;

	public WordTwo(String s){
		word=s;
	}

	private int numVowels(){
		String vowels = "AEIOUaeiou";
		int vowelCount=0;
		for(String ch : word.split(""))
			if(vowels.contains(ch))
				vowelCount++;
		return vowelCount;
	}

	public int compareTo(WordTwo rhs){
		int numVowels=numVowels();
		int rhsVowels=rhs.numVowels();
		if(numVowels<rhsVowels)
			return -1;
		else if(numVowels>rhsVowels)
			return 1;
		return word.compareTo(rhs.word);
	}

	public String toString(){
		return word;
	}
}