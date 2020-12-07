class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        // dp[i] 表示 到达第i个台阶 总共耗费的体力值
        dp[0] = cost[0];
        dp[1] = cost[1];
        // dp[2] = Math.min(cost[0],cost[1]);
        for(int i = 2; i < cost.length; i++){
            dp[i] = Math.min(dp[i - 1],dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1],dp[cost.length - 2]); 
    }
}