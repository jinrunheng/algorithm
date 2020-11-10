class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        int[] seconds = new int[60];
        for(int t : time){
            seconds[t % 60]++;
        }
        res += (seconds[30]) * (seconds[30] - 1) / 2;
        res += (seconds[0]) * (seconds[0] - 1) / 2;
        int i = 1,j = 59;
        while(i < j){
            res += seconds[i++] * seconds[j--];
        }
        return res;
    }
}