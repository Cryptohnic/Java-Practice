//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.Map;
import java.util.TreeMap;

public class Histogram {

    private Map<String, Integer> histogram;

    public Histogram(String line) { // add the counts to the histogram
        histogram = new TreeMap<String, Integer>();
        for (String s : line.split(" ")) {
            histogram.put(s, histogram.getOrDefault(s, 0) + 1); // adds or updates the value in the map

        }
    }

    public int getValue(String s) { // return the count
        return histogram.getOrDefault(s, 0);
    }

    public String toString() { // return the map
        String output = "char\t1---5----01---5\n"; // weird formatting that was asked for
        for (Map.Entry<String, Integer> entry : histogram.entrySet()) { // formatting
            String key = entry.getKey();
            int value = entry.getValue();
            String stars = "";
            for (int i = 0; i < value; i++) {
                stars += "*";
            }
            output += key + "\t" + stars + "\n";
        }
        return output + "\n\n";
    }
}
