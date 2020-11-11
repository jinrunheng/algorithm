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





