## 剑指 Offer 14- I. 剪绳子

[剑指 Offer 14- I. 剪绳子](https://leetcode-cn.com/problems/jian-sheng-zi-lcof/)

#### 解题思路：数学

本题要求将绳子剪成可以构造出最大乘积的多段

因为数学推导公式比较复杂，在这里就不予证明了;具体的证明方法可以查看leetcode的一篇[题解](https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/)

推导结果：

- 当所有绳段长度相等时，乘积最大
- 最优的绳段长度为3

所以我们的策略为：

1. 尽可能地将绳子以长度为3等分成多段时，乘积最大
2. 如果最后余1我们需要将最后一段分为 `2 + 2 `而不是` 3 + 1`; 因为 `2 * 2 > 3 * 1`

#### 代码

*Java*

```java
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
```

