class Solution {
    public int maxProfit(int[] prices) {
        // dp[i][0] : 第i天结束之后，持有股票时，手里持有的最大利润；因为手里持有股票，还没有卖，所以一定不在冷冻期
        // dp[i][1] : 第i天结束之后，不持有股票时，且在冷冻期时，手里持有的最大利润
        // dp[i][2] : 第i天结束之后，不持有股票时，且不在冷冻期时，手里持有的最大利润

        // 第i天结束之后持有股票时，有两种情况：
        // 第i - 1天也持有股票，第i天什么也不做
        // 第i - 1天不持有股票，且不在冷冻期，在第i天买入股票，花费金额price[i]
        // dp[i][0] = max(dp[i - 1][0],dp[i - 1][2] - prices[i])
         

        // 第i天结束之后不持有股票，且在冷冻期时，只有一种情况，就是第i - 1天持有股票并在第i天卖出
        // dp[i][1] = dp[i - 1][0] + prices[i]

        // 第i天结束之后不持有股票，且不在冷冻期时，有两种情况：
        // 第i - 1天 也不持有股票，且不在冷冻期
        // 第i - 1天 为冷冻期
        // dp[i][2] = max(dp[i - 1][2],dp[i - 1][1])

        // 最后返回的结果值一定为手中没有股票的情况
        if(prices == null || prices.length == 0){
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        // 初始化dp
        dp[0][0] = 0 - prices[0];
        dp[0][1] = 0;  
        dp[0][2] = 0;

        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2],dp[i - 1][1]);
        }
        return Math.max(dp[prices.length - 1][1],dp[prices.length - 1][2]);

    }
}