## 用栈实现队列

[232. 用栈实现队列](https://leetcode-cn.com/problems/implement-queue-using-stacks/)

#### 数据结构设计

使用两个栈实现先入先出的队列

其中一个栈作为压入栈：`push_stack`，我们只向这个栈压入数据

另一个栈作为弹出栈：`pop_stack`，这个栈只负责弹出数据

栈作为一种`LIFO`的数据结构，要想实现队列的`pop`与`peek` ，需要定义一个方法，这个方法负责将`push_stack`中的数据全部都倒入`pop_stack`中；

这个方法需要保证两点：

1. 倒入的前提是`pop_stack`中不能有数据
2. 需要将`push_stack`中的所有数据都一次性倒完

该方法如下：

```java
private void pushStackToPopStack(){
    // 如果说pop_stack不为空，则不执行该操作
    if(!pop_stack.isEmpty()){
        return;
    }
    while(!push_stack.isEmpty()){
        pop_stack.push(push_stack.pop());
    }
}
```

该方法执行的时机是随意的，只要满足上述两点即可。

#### 代码

```java
class MyQueue {

    private Stack<Integer> push_stack;
    private Stack<Integer> pop_stack;

    /** Initialize your data structure here. */
    public MyQueue() {
        push_stack = new Stack<>();
        pop_stack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        push_stack.push(x);
        pushStackToPopStack();
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(empty()){
            throw new RuntimeException("queue is empty");
        }
        if(pop_stack.isEmpty()){
            pushStackToPopStack();
        }
        return pop_stack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(empty()){
            throw new RuntimeException("queue is empty");
        }
        if(pop_stack.isEmpty()){
            pushStackToPopStack();
        }
        return pop_stack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(push_stack.isEmpty() && pop_stack.isEmpty()){
            return true;
        }
        return false;
    }

    private void pushStackToPopStack(){
        // 如果说pop_stack不为空，则不执行该操作
        if(!pop_stack.isEmpty()){
            return;
        }
        // 倒入数据要一次性将push_stack的数据倒完
        while(!push_stack.isEmpty()){
            pop_stack.push(push_stack.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
```

