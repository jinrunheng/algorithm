## 20. 有效的括号

[20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)

#### 解题思路：栈

题目规定，字符串中只包括`'('`，`')'`，`'{'`，`'}'`，`'['`，`']'`这些字符。



使用辅助栈：`Stack<Character> stack = new Stack<>();`；遍历字符串

原则：

1. 当遍历到左括号，入栈
2. 遍历到右括号，首先，判断栈是否为空，如果当前栈为空则返回`false`
3. 当前栈不为空，则出栈一个字符,比较该字符与当前遍历的字符是否匹配
   1. 如果当前字符为`}`,出栈字符为`{`，则说明是匹配的
   2. 如果当前字符为`)`,出栈字符为`(`，则说明是匹配的
   3. 如果当前字符为`]`,出栈字符为`[`，则说明是匹配的
4. 最后返回栈是否为空，栈为空则说明整个字符串满足字符匹配原则，否则不满足

#### 代码

*Java*

```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                char pop = stack.pop();
                if(c == ')' && pop != '('){
                    return false;
                }
                if(c == ']' && pop != '['){
                    return false;
                }
                if(c == '}' && pop != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
```

