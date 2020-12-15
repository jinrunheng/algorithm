## 每日温度

[739. 每日温度](https://leetcode-cn.com/problems/daily-temperatures/)

#### 解题思路：单调递减栈

单调递减栈中存放用来表示气温数组的下标

声明返回数组`res`



从头遍历数组`T`

- 如果当前栈为空，则将该位置下标`push`到栈中
- 如果当前栈不为空，我们则时时维护这个单调递减栈
  - 如果`T[i] > T[stack.peek()]` ,则将栈一直`pop` 直至该栈为单调递减栈，然后再`push(i)`；在元素出栈的过程中，我们就可以确定`res`数组的一部分值：`int j = stack.pop();res[j] = i - j`
- 最后返回`res`数组即可

代码如下：

#### 代码

```java
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length]; 
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < T.length; i++){
            if(stack.isEmpty()){
                stack.push(i);
            }else {
                while(!stack.isEmpty() && T[stack.peek()] < T[i]){
                    int j = stack.pop();
                    res[j] = i - j;
                }
                stack.push(i); 
            }
        }
        return res;
    }
}
```

