/*
 * Copyright 2023 Marc Liberatore.
 */
package sorting;

import java.util.Arrays;

public class SortingExercises {

    static void arrEquals(double[] a, double[] b) {
    }

    /**
     * Swap the values at a[i] and a[j].
     */
    static void swap(double[] a, int i, int j) {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * Perform an in-place insertion sort on the array a. The array will be in
     * ascending order (least-to-greatest) after sorting.
     */
    static void insertionSort(double[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; (j > 0 && a[j - 1] > a[j]); j--) {
                swap(a, j, j - 1);
            }
        }
    }

    /**
     * Perform an in-place insertion sort of the range start (inclusive) through
     * end (exclusive) on array a. The array will be in ascending order
     * (least-to-greatest) after sorting.
     */
    static void insertionSort(double[] a, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            for (int j = i; (j > start && a[j - 1] > a[j]); j--) {
                swap(a, j, j - 1);
            }
        }
    }

    /**
     * Perform a destructive mergesort on the array a.
     *
     * The array will be in ascending order (least-to-greatest) after sorting;
     * the original values will be overwritten. Additional array space will be
     * allocated by this method.
     *
     * For efficiency, this method will *insertion sort* any array of length
     * less than 10.
     */
    public static void mergeSort(double[] a) {
        mergeSort(a, 0, a.length);
    }

    private static void mergeSort(double[] a, int start, int end) {
        if (start + 1 >= end) {
            return;
        }
        if (end - start < 10) {
            insertionSort(a, start, end);
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(a, start, mid);
        mergeSort(a, mid, end);
        merge(a, start, Arrays.copyOfRange(a, start, mid), Arrays.copyOfRange(a, mid, end));
    }

    /**
     * Merge the sorted arrays l and r into the array a (overwriting its
     * previous contents).
     */
    static void merge(double[] a, int start, double[] l, double[] r) {
        int x = 0;
        int y = 0;
        int i = start;
        while (x < l.length && y < r.length) {
            if (l[x] < r[y]) {
                a[i++] = l[x++];
            } else {
                a[i++] = r[y++];
            }
        }
        while (x < l.length) {
            a[i++] = l[x++];
        }
        while (y < r.length) {
            a[i++] = r[y++];
        }
    }

    /**
     * Perform an in-place quicksort on the array a.
     */
    static void quickSort(double[] a) {
        quickSort(a, 0, a.length);
    }

    /**
     * Perform an in-place quicksort on the range i (inclusive) to j (exclusive)
     * of the array a.
     *
     * For efficiency, this method will *insertion sort* any range of length
     * less than 10.
     */
    static void quickSort(double[] a, int i, int j) {
        if (i + 1 >= j) {
            return;
        }
        if (j - i < 10) {
            insertionSort(a, i, j);
        }
        int pivot = partition(a, i, j);
        quickSort(a, i, pivot);
        quickSort(a, pivot + 1, j);
    }

    /**
     * Perform an in-place partition on the range i (inclusive) to j (exclusive)
     * of the array a, returning the index of the pivot after partitioning.
     *
     * To cut down on worst case choices, this method will chose the pivot value
     * at random from among the values in the range.
     *
     * @return the index of the pivot after the partition
     */
    static int partition(double[] a, int i, int j) {
        swap(a, j - 1, (int) (Math.random() * (j - i) + i));
        double pivot = a[j - 1];
        for (int y = i; y < j - 1; y++) {
            if (a[y] <= pivot) {
                swap(a, i, y);
                i++;
            }
        }
        swap(a, i, j - 1);
        return i;
    }

    public static void main(String[] args) {
        double[] test = new double[]{1.0, 4.0, 6.0, 2.0, 0.0, 5.0, 7.0, 8.0, 10.0, 11.0, 12.0, 1.0, 12.0, 2.0, 4.0};
        quickSort(test);
        System.out.println(Arrays.toString(test));

        for (int x = 0; x < 20; x++) {
            double[] a = new double[9];
            for (int i = 0; i < 9; i++) {
                a[i] = Math.floor(Math.random() * 10 + 1);
            }
            double[] b = Arrays.copyOf(a, a.length);
            SortingExercises.quickSort(a);
            Arrays.sort(b);
            System.out.println(Arrays.toString(a) + " " + Arrays.toString(b) + " " + Arrays.equals(a, b));
        }
    }
}
