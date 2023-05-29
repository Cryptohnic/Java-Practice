//(c) A+ Computer Science
//www.apluscompsci.com

public class ListFunHouseTwo<T>
{
	private ListNode<T> theList;
	
	public ListFunHouseTwo(){
		theList=new ListNode<>();
	}
	
	public void add(T data){
  		theList=new ListNode<>(data,theList); // add to the front
	}
	
	//this method will return the number of nodes present in list
	public int nodeCount(){
		int count=0;
		ListNode<T> temp=theList;
		while(temp!=null){ // count the value and then go to the next
			count++;
			temp=temp.getNext();
		}
		return count;
	}
		
	//this method will create a new node with the same value as the first node and add this
	//new node at the front of the list.  Once finished, the first node will occur twice.
	public void doubleFirst()
	{
		theList=new ListNode<>(theList.getValue(),theList); // set the next value to the first's value and storing the next Node to double the first
	}

	//this method will create a new node with the same value as the last node and add this
	//new node at the end.  Once finished, the last node will occur twice.
	public void doubleLast()
	{
		ListNode<T> temp=theList;
		while(temp.getNext()!=null) // traverse to the last Node
			temp=temp.getNext();
		temp.setNext(new ListNode<>(temp.getValue(),null)); // change the next from null to a new node with the same value pointing to null
	}
	
	//method skipEveryOther will remove every other node
	public void skipEveryOther()
	{
		ListNode<T> temp=theList;
		while(temp!=null && temp.getNext()!=null){ // if we have two values left, skip the next value
			temp.setNext(temp.getNext().getNext());
			temp=temp.getNext();
		}
	}

	//this method will set the value of every xth node in the list
	public void setXthNode(int x, T value)
	{
		int count=1; // count the first Node
		ListNode<T> temp=theList; 
		while(temp!=null){ 
			for(;count<x;count++) // iterate up to the xth Node
				if(temp!=null) // keep traversing up to count
					temp=temp.getNext();
				else break;
			if(temp!=null) // if we aren't at the end
				temp.setValue(value); // setXthNode to value
			count=0;
		}
	}	

	//this method will remove every xth node in the list
	public void removeXthNode(int x)
	{
		int count=1; // count the first Node
		ListNode<T> temp=theList; 
		while(temp!=null){ 
			for(;count<x-1;count++) // iterate up to one before the xthNode
				if(temp!=null) // keep traversing up to count
					temp=temp.getNext();
				else break;
			if(temp!=null && temp.getNext()!=null) // if we have two Nodes
				temp.setNext(temp.getNext().getNext()); // skip the second
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