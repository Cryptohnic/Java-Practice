
import static java.lang.System.out;
import java.util.Arrays;

// Prints where spot would be in current length arr so it would move everything to the right and itself up an index
public class BinarySearchRunner {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 2, 2, 3, 6, 7, 7, 7, 7, 7, 7, 9, 10, 12, 12, 13, 14, 15, 15, 15, 17, 20};
        out.println("Here is the array: " + Arrays.toString(arr) + "\nThe length of the array is: " + arr.length);
        int num = (int) (Math.random() * 25 + 1);
        out.println("Random number that we are searching for: " + num);
        out.println("Location of the number according to my Binary Search method: " + BinarySearch.binarySearch(arr, num));
        out.println("Location of the number according to Java's Binary Search method: " + Arrays.binarySearch(arr, num));
    }
}
