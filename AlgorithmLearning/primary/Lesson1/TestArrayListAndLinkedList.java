package primary.Lesson1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TestArrayListAndLinkedList {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();

        for (int i = 0; i < 100000; i++) {
            list1.add(i);
            list2.add(i);
        }

        Random random = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list1.get(random.nextInt(100000));
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList执行1000000次查询操作需要的时间为:" + (end - start) + "毫秒");

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list2.get(random.nextInt(100000));
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList执行1000000次查询操作需要的时间为:" + (end - start) + "毫秒");
    }
}
