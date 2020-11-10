## 总持续时间可被60整除的歌曲

[总持续时间可被 60 整除的歌曲](https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/)

#### 思路

数学

1. 整数对60取模，可能出现60种余数(0~59)。初始化一个长度为60的数组，统计各余数出现的次数。
2. 遍历time数组，每个值都对60取模，并统计每个余数出现的次数。
3. 

