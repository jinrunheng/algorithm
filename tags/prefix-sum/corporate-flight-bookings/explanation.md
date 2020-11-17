## 前缀和问题

### 1. 拼车

[1094. 拼车](https://leetcode-cn.com/problems/car-pooling/)

#### 思路

我们使用一个`counters`数组用来记录到达每个目的地的人数变化，例如`counters[1]`代表在目的地1处出租车上人数发生的变化，因为题目中有给定条件`0 <= trips[i][1] < trips[i][2] <= 1000`,所以目的地最远不会超过1000，声明一个长度为1001的数组即可。

1. 遍历`trips`数组
2. 遍历过程中，增加的人数可以表示为：`counters[trip[1]] += trip[0]`
3. 遍历过程中，减少的人数可以表示为：`counters[trip[2]] -= trip[0]`
4. 最后遍历`counters`数组，计算在每个目的地时，出租车上面的人数，如果大于`capacity`则返回`false`

#### 代码

```java
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // [2,1,5] -> 在 1 上车,在 5 下车
        int[] counters = new int[1001];
        for(int[] trip : trips){
            counters[trip[1]] += trip[0];
            counters[trip[2]] -= trip[0];
        }
        for(int i = 1; i < counters.length; i++){
            counters[i] += counters[i - 1];
            if(counters[i] > capacity ){
                return false;
            }
        }
        return true;
    }
}
```

### 2. 航班预定统计

[1109. 航班预订统计](https://leetcode-cn.com/problems/corporate-flight-bookings/)

#### 思路

将航班预定问题，转换为打车问题，那么题目的思路就会简单很多了。

将本题目转换为：某公交车有n站，第i条记录`bookings[i] = [j,k,l]`表示在`j`站上车`k`个人，乘坐到了`j`站，需要在`j + 1`站下车，我们需要按照车站的顺序返回车行驶到每一站的时候，车上的人数。

1. 定义一个`counters`数组用来记录每一站的人数变化，那么`counters[i]` 表示的就是第`i + 1`站。
2. 从头遍历`bookings` ,对应记录每一站的变化。
3. 整理`counters`数组，得到每站的人数，并返回。

#### 代码

```java
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] counters = new int[n];
        for(int[] booking : bookings){
            counters[booking[0] - 1] += booking[2];
            if(booking[1] < n){
                counters[booking[1]] -= booking[2];
            }
        }
        for(int i = 1; i < n; i++){
            counters[i] += counters[i - 1];
        }
        return counters;
    }
}
```



