/**
 * Created by Yichen Zhou on 9/16/16.
 */

package com.yichen.zhou;

public class MetaSort {
    /***
     * @param array: Array to modify
     * @param i: first index to exchange
     * @param j: second index to exchange
     */
    public static void exchange(Comparable[] array, int i, int j) {
        Comparable element = array[i];
        array[i] = array[j];
        array[j] = element;
    }

    /***
     * @param firstElement: First Element to compare
     * @param secondElement: Second Element to Compare
     * @return Boolean value determined by whether firstElement greater than secondElement
     */
    public static boolean less(Comparable firstElement, Comparable secondElement) {
        return firstElement.compareTo(secondElement) < 0;
    }

    /***
     * @param array: Array to modify
     * @param lo: First element in the selected array
     * @param hi: last element in the selected array
     * @return Pivot to devide and conquer
     */
    public static int partition(Comparable[] array, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable pivot = array[lo];
        while (true) {
            while(less(array[++i], pivot)) {
                if (i == hi) break;
            }
            while (less(pivot, array[--j])) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exchange(array, i, j);
        }
        exchange(array, lo, j);
        return j;
    }
}
