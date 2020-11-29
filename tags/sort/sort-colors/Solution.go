package sort_colors

func sortColors(nums []int)  {
	less := -1
	more := len(nums)
	cur := 0
	for cur  < more{
		if nums[cur] == 0 {
			less++
			nums[cur], nums[less] = nums[less], nums[cur]
			cur++
		} else if nums[cur]  == 2 {
			more--
			nums[cur], nums[more] = nums[more], nums[cur]
		}else {
			cur++
		}
	}
}