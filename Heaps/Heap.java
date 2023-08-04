//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.List;
import java.util.ArrayList;
import static java.lang.System.*;

public class Heap{
	private List<Integer> list;

	public Heap(){
		list=new ArrayList<Integer>();
	}

	public void add(int value){
		list.add(value);
		swapUp(list.size()-1); // add the value and then swap up into its correct pos
	}

    public void swapUp(int bot){
		while(bot>0){
			int parentPos=(bot-1)/2;
			if(list.get(bot)>list.get(parentPos)){  // if we are greater than our parent
				swap(parentPos,bot);
				bot=parentPos;
			}else return;	
		}
	}

	public void remove(){
		list.set(0,list.get(list.size()-1)); // swap it to the back
		list.remove(list.size()-1); // remove it
		swapDown(list.size()-1); // swapDown the entire heap
	}

	public void swapDown(int top){
		int greaterIndex;
		int root=0;
		while(root<top){ 
			if(root*2+2<top) // if we have two children
				greaterIndex=list.get(root*2+1)>list.get(root*2+2) ? root*2+1 : root*2+2; // pick the greater one
			else if(root*2+1<top) // if we only have a left child
				greaterIndex=root*2+1;
			else return;
			if(list.get(greaterIndex)>list.get(root)){ // swapDown if the child is larger
				swap(root,greaterIndex);
				root=greaterIndex;
			}else break;
		}
	}
	
	private void swap(int start, int finish){	
		int finishTemp=list.get(finish);
		list.set(finish,list.get(start));
		list.set(start,finishTemp);
	}

	public void print(){
		out.println("\n\nPRINTING THE HEAP!\n\n");
		out.println(toString());
	}

	public String toString(){
		return list.toString();
	}
}