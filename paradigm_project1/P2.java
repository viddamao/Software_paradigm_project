/**
 * Created by Yichen Zhou on 9/16/16.
 */

package com.yichen.zhou;

public class P2 extends MetaSort {
    /***
     * @param array: Array to sort without recursion
     * @param lo: First element in the selected array
     * @param hi: Last element in the selected array
     */
    public static void QuickSort(Comparable[] array, int lo, int hi) {
        int stack[] = new int[hi - lo + 1];
        int top = -1;
        stack[++top] = lo;
        stack[++top] = hi;

        while (top >= 0) {
            hi = stack[top--];
            lo = stack[top--];

            int pivot = partition(array, lo, hi);

            if (pivot - 1 > lo) {
                stack[++top] = lo;
                stack[++top] = pivot - 1;
            }

            if (pivot + 1 < hi) {
                stack[++top] = pivot + 1;
                stack[++top] = hi;
            }
        }
    }

    public static void main(String[] args) {
        Comparable<Integer>[] data = new Integer[1000];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int)Math.round(Math.random() * 10000);
        }

        QuickSort(data, 0, data.length - 1);

        for (int i = 0; i < data.length - 1; i++) {
            System.out.println(data[i]) ;
        }
    }
}
