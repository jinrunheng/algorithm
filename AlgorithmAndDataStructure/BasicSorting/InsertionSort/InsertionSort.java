package BasicSorting.InsertionSort;

import BasicSorting.SortingHelper;
import LinearSearch.ArrayGenerator;

public class InsertionSort {

    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) throws Exception {
        int n = 1000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        try {
            boolean success = SortingHelper.success(arr, "BasicSorting.InsertionSort.InsertionSort");
            System.out.println(success ? "success" : "fail");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        // 插入排序的时间复杂度测试;
        int[] dataSize = {10000,100000};
        for(int a : dataSize){
            Integer[] nums = ArrayGenerator.generateRandomArray(a, a);
            SortingHelper.sortTest("BasicSorting.InsertionSort.InsertionSort",nums);
        }
    }
}
