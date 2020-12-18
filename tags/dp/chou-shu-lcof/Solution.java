class Solution {
    public int nthUglyNumber(int n) {
        // dp[i] 表示第i - 1个丑数的值
        int[] dp = new int[n];
        int a = 0; // index of 2
        int b = 0; // index of 3
        int c = 0; // index of 5
        
        // dp[0] 表示 第1个丑数的值
        dp[0] = 1;

        for(int i = 1; i < n; i++){
            dp[i] = Math.min(Math.min(dp[a] * 2,dp[b] * 3),dp[c] * 5);
            if(dp[i] == dp[a] * 2) a++;
            if(dp[i] == dp[b] * 3) b++;
            if(dp[i] == dp[c] * 5) c++;
        }
        return dp[n - 1];
    }
}