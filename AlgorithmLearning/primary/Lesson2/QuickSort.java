package primary.Lesson2;

import primary.util.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            ArrayUtils.fastSwap(arr, r, l + new Random().nextInt(r - l + 1));
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[0] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int cur = l;
        int less = l - 1;
        int more = r;
        // 每次都以arr[r]作为partition的划分值
        while (cur < more) {
            if (arr[cur] < arr[r]) {
                ArrayUtils.fastSwap(arr, ++less, cur++);
            } else if (arr[cur] > arr[r]) {
                ArrayUtils.fastSwap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        ArrayUtils.fastSwap(arr, more, r);
        return new int[]{less + 1, more};
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateRandomArr(-100, 100, 100);
        int[] copyArr = Arrays.copyOf(arr, arr.length);

        QuickSort.sort(arr);
        Arrays.sort(copyArr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != copyArr[i]) {
                throw new RuntimeException("sort is fail");
            }
        }

        System.out.println("success");
    }
}
