func minSubArrayLen(s int, nums []int) int {
	var start = 0
	var end = 0

	var res = int(^uint(0) >> 1)
	var sum = 0

	for end < len(nums) {
		sum += nums[end]
		for sum >= s {
			res = min(res, end-start+1)
			sum -= nums[start]
			start++
		}
		end++
	}
    if res == int(^uint(0) >> 1) {
        res = 0;
    }
	return res
}

func min(a int, b int) int {
	if a < b {
		return a
	}
	return b
}