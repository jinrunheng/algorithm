class Solution {
    public int majorityElement(int[] nums) {
        int x = 0;
        int votes = 0;
        for(int num : nums){
            if(votes == 0){
                x = num;
            }
            if(num != x){
                votes--;
            }else {
                votes++;
            }
        }
        return x;
    }
}