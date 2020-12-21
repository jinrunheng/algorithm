class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0){
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int resIndex = 0;
        for(int i = 1 - k,j = 0; j < nums.length; i++,j++){
            // 判断队首是否过期
            if(i > 0 && nums[i - 1] == deque.peekFirst()){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[j]){
                deque.pollLast();
            }
            deque.addLast(nums[j]);
            if(i >= 0){
                res[resIndex++] = deque.peekFirst();
            }
        }
        return res;
    }
}