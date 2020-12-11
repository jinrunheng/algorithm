## 最大宽度坡

[962. 最大宽度坡](https://leetcode-cn.com/problems/maximum-width-ramp/)

#### 解题思路：单调栈

题目要求我们找出最大的宽度，首先要求`i < j`,宽度为`width = j - i` 那么就是要`i`尽可能的小,要`j` 尽可能的大，理所当然地想到了从左向右遍历找到`i`,从右向左遍历找到`j`，所以最初我的想法是头尾指针，不过我们不能很好通过逻辑调用两个指针的移动。

进一步思考，条件有：`A[i] <= A[j]`,也就是说我们需要让`A[i]`的值尽可能小，所以我们就要使用严格单调递减的栈存储`A[i]`；

1. 首先正向扫描数组，记录严格单调递减的`A[i]`的下标值`i`
2. 然后，反向扫描数组，比较`A[j]`与栈顶元素`A[stack.peek()]`的值，如果满足条件，则弹出栈顶元素，不断循环直到栈为空

#### 代码

*Java*

```java
class Solution {
    public int maxWidthRamp(int[] A) {
    // 单调栈
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < A.length; i++){
            if(stack.isEmpty() || A[stack.peek()] > A[i]){
                stack.push(i);
            }
        }

        int res = 0;
        for(int i = A.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && A[stack.peek()] <= A[i]){
                res = Math.max(res,i - stack.pop());
            }
        }
        return res;
    }        
}
```

