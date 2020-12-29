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