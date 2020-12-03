## 整数拆分

[343. 整数拆分](https://leetcode-cn.com/problems/integer-break/)

#### 解题思路：DP

对于dp状态转移方程定义：`dp[i]`为正整数`i`拆分成至少两个正整数的和之后，这些正整数乘积的最大值。

对于正整数，当`n >= 2`时，可以拆分成至少是两个正整数的和。令`k`为拆分出的第一个正整数，那么剩下的部分`n - k` 有两种选择

1. `n-k` 不继续拆分，此时的乘积为:`k * (n - k)`
2. `n - k` 继续拆分，此时的乘积为:`k * dp(n - k)`

所以，我们有：

```
for(int k = 1; k < n; k++){
     max = Math.max(max,Math.max(k * (n - k), k * dp(n - k)))  
}
dp[n] = max;
```

#### 代码

```java
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for(int i = 2; i <= n; i++){
            int res = 0;
            for(int j = 1; j < i; j++){
                res = Math.max(res,Math.max(j * (i - j),j * dp[i - j]));
            }
            dp[i] = res;
        }
        return dp[n];
    }
}
```



