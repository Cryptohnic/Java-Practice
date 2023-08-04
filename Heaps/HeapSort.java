//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.List;
import java.util.ArrayList;
import static java.lang.System.*;

public class HeapSort
{
	private List<Integer> list;

	public HeapSort()
	{
		list = new ArrayList<Integer>();
	}

    public void swapUp(int index)
    {
		while(index>0){
			int parentPos=(index-1)/2;
			if(list.get(index)>list.get(parentPos)){
				swap(index,parentPos);
				index=parentPos;
			}else return;
		}
	}

	public void swapDown(int index)
	{
		int greaterChild;
		int root=0;
		while(root<index){
			if(root*2+2<index)
				greaterChild=list.get(root*2+1)>list.get(root*2+2) ? root*2+1 : root*2+2;
			else if(root*2+1<index)
				greaterChild=root*2+1;
			else return;
			if(list.get(root)<list.get(greaterChild)){
				swap(root,greaterChild);
				root=greaterChild;
			}
			else return;
		}
	}

   public void heapSort(int[] nums)
   {
		for(int i=0;i<nums.length;i++){
			list.add(nums[i]);
			swapUp(i);
   		}
		for(int i=nums.length-1;i>0;i--){
			swap(0,i);
			swapDown(i);
		}   	
   }
   
    private void swap(int first, int last)
    {
		int firstNum=list.get(first);
		list.set(first,list.get(last));
		list.set(last,firstNum);
	}

	public String toString()
	{
		return list.toString();
	}
}