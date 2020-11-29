package BasicSorting.SelectionSort;

import BasicSorting.SortingHelper;
import LinearSearch.ArrayGenerator;

import java.util.Arrays;

public class SelectionSort2 {

    private SelectionSort2() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = i; j >= 0; j--) {
                maxIndex = arr[j].compareTo(arr[maxIndex]) > 0 ? j : maxIndex;
            }
            swap(arr, i, maxIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 1000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        try {
            boolean success = SortingHelper.success(arr, "BasicSorting.SelectionSort.SelectionSort2");
            System.out.println(success ? "success" : "fail");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
