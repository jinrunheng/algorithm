class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for(int i = 2; i <= n; i++){
            int res = 0;
            for(int j = 1; j < i; j++){
                res = Math.max(res,Math.max(j * (i - j),j * dp[i - j]));
            }
            dp[i] = res;
        }
        return dp[n];
    }
}

