## 剑指 Offer 05. 替换空格

[剑指 Offer 05. 替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)

#### 解题思路一：直接使用字符串API

我们可以直接使用字符串的`replace()`方法；详见代码部分

#### 代码

*Java*

```java
class Solution {
    public String replaceSpace(String s) {
        return s.replace(" ","%20");
    }
}
```

#### 解题思路二：重新构建字符串

Java提供了`StringBuilder`类，在重新构建字符串的时候，可以不产生新的字符串对象；代码仍然十分简单

#### 代码

*Java*

```java
class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
```

