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