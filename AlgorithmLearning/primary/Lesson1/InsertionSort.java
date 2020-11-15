package primary.Lesson1;

import primary.util.ArrayUtils;

import static primary.util.ArrayUtils.printArr;

public class InsertionSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                ArrayUtils.fastSwap(arr, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] testArr = ArrayUtils.generateRandomArr(0, 20, 20);
        printArr(testArr);
        sort(testArr);
        printArr(testArr);
    }
}
