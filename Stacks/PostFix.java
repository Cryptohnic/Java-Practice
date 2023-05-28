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
			if(ch.charAt(0)>47 && ch.charAt(0)<58)
				stack.push(Double.parseDouble(ch));
			else
				stack.push(calc(stack.pop(),stack.pop(),ch.charAt(0)));
		expression+=" = "+stack.peek();
	}

	public String toString(){
		return expression;
	}
}