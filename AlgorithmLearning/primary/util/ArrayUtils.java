package primary.util;

import java.util.Random;

public class ArrayUtils {

    // 打印数组
    public static void printArr(int[] nums) {
        System.out.print("Array: [");
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                System.out.print(nums[i] + "]");
            } else {
                System.out.print(nums[i] + ",");
            }
        }
        System.out.println();
    }

    // 交换数组中两个位置的数字
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // fast swap
    // 使用的前提条件是：i != j
    public static void fastSwap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    // 生成一个在[rangeLeft,rangeRight]范围内的数字
    public static int generateRandomNum(int rangeLeft, int rangeRight) {
        Random random = new Random();
        return random.nextInt(rangeRight - rangeLeft + 1) + rangeLeft;
    }

    // 创建一个指定长度的随机数组
    public static int[] generateRandomArr(int rangeLeft, int rangeRight, int len) {
        // 生成每一个元素在[rangeLeft,rangeRight]范围内，且数组长度为len的随机数组
        if (rangeLeft > rangeRight) {
            throw new IllegalArgumentException("数组指定的范围错误");
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = generateRandomNum(rangeLeft, rangeRight);
        }
        return res;
    }
}
