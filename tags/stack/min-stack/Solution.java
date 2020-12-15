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