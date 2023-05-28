//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.*;

public class ListFunHouse
{
	//this method will print the entire list on the screen
    public static void print(ListNode<?> list)
    {
		while(list!=null){
			out.print(list.getValue()+" ");
			list=list.getNext();
		}
    }		
	
	//this method will return the number of nodes present in list
	public static int nodeCount(ListNode<?> list)
	{
   		int count=0;
		while(list!=null){
			count++;
			list=list.getNext();
		}
		return count;
	}
		
	//this method will create a new node with the same value as the first node and add this
	//new node to the list.  Once finished, the first node will occur twice.
	public static <T> void doubleFirst(ListNode<T> list)
	{
		list.setNext(new ListNode<>(list.getValue(),list.getNext()));
	}

	//this method will create a new node with the same value as the last node and add this
	//new node at the end. Once finished, the last node will occur twice.
	public static <T> void doubleLast(ListNode<T> list)
	{
		while(list.getNext()!=null)
			list=list.getNext();
		list.setNext(new ListNode<>(list.getValue(),null));
	}
		
	//method skipEveryOther will remove every other node
	public static <T> void skipEveryOther(ListNode<T> list)
	{
		while(list!=null && list.getNext()!=null){
			list.setNext(list.getNext().getNext());
			list=list.getNext();
		}
	}

	//this method will set the value of every xth node in the list
	public static <T> void setXthNode(ListNode<T> list, int x, T value)
	{
		int count=1;
		while(list!=null){
			for(;count<x;count++){
				if(list==null)
					break;
				else 
					list=list.getNext();
			}
			if(list!=null)
				list.setValue(value);
			count=0;
		}
	}	

	//this method will remove every xth node in the list
	public static <T> void removeXthNode(ListNode<T> list, int x)
	{
		int count=1;
		while(list!=null){
			for(;count<x-1;count++){
				if(list==null)
					break;
				else 
					list=list.getNext();
			}
			if(list!=null && list.getNext()!=null)
				list.setNext(list.getNext().getNext());
			count=0;
		}
	}		
}