class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // [2,1,5] -> 在 1 上车,在 5 下车
        int[] counters = new int[1001];
        for(int[] trip : trips){
            counters[trip[1]] += trip[0];
            counters[trip[2]] -= trip[0];
        }
        for(int i = 1; i < counters.length; i++){
            counters[i] += counters[i - 1];
            if(counters[i] > capacity ){
                return false;
            }
        }
        return true;
    }
}