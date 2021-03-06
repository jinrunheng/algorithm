## 剑指 Offer 65. 不用加减乘除做加法

[剑指 Offer 65. 不用加减乘除做加法](https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/)

#### 解题思路：位运算

本题考查位运算的灵活运用

| a    | b    | 无进位和 | 进位 |
| ---- | ---- | -------- | ---- |
| 0    | 0    | 0        | 0    |
| 0    | 1    | 1        | 0    |
| 1    | 0    | 1        | 0    |
| 1    | 1    | 0        | 1    |

我们可以发现，无进位和的结果和**异或运算**的规律相同

进位运算和**与运算**规律相同

`a + b`的和实际上为 **进位左移一位** + **无进位和** 

分析到这里，我们就基本明确代码思路了

复杂度分析：

- 时间复杂度：**O(1)**，最差情况，我们需要遍历一个`int`型数字的位数长度(32位)
- 空间复杂度：**O(1)**

#### 代码

*Java*

```java
class Solution {
    public int add(int a, int b) {
        while(b != 0){
            int c = (a & b) << 1;
            a ^= b;
            b = c; 
        }
        return a;
    }
}
```

