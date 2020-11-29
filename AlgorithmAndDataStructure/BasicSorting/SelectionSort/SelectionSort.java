package BasicSorting.SelectionSort;

import BasicSorting.SortingHelper;
import LinearSearch.ArrayGenerator;

public class SelectionSort {

    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                minIndex = arr[minIndex].compareTo(arr[j]) > 0 ? j : minIndex;
            }
            swap(arr, minIndex, i);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) throws Exception {
        int[] dataSize = {10000,100000};
        for(int n : dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("BasicSorting.SelectionSort.SelectionSort",arr);
        }
    }
}
