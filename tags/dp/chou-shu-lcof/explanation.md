## 剑指 Offer 49. 丑数

[剑指 Offer 49. 丑数](https://leetcode-cn.com/problems/chou-shu-lcof/)

#### 解题思路：动态规划

本题是经典的动态规划问题

动态规划大三步：

1. 定义状态转移方程
2. 给定方程初始值
3. 递推实现

`dp`数组的含义为：`dp[i] 表示第i - 1个丑数的值`

方程初始值：`dp[0] = 1;`

状态转移方程：

已知：只包含质因子 2、3 和 5 的数称作丑数

创建三个索引值，分别代表2，3，5的索引

```java
int a = 0; // index of 2
int b = 0; // index of 3
int c = 0; // index of 5
```

状态转移方程如下，并且我们需要时时维护这三个索引值：

```java
dp[i] = Math.min(Math.min(dp[a] * 2,dp[b] * 3),dp[c] * 5);
if(dp[i] == dp[a] * 2) a++;
if(dp[i] == dp[b] * 3) b++;
if(dp[i] == dp[c] * 5) c++;
```

#### 代码

*Java*

```java
class Solution {
    public int nthUglyNumber(int n) {
        // dp[i] 表示第i - 1个丑数的值
        int[] dp = new int[n];
        int a = 0; // index of 2
        int b = 0; // index of 3
        int c = 0; // index of 5
        
        // dp[0] 表示 第1个丑数的值
        dp[0] = 1;

        for(int i = 1; i < n; i++){
            dp[i] = Math.min(Math.min(dp[a] * 2,dp[b] * 3),dp[c] * 5);
            if(dp[i] == dp[a] * 2) a++;
            if(dp[i] == dp[b] * 3) b++;
            if(dp[i] == dp[c] * 5) c++;
        }
        return dp[n - 1];
    }
}
```

