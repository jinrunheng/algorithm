## 不同路径

[62. 不同路径](https://leetcode-cn.com/problems/unique-paths/)

#### 解题思路：DP

![image-20201125221829177](https://tva1.sinaimg.cn/large/0081Kckwgy1gl1s4uuuzpj30ma0a6q5j.jpg)

我们要获得机器人从左上角到右下角共有多少路径，创建dp二维数组，`dp[i][j]` 表示从`[0,0] ~ [i,j]` 共有多少种路径；

1. 当`i == 0`  ; 由于机器人只有向右走这一种走法，所以在`i == 0` 的情况下，`dp[i][j] == 1`
2. 当`j == 0` ; 由于机器人只有向左走这一种走法，所以在`j == 0` 的情况下，`dp[i][j] == 1`
3. 其他位置，则满足方程`dp[i][j] = dp[i - 1][j] + dp[i][j - 1];`

构建好的dp数组为:



![image-20201125221726255](https://tva1.sinaimg.cn/large/0081Kckwgy1gl1s42ippsj30m40a4n0g.jpg)

#### 代码

```java
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1){
            return 1;
        }
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] +  dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
```

