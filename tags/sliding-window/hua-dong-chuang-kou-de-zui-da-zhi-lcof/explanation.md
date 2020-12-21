## 剑指 Offer 59 - I. 滑动窗口的最大值

[剑指 Offer 59 - I. 滑动窗口的最大值](https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/)

#### 解题思路：滑动窗口

最简单的思路：

使用一个队列；

遍历数组

在队列的`size`没有达到`k`时，一直向队列添加数据；

当超出`k`值时，队首出队一个元素，队尾添加一个元素，每次都算出队列中的最大值

可想而知，这个算法的时间复杂度为: *O(NK)*

本思路代码如下：

*Java*

```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int resIndex = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            if(i < k){
                queue.offer(nums[i]);
                if(i == k - 1){
                    res[resIndex++] = getQueueMax(queue);
                }
            }else {
                queue.poll();
                queue.offer(nums[i]);
                res[resIndex++] = getQueueMax(queue);
            }
        }
        return res;
    }

    private static int getQueueMax(Queue<Integer> queue){
        int max = Integer.MIN_VALUE;
        Iterator<Integer> iterator = queue.iterator();
        while(iterator.hasNext()){
            max = Math.max(max,iterator.next());
        }
        return max;
    }
}
```

本题目的重难点是如何将获取队列中最大值的操从 *O(k)* 优化至 *O(1)*

优化思路：维护一个单调递减的双端队列

首先我们初始化一个双端队列`deque`，然后用`i`,`j`这两个变量分别维护队列的左边界和右边界;定义返回数组`res`

可以计算出，队列的左边界范围为`[i - k,n - k + 1]`;队列的右边界范围为`[0, n - 1]`

算法流程：

遍历数组：

```java
for(int i = 1 - k, j = 0;j < nums.length; i++,j++){
    // do sth...
}
```



时时维护这个双端队列，保证队列为单调递减的，如果队列尾的元素大于当前遍历的元素，则进队列；否则就一直将队列尾部元素出队，直至满足条件：

```java
while(!deque.isEmpty() && deque.peekLast() < nums[j]){
    deque.pollLast();
}
```

什么时候记录返回数组的值？

当我们的左边界`i >= 0`的时候，说明滑动窗口已经滑动到了有效位置，这个时候，我们记录队首的元素即可；因为队列为单调递减队列，所以，队首的元素就是窗口的最大值

```java
if(i >= 0){
    res[resIndex++] = deque.peekFirst();
}
```

验证，队首元素是否有效：

我们需要判断队首元素是否“过期”。

首先，左边界只有大于0，才会出现队首元素过期的情况；当我们维护的窗口的左边的位置(`i - 1`)和队首元素相等，则说明队首元素已经不在窗口内了，我们就需要将队首这个过期的元素移除

```java
if(i > 0 && deque.peekFirst() == nums[i - 1]){
    // 表示过期
    deque.pollFirst();
}
```

#### 代码

*Java*

```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int resIndex = 0;
        // 使用变量i,j分别维护窗口的左边界和右边界
        for (int i = 1 - k, j = 0; j < nums.length; i++, j++) {
            if(i > 0 && deque.peekFirst() == nums[i - 1]){
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.pollLast();
            }
            deque.addLast(nums[j]);
            if (i >= 0) {
                res[resIndex++] = deque.peekFirst();
            }
        }
        return res;
    }
}
```

这样，我们将整体算法的时间复杂度提升到了*O(N)*

