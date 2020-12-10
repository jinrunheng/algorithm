## 种花问题

[605. 种花问题](https://leetcode-cn.com/problems/can-place-flowers/)

#### 解题思路：贪心

设置一个变量`max`，代表`flowerbed`数组最多能种多少花

从左到右扫描数组，如果当前的位置为0，并且这个0的左右两侧都是0，那么我们就可以在这个位置种花了，即将这个位置的0修改为1，并将`max`增加1。

另外，我们需要对数组的第一个位置和最后一个位置进行特殊判断；

如果索引在数组的第一个位置，并且`flowerbed[0] == 0`，我们只需要判断`flowerbed[1]` 是否存在并是否为0，如果满足条件，那么在`flowerbed[0]` 这个位置则可以种花。

如果索引在数组的最后一个位置，并且`flowerbed[flowerbed.length - 1] == 0`，我们只需要判断前一个位置是否等于0，如果满足条件，那么在`flowerbed[flowerbed.length - 1]`这个位置则可以种花。

如果`max >= n` 我们就可以跳出循环，返回`true`,否则返回`false`

#### 代码

*Go*

```go
func canPlaceFlowers(flowerbed []int, n int) bool {
    if n == 0 {
        return true
    }
    if len(flowerbed) == 1 {
        return flowerbed[0] == 0 && n == 1
    }

    max := 0
    i := 0
    for i < len(flowerbed) {
        
        if i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0 {
            flowerbed[i] = 1
            max += 1
            i += 1
            continue
        }

        if i - 1 >= 0 && i + 1 < len(flowerbed) && flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0{
            flowerbed[i] = 1
            max += 1
            i += 1
            continue
        }
        
        if i == len(flowerbed) - 1 && flowerbed[len(flowerbed) - 1] == 0 && flowerbed[len(flowerbed) - 2] == 0{
            flowerbed[i] = 1
            max += 1
            i += 1
            continue
        }

        if max >= n {
            return true
        }
        i += 1
    }
    return max >= n
}
```

*Java*

```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int max = 0;
        int i = 0;
        if(n == 0){
            return true;
        }
        if(flowerbed.length == 1){
            return flowerbed[0] == 0 && n == 1;
        }
        while(i < flowerbed.length){
            if(i == 0 && flowerbed[0] == 0 && flowerbed[1] == 0){
                flowerbed[0] = 1;
                max++;
                i += 1;
                continue;
            }

            if(i - 1 >= 0 && i + 1 < flowerbed.length && flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                max++;
                flowerbed[i] = 1;
                i++;
                continue;
            }

            if(i == flowerbed.length - 1 && flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0){
                max++;
                flowerbed[i] = 1;
                i++;
                continue;
            }

            if(max >= n){
                return true;
            }
            
            i++;
        }
        return max >= n;
    }
}
```



