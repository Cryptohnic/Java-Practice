//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SyntaxChecker {

    private String exp;
    private Stack<Character> symbols;

    public SyntaxChecker() {
        this("");
    }

    public SyntaxChecker(String s) {
        symbols = new Stack<>();
        setExpression(s);
    }

    public void setExpression(String s) {
        exp = s;
    }

    public boolean checkExpression() {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put('>', '<');
        map.put(')', '(');
        for (char ch : exp.toCharArray()) {
            if (map.containsValue(ch)) // if we are at on open symbol
            {
                symbols.push(ch);
            } else if (map.containsKey(ch)) { // if we are at a close symbol
                if (symbols.size() == 0) {
                    return false; // if there is nothing to remove

                }
                if (symbols.pop() != map.get(ch)) // if the previous open character doesn't match the current closing character
                {
                    return false;
                }
            }
        }
        return symbols.size() == 0;
    }

    public String toString() {
        return checkExpression() ? exp + " is correct." : exp + " is incorrect.";
    }
}
