//(c) A+ Computer Science
//www.apluscompsci.com

public class ListNode<T> implements Linkable<T>
{
	private T listNodeValue;
	private ListNode<T> nextListNode;

	public ListNode()
	{
		this(null,null);
	}

	public ListNode(T value, ListNode<T> next)
	{
		listNodeValue=value;
		nextListNode=next;
	}

	public T getValue()
	{
		return listNodeValue;
	}

	public ListNode<T> getNext()
	{
	   return nextListNode;
	}


	public void setValue(T value)
	{
		listNodeValue = value;
	}

	public void setNext(Linkable<T> next)
	{
		nextListNode = (ListNode<T>)next;
	}
}