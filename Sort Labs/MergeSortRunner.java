//(c) A+ Computer Science  -  www.apluscompsci.com
import static java.lang.System.out;
public class MergeSortRunner{
	public static void main(String args[]){
		MergeSort.mergeSort(new Comparable[]{9,5,3,2});
		out.println("\n\n");
		MergeSort.mergeSort(new Comparable[]{19,52,3,2,7,21});
		out.println("\n\n");
		MergeSort.mergeSort(new Comparable[]{68,66,11,2,42,31});
	}
}