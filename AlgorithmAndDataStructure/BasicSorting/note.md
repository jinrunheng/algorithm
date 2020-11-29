## 排序基础

#### 一：选择排序

##### 1. 最简单的排序算法：选择排序

算法流程：

每次选择还没有处理的元素中里最小的元素

- 先把最小的拿出来
- 剩下的，再把最小的拿出来
- 剩下的，再把最小的拿出来
- ... ... 

##### 2. 实现选择排序

```java
package BasicSorting.SelectionSort;

import primary.util.ArrayUtils;

public class SelectionSort {

    private SelectionSort() {
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr, minIndex, i);
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

这个算法流程的循环不变量：

保证 `arr[0...i)` 是有序的；`arr[i...n)` 是无序的

##### 3. 使用带约束的泛型

```java
package BasicSorting.SelectionSort;

import primary.util.ArrayUtils;

public class SelectionSort {

    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                minIndex = arr[minIndex].compareTo(arr[j]) > 0 ? j : minIndex;
            }
            swap(arr, minIndex, i);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

```

##### 4. 使用Comparable接口

使用自定义的类，测试我们的SelectionSort

自定义Student类

```java
package BasicSorting.SelectionSort;

public class Student implements Comparable<Student> {

    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object student) {

        if (this == student) {
            return true;
        }
        if (student == null) {
            return false;
        }
        if (this.getClass() != student.getClass()) {
            return false;
        }
        Student another = (Student) student;
        return this.name.equalsIgnoreCase(another.name);
    }

    @Override
    public int compareTo(Student s) {
      // return s.id - this.id // 从大到小排序
        return this.id - s.id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

```

测试用例：

```java
Student[] students = {
        new Student("Alice",98),
        new Student("Bobo",88),
        new Student("Charles",44)
};
SelectionSort.sort(students);
for(int i = 0; i < students.length; i++){
    System.out.println(students[i]);
}
```

输出结果：

```
Student{name='Charles', id=44}
Student{name='Bobo', id=88}
Student{name='Alice', id=98}
```

##### 5. 选择排序法的复杂度分析

O(N^2)

对于选择排序，算法的常数项操作总共执行了一个等差数列的个数：`1 + 2 + 3 + 4 + ... + n ` ;所以 这个算法的时间复杂度为`O(N ^ 2)`

验证：

**SortingHelper**

```java
package BasicSorting;

import java.lang.reflect.Method;

public class SortingHelper {

    private SortingHelper() {
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortname, E[] arr) throws Exception {
        Class<?> clazz = Class.forName(sortname);
        Method method = clazz.getMethod("sort", Comparable[].class);
        long startTime = System.nanoTime();

        method.invoke(null, (Object) arr);

        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortname + "failed");
        }
        System.out.println(String.format("%s,n = %d : %f s", sortname.substring(sortname.lastIndexOf(".") + 1), arr.length, time));
    }
}
```

**SelectionSort**

```java
package BasicSorting.SelectionSort;

import BasicSorting.SortingHelper;
import LinearSearch.ArrayGenerator;

public class SelectionSort {

    // SelectionSort
  	// ... 
    public static void main(String[] args) throws Exception {
        int[] dataSize = {10000,100000};
        for(int n : dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("BasicSorting.SelectionSort.SelectionSort",arr);
        }
    }
}
```

使用一万和十万级别的数据量进行测试：我的PC运行结果为：

```
SelectionSort,n = 10000 : 0.107708 s
SelectionSort,n = 100000 : 10.925124 s
```

可以看到数据的性能差异大约是100倍

SelectionSort本来是一个O(N ^ 2)的复杂度算法，在数据量增加10倍，对应的性能差异为100倍，这也从侧面验证了选择排序的时间复杂度。

##### 6. 换个方式实现选择排序

之前的选择排序的循环不变量为：

保证 `arr[0...i)` 是有序的；`arr[i...n)` 是无序的

我们也可以让：

保证`arr[i...n)`是有序的；`arr[0...i)`是无序的

换句话说，要想维持这样的循环不变量，我们需要将最大的那个数字排好序，算法流程如下：

```java
package BasicSorting.SelectionSort;

import LinearSearch.ArrayGenerator;

import java.util.Arrays;

public class SelectionSort2 {

    private SelectionSort2() {
    }
		
  	// 维持循环不变量为： 保证`arr[i...n)`是有序的；`arr[0...i)`是无序的
    public static <E extends Comparable<E>> void sort(E[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = i; j >= 0; j--) {
                maxIndex = arr[j].compareTo(arr[maxIndex]) > 0 ? j : maxIndex;
            }
            swap(arr, i, maxIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
	
  	// 另一种验证方法
    public static void main(String[] args) {
        int n = 1000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] copyArr = Arrays.copyOfRange(arr, 0, arr.length);
        SelectionSort2.sort(arr);
        Arrays.sort(copyArr);
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals(copyArr[i])) {
                throw new RuntimeException("sort failed");
            }
        }
        System.out.println("sort success");
    }
}

```

#### 二：插入排序

##### 1. 插入排序

插入排序又名`pokerSort`，其排序规则和码扑克牌是一样的；算法流程很简单

插入排序的循环不变量：`arr[0...i)` 已排好序；`arr[i...n)`是未排序的

从循环不变量上来看插入排序和选择排序是一样的

不同点为，选择排序在`arr[0...i)` 上保证的是在整个数组中最小的i个元素，也就是说选择排序处理完了一个元素，就可以保证这个元素处于在整个数组排好序之后的位置

而插入排序的循环不变量`arr[0...i)` 上保证的是，在当前的`[0...i)` 这个范围内，有序；但是这个暂时的排序结果并不意味着整个数组排好序的结果

##### 2. 实现插入排序

```java
package BasicSorting.InsertionSort;

import BasicSorting.SortingHelper;
import LinearSearch.ArrayGenerator;

public class InsertionSort {

    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) throws Exception {
        int n = 1000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        try {
            boolean success = SortingHelper.success(arr, "BasicSorting.InsertionSort.InsertionSort");
            System.out.println(success ? "success" : "fail");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        // 插入排序的时间复杂度测试;
        int[] dataSize = {10000,100000};
        for(int a : dataSize){
            Integer[] nums = ArrayGenerator.generateRandomArray(a, a);
            SortingHelper.sortTest("BasicSorting.InsertionSort.InsertionSort",nums);
        }
    }
}
```

程序运行的结果：

```
success
InsertionSort,n = 10000 : 0.207835 s
InsertionSort,n = 100000 : 21.377826 s
```

通过一万和十万的数据量进行测试，可以看到算法的性能大约相差了100倍；也从侧面验证了插入排序算法的时间复杂度为:O(N ^ 2)

##### 3. 插入排序的优化

用赋值操作代替交换操作:

因为我们实现的插入排序每次比较，如果前一个元素比后一个元素小，都需要执行一次swap操作；我们可以将赋值操作替换swap操作

代码实现如下：

```java
package BasicSorting.InsertionSort;

import BasicSorting.SortingHelper;
import LinearSearch.ArrayGenerator;

import java.util.Arrays;

public class InsertionSort2 {

    private InsertionSort2() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            E tmp = arr[i];
            int j = i;
            for (; j > 0 && tmp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) throws Exception {

        // 插入排序的时间复杂度测试;
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] nums = ArrayGenerator.generateRandomArray(n, n);
            Integer[] copyNums = Arrays.copyOf(nums, nums.length);
            SortingHelper.sortTest("BasicSorting.InsertionSort.InsertionSort", nums);
            SortingHelper.sortTest("BasicSorting.InsertionSort.InsertionSort2", copyNums);
        }
    }
}
```

程序运行结果：

```
InsertionSort,n = 10000 : 0.242032 s
InsertionSort2,n = 10000 : 0.197895 s
InsertionSort,n = 100000 : 22.228751 s
InsertionSort2,n = 100000 : 15.383164 s
```

可以看出，优化后的插入排序比优化前的插入排序 ，效率上有一定程度的提升

##### 4. 插入排序的特性

插入排序本身内层循环的条件有两个：

即：`j > 0 && arr[j].compareTo(arr[j - 1]) < 0`

除了判断数组的索引不越界意外，还需要判断后一个数`arr[j]`要比前一个数`arr[j - 1]` 小，如果小才会发生交换操作。换句话说，插入排序的时间复杂度实际上和数组的状态是有关的，如果一个数组是有序数组，那么插入排序就会提升为一个O(N)的时间复杂度的算法；不过讨论一个算法的时间复杂度，我们仍然要按照最差的时间复杂度进行估计，所以插入排序本身还是一个O(N ^ 2)的算法

选择排序则不同，选择排序是一个同数据状况无关的算法，选择排序永远都是一个O(N ^ 2)的时间复杂度算法

代码实测：

```java
package BasicSorting.InsertionSort;


import BasicSorting.SortingHelper;
import LinearSearch.ArrayGenerator;

import java.util.Arrays;

public class InsertionAndSelectionSortTest {

    public static void main(String[] args) throws Exception {
        int n = 10000;
        // 测试无序数组，分别使用InsertionSort和SelectionSort排序的性能
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] copyArr = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("BasicSorting.InsertionSort.InsertionSort2", arr);
        SortingHelper.sortTest("BasicSorting.SelectionSort.SelectionSort", copyArr);

        // 测试有序数组，分别使用InsertionSort和SelectionSort排序的性能
        Integer[] arr2 = ArrayGenerator.generateOrderedArray(n);
        Integer[] copyArr2 = Arrays.copyOf(arr2, arr2.length);
        SortingHelper.sortTest("BasicSorting.InsertionSort.InsertionSort2", arr2);
        SortingHelper.sortTest("BasicSorting.SelectionSort.SelectionSort", copyArr2);
    }
}
```

程序运行结果：

```
InsertionSort2,n = 10000 : 0.189733 s
SelectionSort,n = 10000 : 0.111922 s
InsertionSort2,n = 10000 : 0.000136 s
SelectionSort,n = 10000 : 0.106459 s
```

可以看到,在数据状况为无序的时候，插入排序和选择排序的效率并没有什么明显的差距；但是在数据状况为有序的情况下，插入排序则有了巨大的提升；因为如我们上述分析，在数据状况有序的时候，插入排序就相当于是一个O(N)时间复杂度的算法。

##### 5. 换一个角度实现插入排序

我们实现的插入排序的循环不变量为:

```
arr[0,i)已经排好序;arr[i...n)是未排序的
```

将循环不变量翻转：

```
arr[0...i)是未排序的；arr[i...n)已经排好序
```

代码如下：

```java
package BasicSorting.InsertionSort;

import BasicSorting.SortingHelper;
import LinearSearch.ArrayGenerator;

public class InsertionSort3 {

    private InsertionSort3() {

    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 循环不变量为:arr[0...i) 未排序；arr[i...n)排好序
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = i; j <= arr.length - 2 && arr[j].compareTo(arr[j + 1]) > 0; j++) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
```



