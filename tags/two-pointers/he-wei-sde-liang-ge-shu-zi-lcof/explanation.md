## 剑指 Offer 57. 和为s的两个数字

[剑指 Offer 57. 和为s的两个数字](https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/)

#### 解题思路：双指针

题目给定的条件是数组是按递增排序的

我们可以使用双指针的思路，维护两个指针`i`,`j`分别维护数组的首和尾

在`i < j`的条件范围内，计算`nums[i]`与`nums[j]`的和`sum`

- `sum < target`；说明当前两数之和小于`target`，`i`指针应该向后移动
- `sum > target`；说明当前两数之和大于`target`，`j`指针应该向前移动
- `sum == target`；因为题目要求输出任意一对符合条件的结果，所以当`sum == target`返回`nums[i]`，`nums[j]`数组即可

代码如下

#### 代码

*Java*

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 双指针
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum < target){
                i++;
            }else if(sum > target){
                j--;
            }else{
                return new int[]{nums[i],nums[j]};
            }
        }
        return new int[0];
    }
}
```

