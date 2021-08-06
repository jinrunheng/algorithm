class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Stack<int[]> stack = new Stack<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        stack.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > stack.peek()[1])
                stack.push(intervals[i]);
            else {
                int[] pop = stack.pop();
                pop[1] = Math.max(intervals[i][1], pop[1]);
                stack.push(pop);
            }
        }
        int[][] res = new int[stack.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}