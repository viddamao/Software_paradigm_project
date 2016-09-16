/**
 * Created by Yichen Zhou on 9/16/16.
 */
package com.yichen.zhou;

public class P1 extends MetaSort {
    /***
     * @param array: Array to sort with recursion
     * @param lo: First element in the selected array
     * @param hi: Last element in the selected array
     */
    public static void QuickSort(Comparable[] array, int lo, int hi) {
        if (hi < lo) return;
        int pivot = partition(array, lo, hi);
        QuickSort(array, lo, pivot - 1);
        QuickSort(array, pivot + 1, hi);
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
