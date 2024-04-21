//(c) A+ Computer Science  -  www.apluscompsci.com

import static java.lang.System.out;
import java.util.Arrays;

public class MergeSort {

    private static int passCount;

    public static <T extends Comparable<T>> void mergeSort(T[] list) {  // O(Nlog(N))
        passCount = 0;
        out.println("pass " + passCount++ + " " + Arrays.toString(list));
        int subSize = 2;
        int n = list.length;
        for (; subSize <= n; subSize *= 2) { // split the array into mini arrays of length 2
            int left = 0;
            for (; left + subSize - 1 < n; left += subSize) { // while we can still make a subarray
                int right = left + subSize - 1;
                int mid = (left + right) / 2;
                merge(list, left, mid, right); // sort the two smaller sorted arrays together
            }
            out.println("pass " + passCount++ + " " + Arrays.toString(list));
        }
        if (subSize / 2 < n) { // if there are remaining values left on the end due to a list length not a multiple of 2, sort the entire sorted array with the remaining sorted edge values 
            merge(list, 0, subSize / 2 - 1, n - 1);
            out.println("pass " + passCount++ + " " + Arrays.toString(list));
        }
    }

    private static <T extends Comparable<T>> void merge(T[] list, int left, int mid, int right) {  // O(N)
        T[] temp = Arrays.copyOfRange(list, left, right + 1);
        int i = 0, j = mid - left + 1, k = left;
        while (i <= mid - left && j <= right - left) {
            if (temp[i].compareTo(temp[j]) < 0) {
                list[k++] = temp[i++];
            } else {
                list[k++] = temp[j++];
            }
        }
        while (i <= mid - left) {
            list[k++] = temp[i++];
        }
        while (j <= right - left) {
            list[k++] = temp[j++];
        }
    }
}
