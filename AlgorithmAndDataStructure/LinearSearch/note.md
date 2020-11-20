## 一：线性查找

#### 1. 什么是算法

算法：一些列解决问题的，清晰，可执行的计算机指令

算法的五大特性：

1. 有限性
2. 确定性：不会产生二义性
3. 可行性
4. 有输入
5. 有输出

#### 2. 最简单的算法：线性查找法

示例：

在一个数组data中，查找元素 16

输入：数组和要寻找的目标元素

输出：目标元素所在的索引；若不存在 则返回-1

```java
public int getTargetIndexOfData(int[] data,int target){
  int i = 0;
  for(; i < data.length; i++){
    if(data[i] == target){
      return i;
    }
  }
  return -1;
}
```



#### 3. 实现线性查找法

```java
public class LinearSearch {

    private LinearSearch() {
    }

    public static int search(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = new int[]{24, 18, 12, 9, 16, 66, 32, 4};

        int res = LinearSearch.search(data, 16);
        System.out.println(res);

        int res2 = LinearSearch.search(data, 666);
        System.out.println(res2);
    }
}
```

#### 4. 使用泛型

- 泛型不可以是基本数据类型，只能是类对象，在Java中基本数据类型有
  - boolean
  - byte
  - char
  - short
  - int 
  - long
  - float
  - double
- 每个基本数据类型都有对应的包装类
  - Boolean
  - Byte
  -  Character
  - Short
  - Integer
  - Long
  - Float
  - Double

使用泛型后的LinearSearch代码如下：

```java
public class LinearSearch {

    private LinearSearch() {
    }

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
```



#### 5.  使用自定义类测试我们的算法

设计一个Student类，重写equals方法：

Student

```java

public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
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
  
    public static void main(String[] args) {
         
          Student[] students = {new Student("Alice"),
                  new Student("Duby"),
                  new Student("Charles")};
          Student duby = new Student("Duby");
          int res = LinearSearch.search(students, duby);
          System.out.println(res);
      }
}
```



#### 6. 循环不变量

循环是算法中构建逻辑的非常重要的一种方式

什么是循环不变量呢？

拿线性查找这个算法来举例：

```java
		public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
```

当我们每一轮遍历，都会确认当前的data[i]是否为我们查找的目标

我们可以确定的是，在data[0... i - 1] 这个区间内没有找到目标，以后的循环中，我们也可以确定在这个范围没有找到目标。这就是循环不变量；而循环体本身的目的就是在维持循环不变量。

如果想要写出正确的代码，就要定义清楚循环不变量。

同样，我们也要定义清楚函数的具体功能

例如对于线性查找法：

输入：数组，和目标元素

输出：目标元素所在的索引；若不存在，则返回-1

#### 7. 简单的复杂度分析

算法复杂度分析本身是一个非常理论化的内容。

复杂度分析：表示算法的性能

继续就线性查找法的代码来分析下这个算法的复杂度。

首先复杂度的预估是要看最差的情况，也就是算法运行的上界。然后，复杂度的分析也要省略数据规模n的最高项的系数以及所有的低阶项和常数等。

对于线性查找这个算法来说，它的运行时间与数据的规模n成正比，所以它的时间复杂度为O(n)

#### 8. 常见的时间复杂度

##### O(1)

判断数字n是否是偶数

```java
		public static boolean isEven(int num) {
        return num % 2 == 0;
    }
```

##### O(logn)

二分;求对应的进制数

例如：求数字n的二进制形式

```java
		public static String toBinary(int num) {
        String res = "";
        while (num >= 1) {
            res = num % 2 + res;
            num /= 2;
        }
        return res;
    }
```

这个算法每次都将num的值除2，相当于二分，它的时间复杂度为O(logn)

##### O(√n)

求一个数所有的约数

```java
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
```

##### O(n) 

例如：线性查找

```java
public static int linearSearch(int[] nums,int target){
  for(int i = 0; i < nums.length; i++){
    if(nums[i] == target){
      return i;
    }
  }
  return -1;
}
```

##### O(nlogn)

O(nlogn)的时间复杂度最为常见的就是排序算法，例如归并排序，快速排序等

归并排序：

```java
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
```

##### O(n ^2)

数组匹配 :列出数组内所有元素两两组合的方式

```java
		public static void printAllCombination(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("{" + arr[i] + "," + arr[j] + "}");
            }
        }
    }
```

##### O(2 ^ n)

求一个长度为n的所有可能的二进制数字

这个问题本质是0 和 1的排列组合，其时间复杂度为O(2 ^ n)

```java
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
```

##### O(n!)

长度为n的数组的所有排列

```java
class Solution {
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
}
```

O(n!) 是一个非常非常高的时间复杂度！！！

##### 常见的时间复杂度的比较

```
O(1) < O(logn) < O(√n) < O(n) < O(nlogn) < O(n^2) < O(2^n) < O(n!)
```

除了时间复杂度外，还有空间复杂度，这里面的空间复杂度一般是指开辟额外的空间；在实际的算法考量中，我们会更看重时间复杂度。

#### 9. 测试算法的性能

```java
public static void main(String[] args) {

        int[] dataSize = {1000000,10000000};
        for(int n : dataSize){
            Integer[] data = ArrayGenerator.generateOrderedArray(n);
            long start = System.nanoTime();
            for(int i = 0; i < 10; i++){
                LinearSearch.search(data, n);
            }
            long end = System.nanoTime();
            System.out.println("time:" + (end - start) / 1000000000.0 + "s");
        }
}
```

上面的程序，验证了再数据量为一百万和一千万级别的情况下，线性查找的时间复杂度，我们知道线性查找的时间复杂度为O(n)

程序运行结果：

```
time:0.022831855s
time:0.267566168s
```

当数据规模成10倍变化的时候，运行的速度也大致为10倍的关系，这也间接地验证了线性查找算法的时间复杂度为O(n)











































