//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SpanishToEnglish {

    private Map<String, String> pairs;

    public SpanishToEnglish() {
        pairs = new TreeMap<>();
    }

    public void putEntry(String entry) {
        String[] text = entry.split(" ");
        pairs.put(text[0], text[1]);
    }

    public String translate(String sent) {
        Scanner chop = new Scanner(sent);
        String output = "";
        while (chop.hasNext()) {
            String word = chop.next();
            String noPunct = word.replaceAll("\\p{Punct}", "");
            if (pairs.get(noPunct) != null) { // check if we have a translation available
                if (word == noPunct) {
                    output += pairs.get(word) + " "; 
                }else {
                    output += pairs.get(noPunct) + ". ";
                }
            } else {
                output += word + " ";
            }
        }
        chop.close();
        return output;
    }

    public String toString() {
        return "====\tMAP CONTENTS\t====\n\n" + pairs.toString() + "\n\n";
    }
}
