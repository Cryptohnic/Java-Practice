import static java.lang.System.out;
import java.util.Arrays;

public class SelectionSort{

	private static int passCount;

	public static void sort(Comparable[] list){ //O(N^2)
		passCount=0;
		out.println("pass "+passCount+++" "+Arrays.toString(list));
		for(int i=0;i<list.length-1;i++){
			int min=i;
			for(int j=i+1;j<list.length;j++) // loop through each val starting one in front of current position
				if(list[j].compareTo(list[min])<0) // if we find a smaller value, prepare to swap
					min=j;
			Comparable temp=list[min]; // swap with smaller value
			list[min]=list[i];
			list[i]=temp;
			out.println("pass "+passCount+++" "+Arrays.toString(list));
		}
	}
}