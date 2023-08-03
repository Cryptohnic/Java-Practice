//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.List;
import java.util.ArrayList;
import static java.lang.System.*;

public class Heap
{
	private List<Integer> list;

	public Heap()
	{
		list = new ArrayList<Integer>();
	}

	public void add(int value)
	{
		list.add(value);
		swapUp(list.size()-1);
	}

   public void swapUp(int bot)
   {	while(bot>0){
			int parentPos=(bot-1)/2;
			if(list.get(bot)>list.get(parentPos)){
				swap(parentPos,bot);
				bot=parentPos;
			}else return;
		}
   }

	public void remove( )
	{
		list.set(0,list.get(list.size()-1));
		list.remove(list.size()-1);
		swapDown(0);
	}

	public void swapDown(int top)
	{
		while(top<list.size()){
			int fChildIndex=top*2+1;
			int greaterIndex;
			if(fChildIndex<list.size()-1)
				greaterIndex=list.get(fChildIndex)>list.get(fChildIndex+1) ? fChildIndex : fChildIndex+1;
			else if(fChildIndex<list.size())
				greaterIndex=fChildIndex;
			else return;
			if(list.get(greaterIndex)>list.get(top))
				swap(top,greaterIndex);
			top=greaterIndex;
		}
	}
	
	private void swap(int start, int finish)
	{	
		int finishTemp=list.get(finish);
		list.set(finish,list.get(start));
		list.set(start,finishTemp);
	}

	public void print()
	{
		out.println("\n\nPRINTING THE HEAP!\n\n");
		out.println(toString());
	}

	public String toString()
	{
		return list.toString();
	}
}