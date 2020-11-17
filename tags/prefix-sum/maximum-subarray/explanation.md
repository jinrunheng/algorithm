## 最大子序和

[最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)

#### 思路：前缀和

1. 创建两个变量`maxSum`和`curSum`用来表示遍历数组过程中最大和以及遍历到目前位置的和
2. 首先将`maxSum`初始化为数组首个元素，`curSum`初始化为0
3. 将当前遍历到的数组元素与`curSum`相加，并与`maxSum`进行比较
4. 如果说`curSum`大于`maxSum` 就更新`maxSum`;如果`curSum`小于等于0就重置`curSum`使其恢复至初始值0

#### 代码

Java:

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = 0;

        for(int i = 0; i < nums.length; i++){
            curSum += nums[i];
            if(curSum > maxSum){
                maxSum = curSum;
            }
            if(curSum <= 0){    
                curSum = 0;
            }
        }
        return maxSum;
    }
}
```

Go:

```go
func maxSubArray(nums []int) int {
    maxSum := nums[0]
    curSum := 0
    
    for i := 0; i < len(nums); i++ {
        curSum = curSum + nums[i]
        if curSum > maxSum {
            maxSum = curSum
        }
        if curSum <= 0 {
            curSum = 0
        }
    }
    return maxSum
}
```











