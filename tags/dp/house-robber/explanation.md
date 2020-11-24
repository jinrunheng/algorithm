## 动态规划经典入门问题：打家劫舍

#### 解题思路：dp

设计动态规划的三个步骤：

1. 将问题分解成子问题
2. 使用递归的方式表述子问题
3. 递归是自顶向下的设计方式，dp则是自底向上将递归转换为迭代



将问题分解成最优子问题：

如果房屋数量只有一间，那么偷窃的最高总金额就是这间房屋的金额。

如果房屋数量有两间，那么偷窃的最高总金额就是两间房屋中最大的金额数量。

如果房屋数量大于两间，应该如何计算能够偷窃到的最高总金额呢？对于第 `k(k>2)`间房屋，有两个选项：

1. 偷窃第 k 间房屋，那么就不能偷窃第 k-1间房屋，偷窃总金额为前 k-2间房屋的最高总金额与第 k 间房屋的金额之和。
2. 不偷窃第 k间房屋，偷窃总金额为前 k-1 间房屋的最高总金额。



使用递归方式描述子问题：

```java
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        return rob(nums,nums.length - 1);
    }

    private int rob(int[] nums,int lastIndex){
        if(lastIndex == 0){
            return nums[0];
        }
        if(lastIndex == 1){
            return Math.max(nums[0],nums[1]);
        }
        int sum1 = rob(nums,lastIndex - 1);
        int sum2 = rob(nums,lastIndex - 2) + nums[lastIndex];
        return Math.max(sum1,sum2);
    }
}
```

递归方式是一种自顶向下的思考方式，这个代码无法通过OJ，最后会显示超出时间限制，因为递归的代码中，含有大量的重复计算。

动态规划，就是将每次计算的结果存储，避免重复的计算，这是一种用空间换时间的策略。

创建dp数组,用 dp[i]表示前 i间房屋能偷窃到的最高总金额，那么就有如下的状态转移方程：

```
dp[i] = max(dp[i−2]+nums[i],dp[i−1])
```

#### 代码

Java:

```java
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < nums.length; i ++){
            dp[i] = Math.max(dp[i - 1],nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];
    }
}
```

JavaScript:

```javascript
/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    if(nums == null || nums.length == 0){
        return 0
    }
    if(nums.length == 1){
        return nums[0];
    }
    let dp = new Array(nums.length)
    dp[0] = nums[0]
    dp[1] = max(nums[0],nums[1])
    for(let i = 2; i < nums.length; i++){
        dp[i] = max(dp[i - 1],nums[i] + dp[i - 2])
    }
    return dp[nums.length - 1]
};

var max = function(a,b){
    return a >= b ? a : b
}
```



