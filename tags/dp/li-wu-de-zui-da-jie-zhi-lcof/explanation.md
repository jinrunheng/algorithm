## 剑指 Offer 47. 礼物的最大价值

[剑指 Offer 47. 礼物的最大价值](https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/)

#### 解题思路：动态规划

题目要求：

规定在一个 `m * n `的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。要求我们能够拿到最大的礼物价值。

因为有：

- 每个礼物的价值均大于0
- 只能向右或向下移动

想要拿到礼物的最大值，无论如何，我们都要移动至棋盘的最右下角。

很容易的，我们可以就可以联想到通过动态规划求解该问题。

首先，定义`dp`二维数组，`dp[i][j]` 表示到点`(i,j)`时，能够获得的礼物的最大价值。

所以，结果应当返回`dp[m - 1][n - 1]`。

状态转移方程：

对于第一行和第一列

第一行，只能水平向右移动；第一列，只能垂直向下移动

第一行：

```java
dp[i][0] = dp[i - 1][0] + grid[i][0];
```

第一列：

```java
dp[0][j] = dp[0][j - 1] + grid[0][j];
```

除了这两种需要特殊考虑的情况外：

棋盘的其他位置均满足：

```java
dp[i][j] = Math.max(dp[i - 1][j],dp[i][ j - 1]) + grid[i][j];
```

代码如下

#### 代码

*Java*

```java
class Solution {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for(int j = 1; j < n; j++){
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.max(dp[i - 1][j],dp[i][ j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
```

