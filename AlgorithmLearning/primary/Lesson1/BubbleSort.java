package primary.Lesson1;

import primary.util.ArrayUtils;

public class BubbleSort {

    public static void sort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtils.fastSwap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] testArr = ArrayUtils.generateRandomArr(0, 10, 20);
        ArrayUtils.printArr(testArr);
        sort(testArr);
        ArrayUtils.printArr(testArr);
    }
}
