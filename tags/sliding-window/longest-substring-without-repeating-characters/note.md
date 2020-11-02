## 无重复字符的最长字串

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

```
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```

示例 2:

```
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```

示例 3:

```
输入: "pwwkew"
输出: 3
```

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters

#### 题解

滑动窗口

滑动窗口的本质就是一种队列，例如对于示例给出的“pwwkew”。“pw”进入到队列是符合要求的，但是，当再进入下一个字符“w”的时候，队列就变成了“pww”，这时候就不满足窗口的要求，所以需要滑动这个窗口。

如何滑动窗口？

我们只需要将窗口队列左边的元素移出即可，直至满足窗口的要求。

对于滑动窗口的题目，我习惯使用两个变量来维护窗口，确保窗口能够满足条件。一般可以叫做start，end或者是left，right；而滑动窗口题目的核心就是如何去维护这两个变量。

#### 代码

##### Java

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        // map中存储的key为字符串对应的每个字符,value存储的为该字符在字符串中的索引
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right < s.length()){
            if(map.containsKey(s.charAt(right))){
                // 更新left
                left = Math.max(left,map.get(s.charAt(right)) + 1);
            }
            res = Math.max(res,right - left + 1);
            map.put(s.charAt(right),right);
            right++;
        }
        return res;
    }
}
```

##### Go

```go
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
```

