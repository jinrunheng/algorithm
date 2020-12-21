## 剑指 Offer 59 - II. 队列的最大值

[剑指 Offer 59 - II. 队列的最大值](https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/)

#### 解题思路：维护一个单调递减的双端队列

本题与[239. 滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)一题的思路上实则是一致的。

题目要求：定义队列，并实现函数`max_value`;要求这个函数可以时时得到队列的最大值，并且要求`max_value`，`push_back`,`pop_front`每种方法的均摊时间复杂度为*O(1)*

实现方法：维护一个普通的队列，以及一个单调递减的双端队列。

普通的队列，完成正常的数据进队，出队操作。

双端队列，则时时维护队列的最大值：这个双端队列的队首为队列的最大值。



实现数据结构的方法分析：

**获取队列最大值**

- 单调递减的双端队列队首为当前队列中的最大值

**入队操作**

- 普通队列执行入队操作
- 双端队列如果不为空，并且队尾的元素要小于`value`,我们就让双端队列队尾元素一直出队，直至满足队尾元素大于等于`value`的状态

**出队操作**

- 普通队列执行正常的出队操作
- 出队的元素与双端队列队首进行比较，如果相等，说明双端队列队首元素过期，则出队；否则没有过期，队首仍然为当前队列中的最大元素

#### 代码

*Java*

```java
class MaxQueue {
    private Queue<Integer> data;
    // 维护一个单调递减的双端队列
    private Deque<Integer> max;

    public MaxQueue() {
        data = new LinkedList<>();
        max = new LinkedList<>();
    }
    
    public int max_value() {
        if(data.isEmpty()){
            return -1;
        }
        return max.peekFirst();
    }
    
    public void push_back(int value) {
        data.offer(value);
        while(!max.isEmpty() && max.peekLast() < value){
                max.pollLast();
            }
        max.addLast(value);
    }
    
    public int pop_front() {
        if(data.isEmpty()){
            return -1;
        }
        int value = data.poll();
        if(max.peekFirst().equals(value)){
            max.pollFirst();
        }
        return value;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
```

