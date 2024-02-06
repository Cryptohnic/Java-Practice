//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorRemover {

    private ArrayList<String> list;
    private String toRemove;

    public IteratorRemover(String line, String rem) {
        list = new ArrayList<String>(Arrays.asList(line.split(" "))); // Put the inputted line of text into the ArrayList
        toRemove = rem;
    }

    // public void setTest(String line, String rem){
    // }
    public void remove() {
        Iterator<String> i = list.iterator(); // create an Iterator
        while (i.hasNext()) // while there is a value left in the List
        {
            if (i.next().equals(toRemove)) // if we are at the value to remove
            {
                i.remove();
            }
        }
    }

    public String toString() {  // returns the list
        return list.toString() + "\n\n";
    }
}
