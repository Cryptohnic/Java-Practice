//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.out;

public class DupRunner {

    public static void main(String args[]) {
        String words = "a b c d e f g h a b c d e f g h i j k";
        out.println("Original List : " + words);
        out.println("Uniques : " + UniquesDupes.getUniques(words)); // return the set
        out.println("Dupes : " + UniquesDupes.getDupes(words) + "\n\n"); // return the duplicates set
        words = "one two three one two three six seven one two";
        out.println("Original List : " + words);
        out.println("Uniques : " + UniquesDupes.getUniques(words));
        out.println("Dupes : " + UniquesDupes.getDupes(words) + "\n\n");
        words = "1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6";
        out.println("Original List : " + words);
        out.println("Uniques : " + UniquesDupes.getUniques(words));
        out.println("Dupes : " + UniquesDupes.getDupes(words) + "\n\n");
    }
}
