## 剑指 Offer 10- II. 青蛙跳台阶问题

[剑指 Offer 10- II. 青蛙跳台阶问题](https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/)

#### 解题思路：动态规划

动态规划三大步：

1. 定义状态转移方程
2. 给定方程初始值
3. 递推实现

首先，定义`dp`数组；`dp[i]` 表示 跳上第`i`级台阶共有多少种跳法

状态转移方程：

跳上第`i`级台阶的跳法有两种情况：

1. 跳到第`i - 1`级台阶后再跳1级台阶
2. 跳到第`i - 2`级台阶后再跳2级台阶

所以，可以确定状态转移方程为:

```
dp[i] = dp[i - 1] + dp[i - 2]
```

确定初始值:

```
dp[0] = 1
dp[1] = 1
```

#### 代码

*Java*

```java
class Solution {
    public int numWays(int n) {
        // 动态规划
        // dp[i] 表示 跳上第i级台阶共有多少种跳法
        // 状态转移方程:
        // dp[i] = dp[i - 1] + dp[i - 2]
        // dp初始值:
        // dp[0] = 1
        // dp[1] = 1 跳上第1级台阶只有一种跳法
        // dp[2] = 2 跳上第2级台阶有两种跳法：1. 每次跳1级；2. 直接跳2级
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n + 1; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
```

