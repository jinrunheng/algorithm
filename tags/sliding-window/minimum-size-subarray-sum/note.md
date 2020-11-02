## 长度最小的子数组

给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。

 

示例：

```
输入：s = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。
```



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum

#### 思路：滑动窗口

使用两个变量:`start`,`end`用来表示窗口的起始位置和结束位置

使用一个变量`sum`用来记录窗口数值的总和

算法流程如下：

- 初始状态下`start`和`end`都指向数组的下标0；遍历数组，使用`sum`维护当前窗口的总和
- 每一轮的迭代，都将`nums[end]`加到sum中，如果`sum >= s`,那么就更新最小长度值 `res = min(res,end-start+1)`,然后将`nums[start]`从sum中减去并将`start`右移，直到`sum < s`
- 每一轮迭代结束后`end++`

#### 代码：

##### Java

```java
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
```



##### Go

```go
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
```



