package primary.Lesson2;

import primary.util.ArrayUtils;

public class PartitionArr {

    // 给定一个数组arr，和一个数num；
    // 请把小于等于num的数放在数组的左边，大于num的树放在数组的右边。
    // 要求时间复杂度为O(N)，额外空间复杂度为O(1)
    // 返回：经过partition后，小于等于num的最后数字的索引
    public static int partition(int[] arr, int num) {
        int less = -1;
        int cur = 0;
        while (cur < arr.length) {
            if (arr[cur] <= num) {
                ArrayUtils.fastSwap(arr, cur++, ++less);
            } else {
                cur++;
            }
        }
        return less;
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateRandomArr(-100, 100, 100);
        int num = arr[50];
        System.out.println("num:" + num);
        int lessIndex = partition(arr, num);
        System.out.println("lessIndex:" + lessIndex);
        ArrayUtils.printArr(arr);
        for (int i = 0; i <= lessIndex; i++) {
            if (arr[i] > num) {
                throw new RuntimeException("fail");
            }
        }
        for (int i = lessIndex + 1; i < arr.length; i++) {
            if (arr[i] <= num) {
                throw new RuntimeException("fail");
            }
        }
        System.out.println("success");
    }
}
