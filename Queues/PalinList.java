//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalinList {

    private Queue<String> queue;
    private Stack<String> stack;

    public PalinList() {
        this("");
    }

    public PalinList(String list) {
        queue = new LinkedList<>();
        stack = new Stack<>();
        setList(list);
    }

    public void setList(String list) {
        for (String s : list.split(" ")) { // add everything to both the stack and the queue
            stack.push(s);
            queue.add(s);
        }
    }

    public boolean isPalin() {
        int times = stack.size() / 2;
        for (int i = 0; i < times; i++) {
            if (!stack.pop().equals(queue.remove())) // if it isn't the same in the front and the back
            {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return stack.toString() + (isPalin() ? " is a palinlist." : " is not a palinlist.") + "\n";
    }
}
