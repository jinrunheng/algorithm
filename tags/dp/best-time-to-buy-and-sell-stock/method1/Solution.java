class Solution {
    public int maxProfit(int[] prices) {
        // 维护一个单调递减栈
        // 假设能获取的最大利润为max
        // 如果当前元素比栈顶小则入栈
        // 如果当前元素比栈顶大，则计算prices[cur] - stack.peek()的值，并时时更新max
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            if(stack.isEmpty()){
                stack.push(prices[i]);
            }else {
                if(prices[i] < stack.peek()){
                    stack.push(prices[i]);
                }else {
                    max = Math.max(max,prices[i] - stack.peek());
                }
            }
        }
        return max;
    }
}