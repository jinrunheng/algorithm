## 最小路径和

[64. 最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)

#### 解题思路：DP

看到路径问题，我本能地想到了动态规划

创建二维DP数组：

```java
int[][] dp = new int[grid.length][grid[0].length];
```

`dp[i][j]`表示，走到`grid[i][j]` 所需要的最小路径

示例：

**grid**

```
1 3 1
1 5 1
4 2 1
```

我们不难发现，`dp[0][0] = grid[0][0]` 在本示例中为 1

对于dp数组的第一行,由于每次只能向右移动，所以dp数组的第一行可以表示为：

```java
for(int i = 1; i < grid.length; i++){
    dp[i][0] = dp[i - 1][0] + grid[i][0];
}
```

对于dp数组的第一列，由于每次向右移动，所以dp数组的第一列可以表示为：

```java
for(int i = 1; i < grid[0].length; i++){
    dp[0][i] = dp[0][i - 1] + grid[0][i];
}
```

由此我们的dp数组目前构建为：

```
1 4 5
2 * *  
6 * *  
```

对于dp数组其他位置的情况，满足：

```JAVA
dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + grid[i][j];
```

由此，我们就可以构建好整个dp

**dp**

```
1 4 5
2 7 6  
6 8 7  
```

最终我们只需要返回：`dp[dp.length - 1][dp[0].length - 1]` 就是从网格左上角移动到右下角的最小路径和

#### 代码

Java

```java
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < grid[0].length; i++){
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
```

