func lengthOfLongestSubstring(s string) int {
	res, left, right := 0, 0, 0
	m := make(map[string]int)
	for ; right < len(s); right++ {
		i, contains := m[string(s[right])]
		if contains {
			left = max(left, i+1)
		}
		res = max(res, right-left+1)
		m[string(s[right])] = right
	}
	return res
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}