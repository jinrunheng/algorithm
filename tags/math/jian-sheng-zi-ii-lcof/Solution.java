class Solution {
    public int cuttingRope(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        // 绳子按照每段长度为3，共可以分成多少段
        int cutNums = n / 3;
        // 最后的余数
        int r = n % 3;
        long t = 1;
        // 这里不能遍历到 i < cutNums;因为最后要对余数是否为1或2进行处理
        for(int i = 0; i < cutNums - 1; i++){
            t = 3 * t % 1000000007;
        }
        // 如果余数为1，我们就需要将最后分成2+2而不是3+1 所以最后需要乘以4并求余返回
        if(r == 1){
            return (int)(t * 4 % 1000000007);
        }
		// 如果余数为2，我们就需要将最后的结果乘以3*2并求余后返回
        if(r == 2){
            return (int)(t * 6 % 1000000007);
        }
        // 如果能整除3，需要再乘以最后的一段3并求余后返回
        return (int)(t * 3 % 1000000007);
    }
}