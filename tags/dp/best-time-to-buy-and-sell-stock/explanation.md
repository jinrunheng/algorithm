## 买卖股票的最佳时机

[121. 买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)

#### 解题思路一：单调递减栈

维护一个单调递减栈

假设能获取的最大利润为`max`,遍历数组`prices`

如果当前元素比栈顶小则入栈

如果当前元素比栈顶大，则计算`prices[cur] - stack.peek()`的值，并时时更新`max`

#### 代码

*Java*

```java
class Solution {
    public int maxProfit(int[] prices) {
        // 维护一个单调递减栈
        // 假设能获取的最大利润为max
        // 如果当前元素比栈顶小则入栈
        // 如果当前元素比栈顶大，则计算prices[cur] - stack.peek()的值，并时时更新max
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            if(stack.isEmpty()){
                stack.push(prices[i]);
            }else {
                if(prices[i] < stack.peek()){
                    stack.push(prices[i]);
                }else {
                    max = Math.max(max,prices[i] - stack.peek());
                }
            }
        }
        return max;
    }
}
```

#### 解题思路二：动态规划

动态规划三大步：

1. 定义状态转移方程
2. 给定方程初始值
3. 递推实现

首先我们规定`dp`方程：

1. `dp[i][0] `表示:第`i`天结束之后，当前持股时，持有的最大利润
2. `dp[i][1] `表示:第`i`天结束之后，当前不持股，持有的最大利润

状态转移方程:

` dp[i][0]`: 第`i`天结束之后，当手中持有股份，情况有二：

- 第`i - 1`天，手中没有股份，第`i`天买入；所以持有的当前利润为 `-prices`（因为只能买入和卖出一次，所以买入以后，手中的利润就变为了`-prices`）
- 第`i - 1`天，手中持有股份，第`i`天什么也不做

所以，我们可以得到关于`dp[i][0]`的方程为：

```java
dp[i][0] = max(-prices[i],dp[i - 1][0])
```

`dp[i][1]`:第`i`天结束之后，当手中没有股份，情况有二：

- 第`i - 1`天，手中有股份，第`i`天卖出
- 第`i - 1`天，手中没有股份，第`i`天什么也不做

所以，`dp[i][1]`的状态转移方程为:

```java
dp[i][1] = max(dp[i - 1][0] + prices[i],dp[i - 1][1])
```

最后，我们要返回的值为不持股的状态（无论是否有购买过，最后一定是不持股的状态）;最终返回:

```java
dp[prices.length - 1][1]
```

#### 代码

*Java*

```java
class Solution {
    public int maxProfit(int[] prices) {
        // 规定dp方程
        // dp[i][0] 表示:第i天结束之后，当前持股时，持有的最大利润
        // dp[i][1] 表示:第i天结束之后，当前不持股，持有的最大利润
        
        // 状态转移方程:
        // dp[i][0]:第i天结束之后，当前持股时，持有的最大利润
        // 第i天结束之后，当手中持有股份，情况有二：
        // 1. 第i - 1天，手中没有股份，第i天买入；所以持有的金额为 -prices
        // 2. 第i - 1天，手中持有股份，第i天什么也不做
        // 所以，dp[i][0]的状态转移方程为:
        // dp[i][0] = max(-prices[i],dp[i - 1][0])

        // dp[i][1]:第i天结束之后，手中没有股份，持有的最大利润
        // 第i天结束之后，当手中没有股份，情况有二：
        // 1. 第i - 1天，手中有股份，第i天卖出
        // 2. 第i - 1天，手中没有股份，第i天什么也不做
        // 所以，dp[i][1]的状态转移方程为:
        // dp[i][1] = max(dp[i - 1][0] + prices[i],dp[i - 1][1])

        // 最后返回不持股的状态：return dp[prices.length - 1][1]
        if(prices == null || prices.length == 0){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(-prices[i],dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i],dp[i - 1][1]);
        }

        return dp[prices.length - 1][1];
    }
}
```

