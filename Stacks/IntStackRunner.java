//(c) A+ Computer Science
//www.apluscompsci.com

//ArrayList of ints
//or
//array of ints

import static java.lang.System.*;

public class IntStackRunner
{
	public static void main(String[] args)
	{
		IntStack test = new IntStack();
		test.push(5);
		test.push(7);
		test.push(9);
		out.println(test);
		out.println(test.isEmpty());
		out.println(test.pop());
		out.println(test.peek());
		out.println(test.pop());
		out.println(test.pop());
		out.println(test.isEmpty());
		out.println(test);
	}
}