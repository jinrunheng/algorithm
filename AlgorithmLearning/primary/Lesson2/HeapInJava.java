package primary.Lesson2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapInJava {

    // 在Java中 PriorityQueue（优先级队列）的底层实现为 堆
    // 默认生成是小根堆
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(6);
        minHeap.add(5);
        minHeap.add(7);
        minHeap.add(3);
        minHeap.add(2);
        minHeap.add(8);
        System.out.println("MinHeap : ");
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        maxHeap.add(6);
        maxHeap.add(5);
        maxHeap.add(7);
        maxHeap.add(3);
        maxHeap.add(2);
        maxHeap.add(8);
        System.out.println("MaxHeap : ");
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }
}
