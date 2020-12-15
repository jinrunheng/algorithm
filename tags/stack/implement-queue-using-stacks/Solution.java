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
        if(!pop_stack.isEmpty()){
            return;
        }
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