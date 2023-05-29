//(c) A+ Computer Science
//www.apluscompsci.com

public class ListFunHouseTwo<T>
{
	private ListNode<T> theList;
	
	public ListFunHouseTwo(){
		theList=null;
	}
	
	public void add(T data){
  		theList=new ListNode<>(data,theList);
	}
	
	//this method will return the number of nodes present in list
	public int nodeCount(){
		int count=0;
		ListNode<T> temp=theList;
		while(temp!=null){
			count++;
			temp=temp.getNext();
		}
		return count;
	}
		
	//this method will create a new node with the same value as the first node and add this
	//new node at the front of the list.  Once finished, the first node will occur twice.
	public void doubleFirst()
	{
		theList=new ListNode<>(theList.getValue(),theList);
	}

	//this method will create a new node with the same value as the last node and add this
	//new node at the end.  Once finished, the last node will occur twice.
	public void doubleLast()
	{
		ListNode<T> temp=theList;
		while(temp.getNext()!=null)
			temp=temp.getNext();
		temp.setNext(new ListNode<>(temp.getValue(),null));
	}
	
	//method skipEveryOther will remove every other node
	public void skipEveryOther()
	{
		ListNode<T> temp=theList;
		while(temp!=null && temp.getNext()!=null){
			temp.setNext(temp.getNext().getNext());
			temp=temp.getNext();
		}
	}

	//this method will set the value of every xth node in the list
	public void setXthNode(int x, T value)
	{
		int count=1;
		ListNode<T> temp=theList;
		while(temp!=null){
			for(;count<x;count++){
				if(temp==null)
					break;
				else 
					temp=temp.getNext();
			}
			if(temp!=null)
				temp.setValue(value);
			count=0;
		}
	}	

	//this method will remove every xth node in the list
	public void removeXthNode(int x)
	{
		int count=1;
		ListNode<T> temp=theList;
		while(temp!=null){
			for(;count<x-1;count++){
				if(temp==null)
					break;
				else 
					temp=temp.getNext();
			}
			if(temp!=null && temp.getNext()!=null)
				temp.setNext(temp.getNext().getNext());
			count=0;
		}

	
	}		
	//this method will return a String containing the entire list
	public String toString()
    {
		String output="";
		ListNode<T> temp=theList;
		while(temp!=null){
			output+=temp.getValue()+" ";
			temp=temp.getNext();
		}
   		return output;
    }			
}