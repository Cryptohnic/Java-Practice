//(c) A+ Computer Science  -  www.apluscompsci.com
import static java.lang.System.out;
public class SelectionSortRunner{
	public static void main(String args[]){
		SelectionSort.<Integer>sort(new Integer[]{9,5,3,2});
		out.println("\n\n");
		SelectionSort.<Integer>sort(new Integer[]{19,52,3,2,7,21});
		out.println("\n\n");
		SelectionSort.<Integer>sort(new Integer[]{68,66,11,2,42,31});
	}
}