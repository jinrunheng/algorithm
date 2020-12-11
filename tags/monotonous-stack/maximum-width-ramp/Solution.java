class Solution {
    public int maxWidthRamp(int[] A) {
        // 单调栈
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < A.length; i++){
            if(stack.isEmpty() || A[stack.peek()] > A[i]){
                stack.push(i);
            }
        }

        int res = 0;
        for(int i = A.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && A[stack.peek()] <= A[i]){
                res = Math.max(res,i - stack.pop());
            }
        }
        return res;
    }
}