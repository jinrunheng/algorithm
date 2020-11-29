package BasicSorting.InsertionSort;

import BasicSorting.SortingHelper;
import LinearSearch.ArrayGenerator;

public class InsertionSort3 {

    private InsertionSort3() {

    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 循环不变量为:arr[0...i) 未排序；arr[i...n)排好序
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = i; j <= arr.length - 2 && arr[j].compareTo(arr[j + 1]) > 0; j++) {
                swap(arr, j, j + 1);
            }
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
            boolean success = SortingHelper.success(arr, "BasicSorting.InsertionSort.InsertionSort3");
            System.out.println(success ? "success" : "fail");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
