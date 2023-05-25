import static java.lang.System.out;
import java.util.Arrays;

public class SelectionSort{

	private static int passCount;

	public static <T extends Comparable<T>> void sort(T[] list){ //O(N^2)
		out.println("pass 0 "+Arrays.toString(list));
		passCount=1;
		sort(list,0,list.length);
	}

	private static <T extends Comparable<T>> void sort(T[] list,int front,int back){ //O(N^2) 
		if(front==back) return;
		boolean swapped=false;
		int min=front;
		for(int j=front+1;j<back;j++)
			if(list[j].compareTo(list[min])<=0){
				swapped=true;
				min=j;
			}
		if(!swapped) return;
		T temp=list[front];
		list[front]=list[min];
		list[min]=temp;
		out.println("pass "+passCount+" "+Arrays.toString(list));
		passCount++;
		sort(list,front+1,back);
	}
}