## 优势洗牌 

[870. 优势洗牌](https://leetcode-cn.com/problems/advantage-shuffle/)

#### 解题思路：贪心

本题的贪心策略和田忌赛马的策略是一致的：

首先我们对A数组进行排序

如示例：

```
输入：A = [12,24,8,32], B = [13,25,32,11]
```

对数组A排序后的结果为：

```
A = [8,12,24,32]
```

比较策略：

- 在排序后的数组中寻找比当前遍历到的B数组的元素大的数字
- 如果找到了，就将其放到该位置
- 如果遍历到排序后数组A的最后一个元素也没有找到比当前的B数组的元素大的数字，就使用最差策略，即用A数组中最小的数字和B数组的当前数字进行比较

示例中，使用我们的比较策略的结果为：

```
输出：[24,32,8,12]
```

#### 代码

```java
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int[] res = new int[A.length];
        Arrays.sort(A);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < A.length; i++){
            list.add(A[i]);
        }
        for(int i = 0; i < B.length; i++){
            for(int j = 0; j < list.size(); j++){
                if(list.get(j) > B[i]){
                    res[i] = list.get(j);
                    list.remove(j);
                    break;
                }else {
                    if(j == list.size() - 1){
                        res[i] = list.get(0);
                        list.remove(0);
                        break;
                    }
                }
            }
        }
        return res;
    }
}
```

