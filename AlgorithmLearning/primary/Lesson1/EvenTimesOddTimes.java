package primary.Lesson1;

public class EvenTimesOddTimes {

    // 在一个数组中 如果只有一个数字出现了奇数次，其他的数字出现了偶数次，请返回这个数
    public static int findOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int v : arr) {
            eor ^= v;
        }
        return eor;
    }

    // 在一个数组中 如果有两种数字出现了奇数次，其他的数字出现了偶数次，请找到这两个数
    public static int[] findOddTimesNum2(int[] arr) {
        //  假设奇数次的两个数字 为 a , b
        // 找到最右侧的 1
        // num = num & (~num + 1)
        int eor = 0;
        for (int v : arr) {
            eor ^= v;
        }
        int rightOne = eor & (~eor + 1);
        // 得到的eor 为 a ^ b 的值
        int a = 0;
        for (int v : arr) {
            if ((v & rightOne) != 0) {
                a ^= v;
            }
        }
        int b = a ^ eor;
        return new int[]{a, b};
    }
}
