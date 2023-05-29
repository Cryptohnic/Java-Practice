//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Stack;

public class PostFix
{
	private Stack<Double> stack;
	private String expression;

	public PostFix()
	{
		this("");
	}

	public PostFix(String exp)
	{
		stack=new Stack<>();
		setExpression(exp);
	}

	public void setExpression(String exp)
	{
		expression=exp;
	}

	public double calc(double one, double two, char op)
	{
		// use two(operator)one because post order still evaluates the numbers left to right and the first number will get popped second
		switch(op){
			case '+': return two+one;
			case '-': return two-one;
			case '*': return two*one;
			default: return two/one;
		}
	}

	public void solve()
	{
		for(String ch : expression.split(" "))
			if(ch.charAt(0)>47 && ch.charAt(0)<58) // if we are at a number
				stack.push(Double.parseDouble(ch)); // push it to the Stack
			else
				stack.push(calc(stack.pop(),stack.pop(),ch.charAt(0))); // push the calculation after popping the two numbers
		expression+=" = "+stack.peek(); // add the result to the expression
	}

	public String toString(){
		return expression;
	}
}