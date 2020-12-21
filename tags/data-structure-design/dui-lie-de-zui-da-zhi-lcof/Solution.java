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