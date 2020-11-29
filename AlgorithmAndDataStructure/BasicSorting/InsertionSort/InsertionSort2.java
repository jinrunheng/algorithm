package BasicSorting.InsertionSort;

import BasicSorting.SortingHelper;
import LinearSearch.ArrayGenerator;

import java.util.Arrays;

public class InsertionSort2 {

    private InsertionSort2() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            E tmp = arr[i];
            int j = i;
            for (; j > 0 && tmp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) throws Exception {

        // 插入排序的时间复杂度测试;
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] nums = ArrayGenerator.generateRandomArray(n, n);
            Integer[] copyNums = Arrays.copyOf(nums, nums.length);
            SortingHelper.sortTest("BasicSorting.InsertionSort.InsertionSort", nums);
            SortingHelper.sortTest("BasicSorting.InsertionSort.InsertionSort2", copyNums);
        }
    }
}
