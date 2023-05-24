import static java.lang.System.out;
import java.util.Arrays;

public class InsertionSort{

	private static int passCount;

	public static <T extends Comparable<T>> void sort(T[] list){ 
		out.println("pass 0 "+Arrays.toString(list));
		passCount=1;
		sort(list,1,list.length);
	}

	private static <T extends Comparable<T>> void sort(T[] list,int front,int back){  
		if(front==back) return;
		if(list[front].compareTo(list[front-1])<0){
			int i=front;
			do{
				T temp=list[i];
				list[i]=list[i-1];
				list[--i]=temp;
			}while(i>0 && list[i].compareTo(list[i-1])<0);
		}
		out.println("pass "+passCount+" "+Arrays.toString(list));
		passCount++;
		sort(list,front+1,back);
	}
}