## 认识O(N * logN)的排序

#### 1. 剖析递归行为和递归行为时间复杂度的估算

master公式的使用

```
T(N) = a * T(N/b) + O(N ^ d)

T(N)为母问题的时间规模
T(N/b)为子问题的时间规模
O(N ^ d)为在一个递归过程中，除去调用递归之外，剩下的复杂度是什么
```

1. log(b,a) > d；复杂度为O(N ^ log(b,a))
2. log(b,a) = d；复杂度为O(N ^ d * logN)
3. log(b,a) < d；复杂度为O(N ^ d)
   

使用master公式的前提是，递归过程划分的子过程规模一致



如：用递归方法找一个数组中的最大值，系统上到底是怎么做的？

代码如下：

```java
package primary.Lesson2;

public class GetMax {

    public static int getMax(int[] arr) {
        return getMax(arr, 0, arr.length - 1);
    }

    private static int getMax(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }

        int mid = l + ((r - l) >> 1);
        int leftMax = getMax(arr, l, mid);
        int rightMax = getMax(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }
}

```

对这个代码分析时间复杂度：

```
T(N) = a * T(N/b) + O(N ^ d)
```

首先母问题是N的数据规模T(N)

就getMax方法，将母问题分解为两个子问题（本来是从0 ～ N这个范围求最大值，递归将其划分为更小的数据规模：在0～mid和mid+1 ~ r 这两个范围求最大值；每个子问题的规模为T(N / 2),并且发生了两次所以为 2 * T(N / 2)

除去调用子问题外，剩下的时间复杂度为O(1)

所以，该问题的Master公式可以写成：

```
T(N) = 2 * T(N / 2) + O(1) 
```

所以 a = 2; b = 2; d = 0

所以有 log(a,b) > d

所以，这个递归求解最大值的算法的时间复杂度为：O(N ^ log(b,a)) = O(N)

#### 2. 归并排序

1. 整体就是一个简单的递归，左边排好序，右边排好序，让其整体有序
2. 让其整体有序的过程里用了排外序方法
3. 利用master公式来求解时间复杂度
4. 归并排序的实质

归并排序的代码：

```java
package primary.Lesson2;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        mergeSort(arr, 0, arr.length - 1);

    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
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
}

```

归并排序的时间复杂度分析：

首先归并排序可以使用master公式，因为它很显然将母问题划分成了两个等规模的子问题；除去两个子问题，归并排序还需要将help数组所有的数都刷回到原数组中，这个操作的时间复杂度很显然为O(N)

所以归并排序的master公式表示为:`T(N) = 2 * T(N / 2 + O(N))`

因为有：log(b,a) = d；所以复杂度为O(N ^ d * logN) = O(N * logN)

#### 3. 归并排序的扩展

##### 小和问题

问题描述：

```
在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和
例：[1,3,4,2,5]

1左边比1小的数，无
3左边比3小的数：1
4左边比4小的数：1，3
2左边比2小的数：1
5左边比5小的数：1，3，4，2

所以小和为：1 + 1 + 3 + 1 + 1 + 3 + 4 + 2 = 16
```

代码：

```java
package primary.Lesson2;

public class SmallSum {

    public static int mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid)
                + mergeSort(arr, mid + 1, r)
                + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            // 只有在arr[p1]严格小于arr[p2]的时候，才会产生arr[p1]的小和
            // 所以在arr[p1] == arr[p2]的时候，要先移动p2指针
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
        return res;
    }

}

```

##### 逆序对问题

[剑指 Offer 51. 数组中的逆序对](https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/)

题目描述：

```
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

示例：

输入: [7,5,6,4]
输出: 5

解释：
{[7,5],[7,6],[7,4],[5,4],[6,4]}
```

本题和小和问题异曲同工，代码思路实际上是一致的

代码如下：

```java
package primary.Lesson2;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums);
    }

    private static int mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeSort(nums, l, mid)
                + mergeSort(nums, mid + 1, r)
                + merge(nums, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= r) {
            res += arr[p1] > arr[p2] ? r - p2 + 1 : 0;
            help[i++] = arr[p1] > arr[p2] ? arr[p1++] : arr[p2++];
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
        return res;
    }
}
```



#### 4. 堆

完全二叉树：

能够保证严格地从左至右增长的树就是完全二叉树



1. 堆结构就是用数组实现的完全二叉树结构
2. 完全二叉树中如果每棵子树的最大值都在顶部就是大根堆
3. 完全二叉树中如果每棵子树的最小值都在顶部就是小根堆
4. 堆结构的heapInsert与heapify操作
5. 堆结构的增大和减少
6. 优先级队列结构，就是堆结构



使用数组作为底层数据结构，构造出一个堆结构：

如果要完成将数组作为一个底层数据结构，构造出一个假想的堆结构，我们需要知道每个子节点和其父节点的关系

1. 如果知道当前节点为`arr[i]`,那么有左孩子节点表示为`arr[2 * i + 1]` ;右孩子节点表示为`arr[2 * i + 2]`
2. 如果知道当前节点为`arr[i]`,那么其父节点可以表示为`arr[(i - 1) / 2]`

##### heapInsert

```java
// heapInsert arr[index]为刚刚插入的数字
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            ArrayUtils.fastSwap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
```

##### heapify

```java
// heapify arr[index]能否往下沉
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = 0;
            // 两个孩子中，谁的值大，把下标给largest
            // 如果有右孩子
            if (left + 1 < heapSize) {
                largest = arr[left + 1] > arr[left] ? left + 1 : left;
            } else {
                // 如果没有右孩子
                largest = left;
            }

            // 父节点和较大的孩子之间，谁的值大，就将下表给largest
            largest = arr[largest] > arr[index] ? largest : index;
            // 如果父节点最大，那么就退出循环
            if (largest == index) {
                break;
            }
            ArrayUtils.fastSwap(arr, largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }
```



heapInsert和heapify这两种算法的时间复杂度不难想到为：O(logN)；因为无论是heapInsert(向上调整) 还是 heapify(向下调整) ，这两种算法最差的情况，都只是遍历了整棵树的高度，而对于完全二叉树而言，树的高度为O(logN)

##### Java中的堆：PriorityQueue

PriorityQueue(优先级队列),它的底层实现就是堆，在Java中，当我们new一个PriorityQueue，它默认创建的是一个小根堆

```java
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
```



#### 5. 堆排序

理解了堆结构以后，堆排序就非常容易了

堆排序的步骤

1. 遍历数组，将当前的数字heapInsert到堆中，形成大根堆
2. 交换大根堆的堆顶和堆尾的数字
3. 完成heapify操作，每次都会排好最大的数字，然后heapSize减1

堆排序完整代码如下：

```java
package primary.Lesson2;

import primary.util.ArrayUtils;
import primary.util.SortComparator;

import java.util.Arrays;

public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        ArrayUtils.fastSwap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            ArrayUtils.swap(arr, 0, --heapSize);
        }
    }


    // heapInsert arr[index]为刚刚插入的数字
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            ArrayUtils.fastSwap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // heapify arr[index]能否往下沉
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = 0;
            // 两个孩子中，谁的值大，把下标给largest
            // 如果有右孩子
            if (left + 1 < heapSize) {
                largest = arr[left + 1] > arr[left] ? left + 1 : left;
            } else {
                // 如果没有右孩子
                largest = left;
            }

            // 父节点和较大的孩子之间，谁的值大，就将下表给largest
            largest = arr[largest] > arr[index] ? largest : index;
            // 如果父节点最大，那么就退出循环
            if (largest == index) {
                break;
            }
            ArrayUtils.fastSwap(arr, largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }

}

```



堆排序的复杂度分析：

heapInsert和heapify的时间复杂度均为O(logN),这两个操作都执行了N次，所以我们可以得出堆排序的时间复杂度为O(N * logN)

并且和归并排序不同，堆排序的额外空间复杂度为O(1),迭代中只是使用了有限的几个变量，并且没有递归行为。

堆排序的优化：将heapInsert替换为heapify

```java
for(int i = arr.length - 1; i >= 0; i--){
  heapify(arr,i,arr.length);
}
```

heapInsert相当于从上向下构建堆，而heapify则是从下至上进行构建；因为堆是一棵完全二叉树，例如：

``` 
      o
    /   \
   o     o
  / \   / \
 o   o o   o
```

heapInsert的总时间可以这样表示：

```
O(1) + 2 * O(2) + 4 * O(3) = 17
```

heapify的总时间可以这样表示：

```
4 * O(1) +  2 * O(2) + O(3) = 12
```

所以，heapify这种从下至上构建的方式，要更快！

上面的分析也可以通过数学归纳法求证：

```
T(N) = N/2 * 1 + N/4 * 2 + N/8 * 3 ...
2T(N) = N + N/2 * 2 + N/4 * 3

下面的减去上面的
T(N) = N + N/2 + N/4 + N/8 ...
由此可以看出这是一个等比数列
所以它的时间复杂度可以表示为：
T(N) = aN 
所以 我们将原本的O(NlogN)的时间复杂度算法优化到了O(N)的算法！！！
```



##### 堆排序扩展题目

题目如下：

已知一个几乎有序的数组，几乎有序是指，如果把数组排好序的话，每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。请选择一个排序算法针对这个数据进行排序。已知：k < 数组的长度

```java
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
```

其时间复杂度O(N * logK)

#### 6. 比较器的使用

```java
package primary.Lesson2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MyComparator {
    public static class Student {
        public int id;
        public String name;
        public int age;

        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    // 按照学生id由小到大
    public static class IdAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    // 按照学生id由大到小
    public static class IdDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    // 按照学生age由小到大
    public static class AgeAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }

    // 按照学生age由大到小
    public static class AgeDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(1, "小王", 23);
        Student student2 = new Student(3, "小红", 21);
        Student student3 = new Student(2, "小张", 28);
        Student student4 = new Student(4, "小李", 18);
        Student student5 = new Student(5, "小强", 31);
        List<Student> students = new ArrayList<>();

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        PriorityQueue<Student> heap1 = new PriorityQueue<>(new IdDescendingComparator());
        PriorityQueue<Student> heap2 = new PriorityQueue<>(new IdAscendingComparator());
        PriorityQueue<Student> heap3 = new PriorityQueue<>(new AgeDescendingComparator());
        PriorityQueue<Student> heap4 = new PriorityQueue<>(new AgeAscendingComparator());


        for (Student s : students) {
            heap1.add(s);
            heap2.add(s);
            heap3.add(s);
            heap4.add(s);
        }
        System.out.println("按照id升序打印：");
        while (!heap2.isEmpty()) {
            System.out.println(heap2.poll());
        }
        System.out.println("按照id降序打印：");
        while (!heap1.isEmpty()) {
            System.out.println(heap1.poll());
        }
        System.out.println("按照age升序打印：");
        while (!heap4.isEmpty()) {
            System.out.println(heap4.poll());
        }
        System.out.println("按照age降序打印：");
        while (!heap3.isEmpty()) {
            System.out.println(heap3.poll());
        }
    }
}
```

代码执行结果：

```
按照id升序打印：
Student{id=1, name='小王', age=23}
Student{id=2, name='小张', age=28}
Student{id=3, name='小红', age=21}
Student{id=4, name='小李', age=18}
Student{id=5, name='小强', age=31}
按照id降序打印：
Student{id=5, name='小强', age=31}
Student{id=4, name='小李', age=18}
Student{id=3, name='小红', age=21}
Student{id=2, name='小张', age=28}
Student{id=1, name='小王', age=23}
按照age升序打印：
Student{id=4, name='小李', age=18}
Student{id=3, name='小红', age=21}
Student{id=1, name='小王', age=23}
Student{id=2, name='小张', age=28}
Student{id=5, name='小强', age=31}
按照age降序打印：
Student{id=5, name='小强', age=31}
Student{id=2, name='小张', age=28}
Student{id=1, name='小王', age=23}
Student{id=3, name='小红', age=21}
Student{id=4, name='小李', age=18}
```

#### 7. 快排

##### 问题1

给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，大于num的树放在数组的右边。要求时间复杂度为O(N)，额外空间复杂度为O(1)

代码如下：

```java
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
```

##### 问题2

leetcode题目：[75. 颜色分类](https://leetcode-cn.com/problems/sort-colors/)

又名荷兰国旗问题：

代码：

```java
class Solution {
    public void sortColors(int[] nums) {
        // 0...0,1...1,2...2
        int less = -1;
        int more = nums.length;
        int cur = 0;
        while (cur < more) {
            if (nums[cur] == 0) {
                swap(nums, cur++, ++less);
            } else if (nums[cur] == 2) {
                swap(nums, cur, --more);
            } else {
                cur++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
```

##### 快速排序

只要明白了partition的过程，快排的代码就非常简单了：

```java
package primary.Lesson2;

import primary.util.ArrayUtils;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[0] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int cur = l;
        int less = l - 1;
        int more = r;
        // 每次都以arr[r]作为partition的划分值
        while (cur < more) {
            if (arr[cur] < arr[r]) {
                ArrayUtils.fastSwap(arr, ++less, cur++);
            } else if (arr[cur] > arr[r]) {
                ArrayUtils.fastSwap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        ArrayUtils.fastSwap(arr, more, r);
        return new int[]{less + 1, more};
    }
}

```

##### 快排的改进

随机选择partition的划分值

代码如下：

```java
package primary.Lesson2;

import primary.util.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
          	// 改进的部分，让原本固定在最后的partition划分值 变成了随机位置 
            ArrayUtils.fastSwap(arr, r, l + new Random().nextInt(r - l + 1));
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[0] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int cur = l;
        int less = l - 1;
        int more = r;
        // 每次都以arr[r]作为partition的划分值
        while (cur < more) {
            if (arr[cur] < arr[r]) {
                ArrayUtils.fastSwap(arr, ++less, cur++);
            } else if (arr[cur] > arr[r]) {
                ArrayUtils.fastSwap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        ArrayUtils.fastSwap(arr, more, r);
        return new int[]{less + 1, more};
    }
}

```

##### 快速排序的时间复杂度分析

当我们改进了快排以后，每次划分值的落点就变得随机了，通过概率求期望得到，这个落点的划分会将母问题划分成两个等规模的子问题

通过Master公式可以得到快速排序:`T(N) = 2 * T(N/2) + O(N)`

a = 2

b = 2

d = 1

因为有：

`log(b,a) = d`；所以最终的时间复杂度为`O(N ^ d * logN)` 为：`O(N * log(N))`

##### 快速排序的额外空间复杂度分析

当我们每次都将整个排好序的数组的中间做为落点时，partition每次额外开辟的数组就可以复用，这样就同一棵树一样，开辟的空间和树的高度成正相关，所以其额外空间复杂度为`O(logN)`

