class Solution {
    public int numWaterBottles(int numBottles, int numExchange){
        int res = numBottles;
        int left = 0;
        while(numBottles != 0){
            left += left(numBottles,numExchange);
            if(left >= numExchange){
                left = left - numExchange;
                numBottles = exchange(numBottles,numExchange) + 1;
            }else {
                numBottles = exchange(numBottles,numExchange);
            }
            res += numBottles;
        }
        return res;
    }

    // 手头还剩下多少个空瓶子
    private static int left(int numBottles,int numExchange){
        return numBottles % numExchange;
    }

    // 可以兑换多少瓶酒
    private static int exchange(int numBottles,int numExchange){
        return numBottles / numExchange;
    }
}