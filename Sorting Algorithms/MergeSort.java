//(c) A+ Computer Science  -  www.apluscompsci.com

import static java.lang.System.out;
import java.util.Arrays;

public class MergeSort{

	private static int passCount;

	public static void mergeSort(Comparable[] list){  // O(Nlog(N))
		passCount=0;
		out.println("pass "+passCount+++" "+Arrays.toString(list));
		int subSize=2;
		int n=list.length;
		for(;subSize<=n;subSize*=2){ // split the array into mini arrays of length 2
			int left=0;
			for(;left+subSize-1<n;left+=subSize){ // while we can still make a subarray
				int right=left+subSize-1;
				int mid=(left+right)/2;
				merge(list,left,mid,right); // sort the two smaller sorted arrays together
			}
			out.println("pass "+passCount+++" "+Arrays.toString(list));
		}
		if(subSize/2<n){ // if there are remaining values left on the end due to a list length not a multiple of 2, sort the entire sorted array with the remaining sorted edge values 
			merge(list,0,subSize/2-1,n-1);
			out.println("pass "+passCount+++" "+Arrays.toString(list));
		}
	}

	private static void merge(Comparable[] list, int left, int mid, int right){  // O(N)

		Comparable[] temp=new Comparable[right-left+1];
		int i=left, j=mid+1, k=0;
		while(i<=mid && j<=right) // while we have vals in both halves still
			if(list[i].compareTo(list[j])<0) // if left is smaller insert it otherwise insert smaller right value
				temp[k++]=list[i++];
			else
				temp[k++]=list[j++];
		while(i<=mid) // if only left values remaining
			temp[k++]=list[i++];
		while(j<=right) // if only right values remaining
			temp[k++]=list[j++];
		for(int p=0;p<temp.length;p++) // update with sorted mini list
			list[left+p]=temp[p];
	}
}