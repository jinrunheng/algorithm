package BasicSorting.InsertionSort;


import BasicSorting.SortingHelper;
import LinearSearch.ArrayGenerator;

import java.util.Arrays;

public class InsertionAndSelectionSortTest {

    public static void main(String[] args) throws Exception {
        int n = 10000;
        // 测试无序数组，分别使用InsertionSort和SelectionSort排序的性能
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] copyArr = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("BasicSorting.InsertionSort.InsertionSort2", arr);
        SortingHelper.sortTest("BasicSorting.SelectionSort.SelectionSort", copyArr);

        // 测试有序数组，分别使用InsertionSort和SelectionSort排序的性能
        Integer[] arr2 = ArrayGenerator.generateOrderedArray(n);
        Integer[] copyArr2 = Arrays.copyOf(arr2, arr2.length);
        SortingHelper.sortTest("BasicSorting.InsertionSort.InsertionSort2", arr2);
        SortingHelper.sortTest("BasicSorting.SelectionSort.SelectionSort", copyArr2);
    }
}
