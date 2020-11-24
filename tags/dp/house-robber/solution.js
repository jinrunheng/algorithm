/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    if(nums == null || nums.length == 0){
        return 0
    }
    if(nums.length == 1){
        return nums[0];
    }
    let dp = new Array(nums.length)
    dp[0] = nums[0]
    dp[1] = max(nums[0],nums[1])
    for(let i = 2; i < nums.length; i++){
        dp[i] = max(dp[i - 1],nums[i] + dp[i - 2])
    }
    return dp[nums.length - 1]
};

var max = function(a,b){
    return a >= b ? a : b
}