package primary.util;

import java.util.Arrays;
import java.util.Random;

// 用于测试排序方法是否正确的对数器
public class SortComparator {

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // 生成一个随机数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // 生成数组的长度随机
        // random.nextInt(rangeRight - rangeLeft + 1) + rangeLeft;
        Random random = new Random();
        int[] arr = new int[random.nextInt(maxSize + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random())
                    - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // 拷贝数组并返回
    public static int[] copyArray(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    // 比较两个数组每个数字是否相同
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // 打印数组
    public static void printArray(int[] arr) {
        ArrayUtils.printArr(arr);
    }
}
