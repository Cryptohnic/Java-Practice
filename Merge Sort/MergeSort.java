import static java.lang.System.out;
import java.util.Arrays;

public class MergeSort{

	public static void sort(Comparable[] list){
		mergeSort(list);
	}

	private static void mergeSort(Comparable[] list){
		if(list.length<2)
			return;
		Comparable[] leftArr=new Comparable[list.length/2];
		Comparable[] rightArr=new Comparable[list.length-list.length/2];
		for(int i=0;i<leftArr.length;i++)
			leftArr[i]=list[i];
		for(int i=0;i<rightArr.length;i++)
			rightArr[i]=list[i+list.length/2];
		mergeSort(leftArr);
		mergeSort(rightArr);
		merge(list,leftArr,rightArr);
	}

	private static void merge(Comparable[] list,Comparable[] left,Comparable[] right){
		int i=0,j=0,k=0;
		while(i<left.length && j<right.length){
			if(left[i].compareTo(right[j])<=0){
				list[k]=left[i];
				i++;
			}else{
				list[k]=right[j];
				j++;
			}
			k++;
		}
		while(i<left.length){
			list[k]=left[i];
			i++;
			k++;
		}
		while(j<right.length){
			list[k]=right[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args){
		Comparable[] arr=new Comparable[]{9,5,3,2};
		out.println("Before: "+Arrays.toString(arr)); 
		MergeSort.sort(arr);
		out.println("After: "+Arrays.toString(arr));
		arr=new Comparable[]{19,52,3,2,7,21};
		out.println("Before: "+Arrays.toString(arr));
		MergeSort.sort(arr);
		out.println("After: "+Arrays.toString(arr));
		arr=new Comparable[]{68,66,11,2,42,31};
		out.println("Before: "+Arrays.toString(arr));
		MergeSort.sort(arr);
		out.println("After: "+Arrays.toString(arr));
		arr=new Comparable[]{"d","y","a","u","12","banana"};
		out.println("Before: "+Arrays.toString(arr));
		MergeSort.sort(arr);
		out.println("After: "+Arrays.toString(arr));
	}
}