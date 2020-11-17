func maxSubArray(nums []int) int {
    maxSum := nums[0]
    curSum := 0
    
    for i := 0; i < len(nums); i++ {
        curSum = curSum + nums[i]
        if curSum > maxSum {
            maxSum = curSum
        }
        if curSum <= 0 {
            curSum = 0
        }
    }
    return maxSum
}