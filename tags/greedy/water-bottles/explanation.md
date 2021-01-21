## 1518. 换酒问题

[1518. 换酒问题](https://leetcode-cn.com/problems/water-bottles/)

#### 解题思路：贪心算法

贪心思路：

`numBottles`表示购买的酒数量

`numExchange`表示喝掉`numExchange`瓶酒就可以兑换一瓶新的酒

所以，可以每次喝掉`numExchange`瓶酒后，就立刻去兑换一瓶

这样就是最多能喝到多少瓶酒的方案

#### 代码

*Java*

```java
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        // 喝掉numExchange瓶酒后就去兑换
        while(numBottles >= numExchange){
            numBottles = numBottles - numExchange + 1;
            total++;
        }
        return total;
    }
}
```

