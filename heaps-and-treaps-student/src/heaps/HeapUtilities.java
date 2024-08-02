/*
 * Copyright 2023 Marc Liberatore.
 */
package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HeapUtilities {

    /**
     * Returns true iff the subtree of a starting at index i is a max-heap.
     *
     * @param a an array representing a mostly-complete tree, possibly a heap
     * @param i an index into that array representing a subtree rooted at i
     * @return true iff the subtree of a starting at index i is a max-heap
     */
    static boolean isHeap(double[] a, int i) {
        if (i * 2 + 1 >= a.length) {
            return true;
        }
        if (a[i * 2 + 1] > a[i] || i * 2 + 2 < a.length && a[i * 2 + 2] > a[i]) {
            return false;
        }
        return isHeap(a, i * 2 + 1) && isHeap(a, i * 2 + 2);
    }

    /**
     * Perform the heap siftdown operation on index i of the array a.
     *
     * This method assumes the subtrees of i are already valid max-heaps.
     *
     * This operation is bounded by n (exclusive)! In a regular heap, n =
     * a.length, but in some cases (for example, heapsort), you will want to
     * stop the sifting at a particular position in the array. siftDown should
     * stop before n, in other words, it should not sift down into any index
     * great than (n-1).
     *
     * @param a the array being sifted
     * @param i the index of the element to sift down
     * @param n the bound on the array (that is, where to stop sifting)
     */
    static void siftDown(double[] a, int i, int n) {
        while (i * 2 + 1 < n) { // while we have children to check
            int swapIndex;
            if (i * 2 + 2 < n) { // if two children
                if (a[i * 2 + 1] > a[i] || a[i * 2 + 2] > a[i]) { // if either are greater
                    swapIndex = a[i * 2 + 1] > a[i * 2 + 2] ? i * 2 + 1 : i * 2 + 2; // swap with bigger
                } else { // we are done
                    break;
                }
            } else if (a[i * 2 + 1] > a[i]) { // if our one child is greater, swap with it
                swapIndex = i * 2 + 1;
            } else { // we are done.
                break;
            }
            double temp = a[i]; // swap
            a[i] = a[swapIndex];
            a[swapIndex] = temp;
            i = swapIndex;
        }
    }

    /**
     * Heapify the array a in-place in linear time as a max-heap.
     *
     * @param a an array of values
     */
    static void heapify(double[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            siftDown(a, i, a.length);
        }
    }

    /**
     * Heapsort the array a in-place, resulting in the elements of a being in
     * ascending order.
     *
     * @param a
     */
    static void heapSort(double[] a) {
        heapify(a);
        int back = a.length - 1;
        while (back > 0) {
            double temp = a[0];
            a[0] = a[back];
            a[back] = temp;
            siftDown(a, 0, back--);
        }
    }

    public static void main(String[] args) {
        Random r = new Random(0);
        int length = 15;
        double[] l = new double[length];
        for (int i = 0; i < length; i++) {
            l[i] = r.nextInt(20);
        }
        System.out.println(Arrays.toString(l));

        heapify(l);

        System.out.println(Arrays.toString(l));

        heapSort(l);

        System.out.println(Arrays.toString(l));

        ArrayList<Double> arr = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            double rand = (Math.random() * 10 + 1);
            arr.add(rand);
        }
        double[] newArr = new double[50];
        int i = 0;
        for (double d : arr) {
            newArr[i] = arr.get(i);
            i++;
        }
        heapSort(newArr);
        System.out.println(Arrays.toString(newArr));
    }
}
