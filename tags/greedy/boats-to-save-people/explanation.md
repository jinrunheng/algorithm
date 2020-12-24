## 881. 救生艇

[881. 救生艇](https://leetcode-cn.com/problems/boats-to-save-people/)

#### 解题思路：贪心算法

已知：

- 每艘船最多可以同时载2人
- `people[i] <= limit`;即：每个人的体重不会超过一艘船的最大载重

贪心策略：

- 如果最重的人能与最轻的人共用一艘船，那么就让这两人使用一艘船
- 如果不能，那么最重的人独用一艘船

实现方法：

- 对人的体重进行排序
- 使用两个指针`i`,`j` ，分别指向当前最轻的人和最重的人
- 如果满足`people[i] + people[j] <= limit`,那么就让两人乘坐一艘船，然后两指针同时移动
- 否则，就让最重的人独自乘坐一艘船，只移动`j`指针

#### 代码

*Java*

```java
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int i = 0;
        int j = people.length - 1;
        int res = 0;
        Arrays.sort(people);
        while(i <= j){
            if(people[i] + people[j] <= limit){
                i++;
            }
            j--;
            res++;
        }
        return res;
    }
}
```

