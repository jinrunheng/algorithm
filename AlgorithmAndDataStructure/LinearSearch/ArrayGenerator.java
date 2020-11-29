package LinearSearch;

import java.util.Random;

public class ArrayGenerator {

    private ArrayGenerator() {
    }

    // 生成顺序的数组
    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    // 生成一个长度为n的随机数组，每个数字的范围是：[0,bound)
    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

}
