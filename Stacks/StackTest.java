//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Stack;
import static java.lang.System.*;

public class StackTest
{
	private Stack<String> stack;

	public StackTest(){
		this("");
	}

	public StackTest(String line)
	{
		setStack(line);
	}
	
	public void setStack(String line)
	{
		stack=new Stack<>();
		for(String s : line.split(" ")) // iterate through and add everything to the stack
			stack.push(s);
	}

	public void popEmAll()
	{	
		out.println("popping all items from the stack");
		while(!stack.isEmpty()) // while there  is stuff in the stack
			out.print(stack.pop()+" "); // pop it
		out.println("\n\n");
	}

	public String toString(){
		return stack.toString()+"\n";
	}
}