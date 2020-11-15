package primary.Lesson1;

import primary.util.ArrayUtils;

import java.util.Arrays;

public class BinarySearch {

    // 二分搜索，判断某个数字是否在一个已排序的数组中
    public static boolean exist(int[] sortedArr, int num) {
        int l = 0;
        int r = sortedArr.length - 1;
        int mid = -1;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (num < sortedArr[mid]) {
                r = mid - 1;
            } else if (num > sortedArr[mid]) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return sortedArr[l] == num;
    }

    // 在一个有序的数组中，找到大于等于某个数字最左的那个位置,没有则返回 -1
    public static int nearestIndex(int[] arr, int value) {
        int l = 0;
        int r = arr.length - 1;
        int index = -1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return index;
    }

    // 找到局部最小
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // no exist
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 2] > arr[arr.length - 1]) {
            return arr.length - 1;
        }

        int l = 1;
        int r = arr.length - 2;
        int mid = -1;
        while (l < r) {
            mid = l + ((r - l) >> 1);

            if (arr[mid] > arr[mid - 1]) {// 左侧必然存在局部最小
                r = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {// 右侧必然存在局部最小
                l = mid + 1;
            } else {
                return mid; // arr[mid - 1] > arr[mid] && arr[mid + 1] > arr[mid] 所以 arr[mid] 为局部最小
            }
        }
        return l;
    }


    public static void main(String[] args) {
        // exist test
        int[] testArr1 = ArrayUtils.generateRandomArr(-10, 10, 100);
        Arrays.sort(testArr1);
        int existNum = testArr1[ArrayUtils.generateRandomNum(0, 100)];
        int notExistNum = 11;
        System.out.println(exist(testArr1, existNum)); // true
        System.out.println(exist(testArr1, notExistNum)); // false

        // nearestIndex test
        int[] testArr2 = new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 5, 5, 5, 6, 6, 7};
        int index = nearestIndex(testArr2, 3);
        System.out.println(index == 9);
    }
}
