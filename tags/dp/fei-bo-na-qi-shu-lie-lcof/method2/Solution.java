class Solution {
    public int fib(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        // dp[i] 表示 斐波那契数列的第i项
        // dp[i] = dp[i - 1] + dp[i - 2]
        // 最终返回的结果为:dp[n]
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i < n + 1; i++){
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007 ;
        }
        return dp[n];
    }
}