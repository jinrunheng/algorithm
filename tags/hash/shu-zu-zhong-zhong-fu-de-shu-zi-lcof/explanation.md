## 剑指 Offer 03. 数组中重复的数字

题目链接：[剑指 Offer 03. 数组中重复的数字](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/)

#### 解题思路：哈希表

本题只需要我们返回数组中任意一个重复的数字即可，根据题目的特点，我们自然很快就会想到使用哈希表这种数据结构来解决本题。

*Java* 语言中，提供了 *HashSet* ，在 *HashSet* 中只能存储不重复的对象 。

算法流程：

1. 初始化 *HashSet* 
2. 遍历数组 *nums* 中的每个数字 *num*
   1. 如果 *num* 已经存在于集合中，说明重复，直接返回 *num*
   2. 否则将 *num* 添加至集合中
3. 遍历到最后，如果没有重复元素，可返回任意数字，在这里我们记为返回 *-1*

#### 代码

*Java*

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return nums[i];
            }else {
                set.add(nums[i]);
            }
        }
        return -1;
    }
}
```

#### 复杂度分析

- 时间复杂度：*O(N)*

  遍历数组的时间复杂度为：*O(N)*，*HashSet* 的添加与查找均为 *O(1)* 的时间复杂度

- 空间复杂度：*O(N)*

  *HashSet* 占用 *O(N)* 的额外空间