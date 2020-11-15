## 认识复杂度和简单排序算法

#### 1. 认识时间复杂度

常数时间的操作

一个操作如果和样本的数据量没有关系，每次都是固定时间内完成的操作，即叫做常数操作。

时间复杂度未一个算法流程中，常数操作数量的一个指标。常用O (读作big O)来表示。具体来说，先要对一个算法流程非常熟悉，然后去写出这个算法流程中，发生了多少常数操作，进而总结出常数操作数量的表达式。

在表达式中，只要高阶项，不要低阶项，也不要高阶项低系数，剩下的部分如果为f(N),那么时间复杂度为O(f(N))。

评价一个算法流程的好坏，先看时间复杂度的指标，然后再分析不同数据样本下的实际运行时间，也就是“常数项时间”。

示例：

```java
List<Integer> list1 = new ArrayList<>();
List<Integer> list2 = new LinkedList<>();
```

比如对于上面的两个list，list1的底层实现是动态数组，list2的底层实现是双向链表；所以当我们查询一个数据的时候，ArrayList的查询操作为O(1)的时间复杂度，而LinkedList由于底层的实现为双向链表，所以要查询一个数据，需要从头节点或者是尾节点开始遍历，最差的时候为查询链表中间的那个数据，需要遍历二分之一长度的链表，时间复杂度为O(n/2),因为时间复杂度的评估需要忽略系数，并且按照最坏的情况进行分析，所以对于LinkedList的查询操作，其时间复杂度为O(n)。



下面的程序为验证ArrayList和LinkedList两种数据结构查询100000个数据的性能：

```java
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
```

我使用的是jdk11，在我的电脑下该程序运行的结果为：

```
ArrayList执行1000000次查询操作需要的时间为:4毫秒
LinkedList执行1000000次查询操作需要的时间为:6866毫秒
```

​		

#### 2. 选择排序，冒泡排序细节与时间复杂度分析

##### 1. 选择排序

选择排序的思路：

1. 维护一个变量`minIndex`，遍历待排序的数组

2. 第一次遍历索引为`0 ~ arr.length - 1` 位置的数组，将最小的数字找到，并执行`swap(arr[0],arr[minIndex])`

3. 第二次遍历索引值为` 1 ～ arr.length - 1` 位置的数组，将这个区间范围内的最小数字找到，并执行 `swap(arr[1],arr[minIndex])`
4. 第N - 1次遍历索引值为` arr.length - 2 ～ arr.length - 1` 位置的数组，将这个区间范围内，最小的数字找到，并交换位置，这样排序就完成了。

代码如下：

```java
package primary.Lesson1;

import primary.util.ArrayUtils;

public class SelectionSort {
    // 选择排序
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int minIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr, minIndex, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
```

选择排序的时间复杂度分析：O(N ^ 2)

##### 2. 冒泡排序

冒泡排序：因水中的泡泡越往上浮越大得名，所以冒泡排序的核心思想就是每次将最大的那个数字排出来。

冒泡排序的思路：

1. 在数组范围为`0 ~ arr.length - 1`内遍历数组，遍历中依次将前一个数字和后一个数字比较：`compare(arr[i],arr[i + 1])`,将较大的数字往后移，遍历结束后，`0 ~ arr.length - 1`中最大的数字被排到了最后面

2. 在数组范围为：`0 ~ arr.length - 2`内遍历数组，遍历中依次将前一个数字和后一个数字比较, 同样将较大的数字往后移，遍历结束后，`0 ~ arr.length - 2`中最大的数字也被排好了
3. 依次执行上述操作，直到将最小的数字也排序



代码如下：

```java
package primary.Lesson1;

import primary.util.ArrayUtils;

public class BubbleSort {

    public static void sort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtils.fastSwap(arr, j, j + 1);
                }
            }
        }
      
    }
}

```

冒泡排序的时间复杂度分析：O(N ^ 2)

#### 3. 插入排序细节与复杂度分析

插入排序也叫扑克牌排序(PorkerSort),原因就是它的整体思路和抓牌的思路是一样的

插入排序的思路：

1. 从头遍历数组，对于数组的第一个数，我们将其看作抓在手里的牌，因为只有一张牌，所以它是有序的
2. 遍历到第二个数， 我们将其看作第二张牌，将第二张牌插入到手中的牌组中，使其有序
3. 遍历到第三个数，我们将其看作第三张牌，将第三张牌插入到手中的牌组中，使其有序
4. 遍历到第N个数，我们将其看作第N张牌，将第N张牌插入到手中的牌组中，手中的牌全部有序，排序也结束了



插入的过程，实际上就是当前数字，不断往前“看”的过程，如果当前数字比前面的一个数字小，那么就交换位置即可。



插入排序的代码如下：

```java
package primary.Lesson1;

import primary.util.ArrayUtils;

import static primary.util.ArrayUtils.printArr;

public class InsertionSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                ArrayUtils.fastSwap(arr, j, j - 1);
            }
        }
    }

}

```

插入排序的时间复杂度分析：

像选择排序和冒泡排序，这两种排序算法的执行流程和数据状况是无关的，也就是说当我给你一个有序数组,选择排序和冒泡排序仍然会按照固定的算法流程遍历数组，所以时间复杂度仍然为O(n ^ 2);对于插入排序，试想对于一个倒序数组，例如`[6,5,4,3,2,1]`,那么使用插入排序的时间复杂度为:  O(n);不过如果是一个已排序的数组，例如：`[1,2,3,4,5,6]`，使用插入排序算法，则只剩下便遍历，少去了“插入”的过程，它就从一个O(n ^ 2)的时间复杂度提升为了一个O(n)的排序算法。不过估计时间复杂度的时候，我们要按照最差情况进行估计，所以插入排序的时间复杂度为：O(n ^ 2)。不过相比选择排序与冒泡排序，插入排序的意义重大。

#### 4. 二分法的详解与扩展



二分法的时间复杂度：O(logn)



##### 1. 在一个有序数组中，找某个数是否存在

这道题目是二分法的基础问题,直接上代码:

```java
package primary.Lesson1;

import primary.util.ArrayUtils;

import java.util.Arrays;

public class BinarySearch {

    // 二分搜索，判断某个数字是否在一个已排序的数组中
    public static boolean exist(int[] sortedArr, int num) {
        int l = 0;
        int r = sortedArr.length - 1;
        int mid = -1;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (num < sortedArr[mid]) {
                r = mid - 1;
            } else if (num > sortedArr[mid]) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return sortedArr[l] == num;
    }

}

```

##### 2. 在一个有序数组中，找到大于等于某个数最左的位置

例，对于这样一个有序数组，找到大于等于 3 最左的位置：

```
[1,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,4,5,5,5,6,6,7]
```

结果返回：9



代码：

```java
package primary.Lesson1;

import primary.util.ArrayUtils;

import java.util.Arrays;

public class BinarySearch {

    // 在一个有序的数组中，找到大于等于某个数字最左的那个位置,没有则返回 -1
    public static int nearestIndex(int[] arr, int value) {
        int l = 0;
        int r = arr.length - 1;
        int index = -1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return index;
    }

}

```



##### 3. 局部最小值问题

对于一个无序数组 arr 满足一个条件：对于任意一个数都有相邻数字不相等

对于局部最小的定义：

- 在数组的最左侧`[3,5,... ...]` 其趋势为`↗` ，我们就说在索引值为0这个位置满足局部最小
- 在数组的最右侧`[... ...,5,3]` 其趋势为`↘`，我们就说在索引值为`arr.length - 1` 这个位置满足最小
- 除了数组的最左和最右，只有满足这样的趋势`↘ ↗` 我们才规定局部最小，例如:`[... 5,3,7 ...]` ,3这个位置为局部最小

本题要求，找到任意一个局部最小，返回这个局部最小的索引值，如果不存在局部最小，则返回 -1

思路：二分法

代码如下:

```java
package primary.Lesson1;

import primary.util.ArrayUtils;

import java.util.Arrays;

public class BinarySearch {

    // 找到局部最小
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // no exist
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 2] > arr[arr.length - 1]) {
            return arr.length - 1;
        }

        int l = 1;
        int r = arr.length - 2;
        int mid = -1;
        while (l < r) {
            mid = l + ((r - l) >> 1);

            if (arr[mid] > arr[mid - 1]) {// 左侧必然存在局部最小
                r = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {// 右侧必然存在局部最小
                l = mid + 1;
            } else {
                return mid; // arr[mid - 1] > arr[mid] && arr[mid + 1] > arr[mid] 所以 arr[mid] 为局部最小
            }
        }
        return l;
    }

}

```

这里面先从左侧进行判断，所以返回了 `l` ；如果先对右侧进行判断的话，最后返回`r` 即可：

```java
while(l < r){
  
  mid = l + ((r - l) >> 1);
  
  if (arr[mid] > arr[mid + 1]) {// 左侧必然存在局部最小
    l = mid + 1;
  } else if (arr[mid] > arr[mid - 1]) {// 右侧必然存在局部最小
    r = mid - 1;
  } else {
    return mid;
  }  
}

return r;
```



#### 5. 异或运算的性质与扩展

1. `0 ^ N == N` ，`N ^ N == 0`
2. 异或运算满足交换律和结合律



##### 1. 不用额外变量交换两个数

```java
public static void swap(int[] arr, int i, int j){
  arr[i] = arr[i] ^ arr[j];
  arr[j] = arr[i] ^ arr[j];
  arr[i] = arr[i] ^ arr[j];
}
```



##### 2. 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到这一个数

```java
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

}

```



##### 3. 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到这两个数

首先，先来了解一个非常重要的方法：如何快速找到一个数字二进制下，最右侧的那个1

方法:

```java
int rightOne = num & (~num + 1);
```

示例：

对于数字

```
010010110100
```

对其进行上述操作后：

```
000000000100
```

回到本题：

如果只有两个数a,b出现了奇数次，其余数字都出现了偶数次，那么将所有数字异或运算的结果为：`eor = a ^ b`

我们用上面介绍的技巧获取到eor最右侧的1`rightOne = eor & (~eor + 1)`；

接下来数组中就可以划分为两块，一块中，含有数字a以及若干个偶数次数的数字；另一块则是含有数字b及若干个偶数次数的数字，

对于这两块，我们的求解方式就转换成了上一题：一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到这样的一个数？

完整代码如下：

```java
package primary.Lesson1;

public class EvenTimesOddTimes {

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

```

#### 6. 对数器

对数器的概念和使用

1. 有一个你想要测的方法a
2. 实现复杂度不好，但是容易实现的方法b
3. 实现一个随机样本器
4. 将方法a和方法b跑相同的随机样本，看看得到的结果是否一致
5. 如果有一个随机样本使得比对的结果不一致，打印样本进行人工干预，进行改进
6. 当样本数量很多时，对比测试依然正确，那么就可以确定方法a已经正确

