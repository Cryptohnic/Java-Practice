//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class PalinList
{
	private Queue<String> queue;
	private Stack<String> stack;

	public PalinList()
	{
		this("");
	}

	public PalinList(String list)
	{
		queue=new LinkedList<>();
		stack=new Stack<>();
		setList(list);
	}

	public void setList(String list)
	{
		for(String s : list.split(" ")){
			stack.push(s);
			queue.add(s);
		}
	}

	public boolean isPalin()
	{
		int times=stack.size()/2;
		for(int i=0;i<times;i++)
			if(!stack.pop().equals(queue.remove()))
				return false;
		return true;
	}


	public String toString(){
		return stack.toString()+(isPalin() ? " is a palinlist." : " is not a palinlist.")+"\n";
	}
}