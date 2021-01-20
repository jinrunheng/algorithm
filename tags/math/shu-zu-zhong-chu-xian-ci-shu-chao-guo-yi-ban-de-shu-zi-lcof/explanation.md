## 剑指 Offer 39. 数组中出现次数超过一半的数字

[剑指 Offer 39. 数组中出现次数超过一半的数字](https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/)

#### 解题思路一：哈希表

最简单的思路，使用哈希表

遍历数组，存储数组中的数字与数字出现的个数

然后再遍历哈希表，找到`value`超过数组长度一半的那个值即可

复杂度分析：

- 时间复杂度：`O(N)`
- 空间复杂度：`O(N)`

#### 代码

*Java*

```java
class Solution {
    public int majorityElement(int[] nums) {
    
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }else {
                map.put(num,1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > nums.length / 2){
                return entry.getKey();
            }
        }
        return -1;
    }
}
```

#### 解题思路二：排序

题中给定的条件为：**该数字出现的次数超过数组长度的一半**

所以，我们可以对数组进行排序，排序后的数组中点的元素即为我们要的结果

复杂度分析：

- 时间复杂度：`O(NlogN)`
- 空间复杂度：`O(1)`

#### 代码

*Java*

```java
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
```

#### 解题思路三：摩尔投票

知乎回答[【如何理解摩尔投票算法？】](https://www.zhihu.com/question/49973163)

> 核心就是**对拼消耗**。
>
> 玩一个诸侯争霸的游戏，假设你方人口超过总人口一半以上，并且能保证每个人口出去干仗都能一对一同归于尽。最后还有人活下来的国家就是胜利。
>
> 那就大混战呗，最差所有人都联合起来对付你（对应你每次选择作为计数器的数都是众数），或者其他国家也会相互攻击（会选择其他数作为计数器的数），但是只要你们不要内斗，最后肯定你赢。
>
> 最后能剩下的必定是自己人。
>
> 
>
> 作者：胡新辰
> 链接：https://www.zhihu.com/question/49973163/answer/617122734
> 来源：知乎
> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

摩尔投票的核心就是“对拼消耗”，或者说票数正负抵消。

将数组中出现次数超过一半的数字定位“正票”，其余的数字都是“负票”；通过抵消，最后剩余的一定是“正票”

附上**Krahets**大神的[题解]( https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/)，相信大家看完这篇题解就完全理解代码思路了。

复杂度分析：

- 时间复杂度：`O(N)`
- 空间复杂度：`O(1)`

#### 代码

*Java*

```java
class Solution {
    public int majorityElement(int[] nums) {
        int x = 0;
        int votes = 0;
        for(int num : nums){
            if(votes == 0){
                x = num;
            }
            if(num != x){
                votes--;
            }else {
                votes++;
            }
        }
        return x;
    }
}
```



