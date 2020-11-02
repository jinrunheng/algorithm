class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        // sliding window
        int start = 0;
        int end = 0;

        int sum = 0;
        int res = Integer.MAX_VALUE;

        while(end < nums.length){
            sum += nums[end];
            while(sum >= s){
                res = Math.min(res,end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}