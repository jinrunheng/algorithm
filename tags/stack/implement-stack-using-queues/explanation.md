## 225. 用队列实现栈

[225. 用队列实现栈](https://leetcode-cn.com/problems/implement-stack-using-queues/)

#### 本题考察点：栈与队列的特性，数据结构设计

用两个队列实现栈这种数据结构：

一个队列作为主要存放数据的队列，另一个队列完成辅助的功能操作

```java
Queue<Integer> queue = new LinkedList<>(); // 主要存放数据的队列
Queue<Integer> help = new LinkedList<>(); // 辅助队列
```

- `push(x)`

  `queue.offer(x)`即可

- `pop`

  移除栈顶元素，将`queue`中的元素仅保留一个，其余出队到`help`中；最后`queue`中剩余的元素出队返回即可，返回之前，我们需要调换`queue`与`help`的引用，以维持两个队列各自的功能

- `top`

  获取栈顶元素，将`queue`中的元素仅保留一个，其余出队到`help`中；最后`queue`中剩余的元素出队并记录，返回之前，我们需要调换`queue`与`help`的引用，并将元素重新入队到`queue`中

- `empty`

  判断`queue`是否为空

#### 代码

*Java*

```java
class MyStack {
    private Queue<Integer> queue;
    private Queue<Integer> help;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()){
            throw new RuntimeException("queue is Empty");
        }
        while(queue.size() != 1){
            help.offer(queue.poll());
        }
        int res = queue.poll();
        Queue<Integer> tmp = queue;
        queue = help;
        help = tmp;
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        if(empty()){
            throw new RuntimeException("queue is Empty");
        }
        while(queue.size() != 1){
            help.offer(queue.poll());
        }
        int res = queue.poll();
        Queue<Integer> tmp = queue;
        queue = help;
        help = tmp;
        queue.offer(res);
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
```

