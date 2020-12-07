## 使用最小花费爬楼梯

[746. 使用最小花费爬楼梯](https://leetcode-cn.com/problems/min-cost-climbing-stairs/)

#### 解题思路：

由题目可以得：第i级阶梯的总花费等于第i级的花费加上 前两级阶梯的总花费的较小者

我们可以得到动态转移方程为：

```
dp[i] = cost[i] + min(dp[i - 1],dp[i - 2])
```

其中`dp[i]`代表到达第i层台阶所需要的最小花费体力

所以`dp[0] = cost[0];dp[1] = cost[1]`

最终我们要返回的值就是`Math.min(dp[dp.length-1],dp[dp.length-2])`

#### 代码 

Java:

```java
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        // dp[i] 表示 到达第i个台阶 总共耗费的体力值
        dp[0] = cost[0];
        dp[1] = cost[1];
        // dp[2] = Math.min(cost[0],cost[1]);
        for(int i = 2; i < cost.length; i++){
            dp[i] = Math.min(dp[i - 1],dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1],dp[cost.length - 2]); 
    }
}
```

