## 最小栈

[155. 最小栈](https://leetcode-cn.com/problems/min-stack/)

#### 解题思路：维护一个数据栈和一个最小栈

维护一个数据栈：`data`，数据栈用来保存数据，和正常的栈没有区别；

另外维护一个“最小栈”：`minStack`,`minStack` 用来时时更新栈内最小值。

- `push`

  - `data`

    数据栈执行正常的`push`操作

  - `minStack`

    假设当前的数据为`num`,首先判断`minStack`是否为空，如果为空，则直接执行`minStack.push(num)`；如果`minStack`不为空，则比较新的元素`num`和`minStack.peek()`的大小，哪一个小就将哪一个压入到`minStack`中

- `pop`

  - `data`

    数据栈执行正常的`pop`操作

  - `minStack`

    最小栈执行正常的`pop`操作

- `top`

  - `data`

    返回`data.peek()`

- `getMin`

  - `minStack`

    返回`minStack.peek()`

#### 代码

```java
class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        this.data = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int x) {   
        data.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }else {
            if(minStack.peek() < x){
                minStack.push(minStack.peek());
            }else {
                minStack.push(x);
            }
        }
    }
    
    public void pop() {
        data.pop();
        minStack.pop();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {   
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```





