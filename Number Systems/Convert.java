//(c) A+ Computer Science
//www.apluscompsci.com

public class Convert {

    private String sentence;
    private String binary;

    public Convert() {
        this("");
    }

    public Convert(String sentence) {
        this.sentence = sentence;
        binary = "";
    }

    public void convert() {
        for (char c : sentence.toCharArray()) { // loop through each character
            int letter = c; // store its ASCII
            String base2 = "";
            for (int i = 0; i < 8; i++) {
                base2 = letter % 2 + base2; // add the mod2 version in reverse order
                letter /= 2;
            }
            binary += base2 + " ";
        }
    }

    public String toString() {
        convert();
        return sentence + "\n" + binary + "\n\n";
    }
}
