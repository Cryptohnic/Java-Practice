//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.*;

public class StackTestRunner {

    public static void main(String[] args) {
        StackTest s = new StackTest("a b c d e f g h i");
        out.println(s);
        s.popEmAll();
        s = new StackTest("1 2 3 4 5 6 7 8 9 10");
        out.println(s);
        s.popEmAll();
        s = new StackTest("# $ % ^ * ( ) ) _");
        out.println(s);
        s.popEmAll();
    }
}
