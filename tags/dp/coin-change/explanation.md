## 零钱兑换

[322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)

#### 解题思路：DP

定义dp方程中，dp[i]表示组成金额i所需要的最少的硬币数量；

我们知道

```
coins = [1,2,5] ; amount = 11 
dp[11] = 3

所以自然而然就有：

coins = [1,2,5] ; amount = 12 ; dp[11 + 1] = 4
coins = [1,2,5] ; amount = 13 ; dp[11 + 2] = 4
coins = [1,2,5] ; amount = 16 ; dp[11 + 5] = 4
```

所以，我们可以推理出dp状态转移方程：`dp[i] = min(dp[i - cj]) + 1`

我来解释一下这个状态转移方程是什么意思：

cj代表的意思是第j枚硬币的面值，也就是说，如果dp[i - cj]这个金额存在，那么我们就用这个值加上cj这个硬币的数量1就是dp[i]即，获得金额i所需的硬币数量

来看下示例：

已知：

```
coins = [1,2,5],amount = 11
```

| dp(i)  | 最小硬币数量                                            |
| ------ | ------------------------------------------------------- |
| dp(0)  | 0                                                       |
| dp(1)  | 1 // dp(1) = min(dp(1 - 1),dp(1 - 2),dp(1 - 5)) + 1     |
| dp(2)  | 1 // dp(2) = min(dp(2 - 1),dp(2 - 2),dp(2 - 5)) + 1     |
| dp(3)  | 2 // dp(3) = min(dp(3 - 1),dp(3 - 2),dp(3 - 5)) + 1     |
| dp(4)  | 2 // dp(4) = min(dp(4 - 1),dp(4 - 2),dp(4 - 5)) + 1     |
| ...    | ...                                                     |
| dp(11) | 3 // dp(11) = min(dp(11 - 1),dp(11 - 2),dp(11 - 5)) + 1 |

#### 代码

Java:

```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        // coins = [1,2,5] ; amount = 11 
        // res = 3

        // coins = [1,2,5] ; amount = 12 ; res = 4
        // coins = [1,2,5] ; amount = 13 ; res = 4
        // coins = [1,2,5] ; amount = 16 ; res = 4
        
        // dp[i] 表示 在 amount为 i 时，所需要的最少的硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        

        for(int i = 1; i <= amount; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0 && i - coins[j] <= amount && dp[i - coins[j]] != -1){
                    min = Math.min(min,dp[i - coins[j]] + 1);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];
    }
}
```





