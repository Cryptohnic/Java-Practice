//(c) A+ Computer Science
//www.apluscompsci.com

public class StringSearch {

    public static int countWords(String sent, String word) {
        int count = 0;
        for (int i = 0; i < sent.length() - word.length() + 1; i++) // counts the number of appearances of the word
        {
            if (sent.substring(i, i + word.length()).equals(word)) {
                count++;
            }
        }
        return count;
    }

    public static int countLetters(String sent, char letter) {
        int count = 0;
        for (char c : sent.toCharArray()) {
            if (c == letter) // is the character equals the letter input
            {
                count++;
            }
        }
        return count;
    }
}
