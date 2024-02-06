//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.*;

public class PalinListRunner {

    public static void main(String[] args) {
        PalinList pl = new PalinList("one two three two one");
        out.println(pl);
        pl = new PalinList("1 2 3 4 5 one two three four five");
        out.println(pl);
        pl = new PalinList("a b c d e f g x y z g f h");
        out.println(pl);
        pl = new PalinList("racecar is racecar");
        out.println(pl);
        pl = new PalinList("1 2 3 a b c c b a 3 2 1");
        out.println(pl);
        pl = new PalinList("chicken is a chicken");
        out.println(pl);
    }
}
