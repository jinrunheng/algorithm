## 总持续时间可被60整除的歌曲

[总持续时间可被 60 整除的歌曲](https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/)

#### 思路

数学

1. 整数对60取模，可能出现60种余数(0~59)。初始化一个长度为60的数组，统计各余数出现的次数。
2. 遍历time数组，每个值都对60取模，可以获得到每个余数出现的次数。
3. 余数为0的情况，只能同余数为0的情况进行组合；如果0的情况出现了k次，那么组合的可能性有`k * (k - 1) / 2`种。
4. 余数为30的情况，只能同余数为30的情况进行组合；如果0的情况出现了k次，那么组合的可能性有`k * (k - 1) / 2`种。
5. 其他的组合情况为：余1的和余59的组合，余2的和余58的组合;1的情况出现了m次，59的情况出现了n次，那么共有`m * n`种组合。

#### 代码

Go:

```go
func numPairsDivisibleBy60(time []int) int {
    var res int
    seconds := make([]int, 60)
    for _,v := range time {
        seconds[v % 60]++
    }
    res += seconds[0] * (seconds[0] - 1) / 2
    res += seconds[30] * (seconds[30] - 1) / 2
    i := 1
    j := 59
    for i < j {
        res += seconds[i] * seconds[j]
        i++
        j--
    }
    return res

}
```

Java:

```java
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        int[] seconds = new int[60];
        for(int t : time){
            seconds[t % 60]++;
        }
        res += (seconds[30]) * (seconds[30] - 1) / 2;
        res += (seconds[0]) * (seconds[0] - 1) / 2;
        int i = 1,j = 59;
        while(i < j){
            res += seconds[i++] * seconds[j--];
        }
        return res;
    }
}
```



