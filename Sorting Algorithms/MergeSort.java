//(c) A+ Computer Science  -  www.apluscompsci.com

import static java.lang.System.out;
import java.util.Arrays;

public class MergeSort{

	private static int passCount;

	public static <T extends Comparable<T>> void mergeSort(T[] list){  //O(Nlog(N))
		out.println("pass 0 "+Arrays.toString(list));
		passCount=1;
		mergeSort(list,0,list.length);
	}

	private static <T extends Comparable<T>> void mergeSort(T[] list,int front,int back){  //O(log(N))
		if(back-front==1) return;
		int mid=(front+back)/2;
		mergeSort(list,front,mid);
		mergeSort(list,mid,back);
		merge(list,front,back);
		out.println("pass "+passCount+" "+Arrays.toString(list));
		passCount++;
	}

	private static <T extends Comparable<T>> void merge(T[] list, int front, int back){  //O(N)
		@SuppressWarnings("unchecked")
		T[] temp=(T[]) new Comparable[back-front];
		int i=front, mid=(front+back)/2, k=0, j=mid;
		while(i<mid && j<back){
			if(list[i].compareTo(list[j])<0)
				temp[k++]=list[i++];
			else
				temp[k++]=list[j++];
		}
		while(i<mid)
			temp[k++]=list[i++];
		while(j<back)
			temp[k++]=list[j++];
		for(int p=0;p<temp.length;p++)
			list[front+p]=temp[p];
	}
}