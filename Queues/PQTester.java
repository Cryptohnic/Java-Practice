//(c) A+ Computer Science
//www.apluscompsci.com

//Name -  

import java.util.Queue;
import java.util.PriorityQueue;

public class PQTester
{
	private Queue<String> pQueue;

	public PQTester()
	{
		this("");
	}

	public PQTester(String list)
	{
		pQueue=new PriorityQueue<>();
		setPQ(list);
	}

	public void setPQ(String list)
	{
		for(String s : list.split(" ")) // add everything to the pQueue
			pQueue.add(s);
	}
	
	public Object getMin()
	{
		return pQueue.peek();
	}
	
	// pQueues aren't stored in order but rather remove in natural order generally using a min heap to have O(1) to the smallest val to get natural order remove everything
	public String getNaturalOrder()
	{
		String ans="";
		while(!pQueue.isEmpty())
			ans+=pQueue.remove()+" ";
		return ans;
	}

	public String toString(){
		return "toString() = "+pQueue.toString()+"\ngetMin() - "+getMin()+"\ngetNaturalOrder() - "+getNaturalOrder()+"\n\n";
	}
}