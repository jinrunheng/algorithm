class Solution {
    public int bulbSwitch(int n) {
        int res = 1;
        if(n == 1){
            return 1;
        }    
        while(res * res <= n){
            res++;
        }
        return res - 1;
    }
}