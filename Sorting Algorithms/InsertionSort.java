
import static java.lang.System.out;
import java.util.Arrays;

public class InsertionSort {

    private static int passCount;

    public static <T extends Comparable<T>> void sort(T[] list) {
        passCount = 0;
        int n = list.length;
        out.println("pass " + passCount++ + " " + Arrays.toString(list));
        for (int i = 1; i < n; i++) {
            if (list[i].compareTo(list[i - 1]) < 0) { // if the current val is less than behind itself
                int j = i;
                do {
                    T temp = list[j];
                    list[j] = list[j - 1];
                    list[--j] = temp;
                } while (j > 0 && list[j].compareTo(list[j - 1]) < 0); // swap it back until it is at its position
            }
            out.println("pass " + passCount + " " + Arrays.toString(list));
            passCount++;
        }
    }
}
