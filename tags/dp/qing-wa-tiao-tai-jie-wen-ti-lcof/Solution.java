class Solution {
    public int numWays(int n) {
        // 动态规划
        // dp[i] 表示 跳上第i级台阶共有多少种跳法
        // 状态转移方程:
        // dp[i] = dp[i - 1] + dp[i - 2]
        // dp初始值:
        // dp[0] = 1
        // dp[1] = 1 跳上第1级台阶只有一种跳法
        // dp[2] = 2 跳上第2级台阶有两种跳法：1. 每次跳1级；2. 直接跳2级
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n + 1; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}