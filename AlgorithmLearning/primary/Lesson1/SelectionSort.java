package primary.Lesson1;

import primary.util.ArrayUtils;

public class SelectionSort {
    // 选择排序
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int minIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr, minIndex, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 8, 6, 7, 1};
        sort(arr);
        ArrayUtils.printArr(arr);
    }
}
