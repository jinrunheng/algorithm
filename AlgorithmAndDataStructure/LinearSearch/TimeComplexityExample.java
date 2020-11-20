package LinearSearch;

import java.util.ArrayList;
import java.util.List;


// 各种时间复杂度算法的示例
public class TimeComplexityExample {

    // 线性查找 时间复杂度 O(n)
    public static int linearSearch(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 数组匹配 时间复杂度O(n ^ 2)
    // 排列出数组内所有元素两两组合的方式
    public static void printAllCombination(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("{" + arr[i] + "," + arr[j] + "}");
            }
        }
    }

    // 将一个输入的数字转换为二进制的形式 时间复杂度O(logn)
    public static String toBinary(int num) {
        String res = "";
        while (num >= 1) {
            res = num % 2 + res;
            num /= 2;
        }
        return res;
    }

    // 求一个数字的所有余数 时间复杂度O(√n)
    public static List<Integer> getAllDivisor(int num) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (num / i == i) {
                    res.add(i);
                } else {
                    res.add(i);
                    res.add(num / i);
                }
            }
        }
        return res;
    }

    // 求一个长度为 n 的所有可能的二进制数字 时间复杂度为O(2 ^ n)
    public static List<String> getAllBinaryOfLengthN(int n) {
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            List<String> res = new ArrayList<>();
            res.add("0");
            res.add("1");
            return res;
        }
        List<String> res = new ArrayList<>();
        List<String> list = getAllBinaryOfLengthN(n - 1);
        for (String s : list) {
            res.add(s + "0");
            res.add(s + "1");
        }
        return res;
    }

    // O(nlogn)的典型算法为排序算法：比如归并排序
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        sort(arr, l, mid);
        sort(arr, mid, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int p1 = l;
        int p2 = mid + 1;
        int[] help = new int[r - l + 1];
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    // 判断数字n是否是偶数 时间复杂度O(1)
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    // 求出长度为n的数组的所有排列(全排列)  时间复杂度O(n!)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permute(nums,0,res,list);
        return res;
    }

    private static void permute(int[] nums,int begin,List<List<Integer>> res,List<Integer> list){
        if(begin == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = begin; i < nums.length; i++){
            swap(nums,i,begin);
            list.add(nums[begin]);
            permute(nums,begin + 1,res,list);
            list.remove(list.size() - 1);
            swap(nums,i,begin);
        }
    }

    private static void swap(int[] nums, int i, int j){
        if(i == j)
            return;

        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        // 求对应的二进制数
        System.out.println(toBinary(60));

        // 打印数组所有的排列
        int[] arr = {1, 2, 3, 4};
        printAllCombination(arr);

        // 求一个数所有的约数
        List<Integer> allDivisor = getAllDivisor(16);
        for (int divisor : allDivisor) {
            System.out.println(divisor);
        }

        // 求一个长度为n的所有可能的二进制数字
        List<String> allBinaryOfLengthN = getAllBinaryOfLengthN(3);
        for (String s : allBinaryOfLengthN) {
            System.out.println(s);
        }
    }
}
