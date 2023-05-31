//(c) A+ Computer Science
//www.apluscompsci.com

public class HistoList
{
   private HistoNode front;

	public HistoList( )
	{
		front = null;
	}

	//addLetter will add a new node to the front for let if let does not exist
	//addLetter will bump up the count if let already exists
	public void addLetter(char let)
	{

		int index=indexOf(let);
		if(indexOf(let)!=-1){ // if a node already exists
			HistoNode current=nodeAt(index);
			current.setDataCount(current.getDataCount()+1); // update its count
		}	
		else
			front=new HistoNode(let,1,null,front); // add it to the front
	}

	//returns the index pos of let in the list if let exists
	public int indexOf(char let)
	{
		int spot=0;
		HistoNode temp=front;
		while(temp!=null){ // loop through the list
			if(temp.getData().compareTo(let)==0) // if we found it return the index
				return spot;
			else{
				spot++;
				temp=temp.getRight();
			}
		}
		return -1;
	}

	//returns a reference to the node at spot
	private HistoNode nodeAt(int spot)
	{
		HistoNode current=front;
		for(int i=0;i<spot;i++) // go to that node
			current=current.getRight();
		return current;
	}

	//returns a string will all values from list
	public String toString()
	{
		String output = "";
		while(front!=null){ // formatting
			output+=front.getData()+" - "+front.getDataCount()+"\t";
			front=front.getRight();
		}
		return output;
	}
}