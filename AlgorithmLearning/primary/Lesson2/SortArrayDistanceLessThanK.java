package primary.Lesson2;

import primary.util.ArrayUtils;

import java.util.PriorityQueue;

public class SortArrayDistanceLessThanK {

    public static void sortArrayDistanceLessThanK(int[] arr, int k) {
        // 使用小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // 保证小根堆的大小为k + 1
        int index = 0;
        for (; index <= k; index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            arr[i] = heap.poll();
            heap.add(arr[index]);
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

    public static void main(String[] args) {
        // 1,2,3,4,5,6,7,8,9
        int[] arr = new int[]{3,2,1,6,5,4,7,8,9};
        sortArrayDistanceLessThanK(arr,3);
        ArrayUtils.printArr(arr);
    }
}
