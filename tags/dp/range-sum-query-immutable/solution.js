/**
 * @param {number[]} nums
 */
var dp = new Array();
var NumArray = function(nums) {
    if(nums.length > 0){
        dp[0] = nums[0]
        for(let i = 1; i < nums.length; i++){
            dp[i] = dp[i - 1] + nums[i]
        }
    }
};

/** 
 * @param {number} i 
 * @param {number} j
 * @return {number}
 */
NumArray.prototype.sumRange = function(i, j) {
    if(i == 0){
        return dp[j];
    }
    return dp[j] - dp[i - 1]
};

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * var param_1 = obj.sumRange(i,j)
 */