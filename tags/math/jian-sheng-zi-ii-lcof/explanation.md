## 剑指 Offer 14- II. 剪绳子 II

[剑指 Offer 14- II. 剪绳子 II](https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/)

#### 解题思路：数学

本题和[剑指 Offer 14- I. 剪绳子](https://leetcode-cn.com/problems/jian-sheng-zi-lcof/)唯一的不同点是：本题的n的取值范围增加到了`2 <= n <= 1000`；

#### 代码

*Java*

```java
class Solution {
    public int cuttingRope(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int cutNums = n / 3;
        int r = n % 3;
        long t = 1;
        for(int i = 0; i < cutNums - 1; i++){
            t = 3 * t % 1000000007;
        }
        if(r == 1){
            return (int)(t * 4 % 1000000007);
        }
        if(r == 2){
            return (int)(t * 6 % 1000000007);
        }
        return (int)(t * 3 % 1000000007);
    }
}
```

