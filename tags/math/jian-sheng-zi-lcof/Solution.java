class Solution {
    public int cuttingRope(int n) {
        // 剪绳子的策略：
        // 尽可能将绳子以长度 3 等分为多段时，乘积最大。
        // 如果最后余1，我们需要将最后一段分为 2 + 2 而不是 3 + 1; 因为 2 * 2 > 3 * 1
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        if(n % 3 == 1){
            return (int) Math.pow(3, n / 3 - 1) * 4;
        }else if(n % 3 == 2){
            return (int) Math.pow(3,n / 3) * 2;
        }else {
            return (int) Math.pow(3, n / 3);
        }
    }
}