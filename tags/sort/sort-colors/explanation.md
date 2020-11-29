## 颜色分类

[75. 颜色分类](https://leetcode-cn.com/problems/sort-colors/)

#### 解题思路：快排partition

颜色分类问题又称为荷兰国旗问题，该问题是快排partition的流程

指定三个指针

- less：`-1`
- cur：`0`
- more：`arr.length`

less指针用来跟踪国旗的红色部分，也就是数组数值等于0的部分；cur用来跟踪当前遍历到的值；more指针用来跟踪国旗的蓝色部分，也就是数组数值等于2的部分。

算法流程实际上并不难，看code并且画图就可以懂，代码如下：

#### 代码

Java

```java
class Solution {
    public void sortColors(int[] nums) {
        // 0...0,1...1,2...2
        int less = -1;
        int more = nums.length;
        int cur = 0;
        while(cur < more){
            if(nums[cur] == 0){
                swap(nums,cur++,++less);
            }else if(nums[cur] == 2){
                swap(nums,cur,--more);
            }else{
                cur++;
            }
        }
    }

    private static void swap(int[] arr,int i,int j){
        if(i == j){
            return;
        }

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
```

Go

```go
func sortColors(nums []int)  {
    less := -1
    more := len(nums)
    cur := 0
    for cur  < more{
        if nums[cur] == 0 {
            less++
            nums[cur],nums[less] = nums[less],nums[cur]
            cur++
        } else if nums[cur]  == 2 {
            more--
            nums[cur],nums[more] = nums[more],nums[cur]
        }else {
            cur++
        }
    }
}
```

