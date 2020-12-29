## 剑指 Offer 58 - II. 左旋转字符串

[剑指 Offer 58 - II. 左旋转字符串](https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/)

#### 解题思路：字符串切片

在 *Java* 中内置字符串切片函数：`str.substring(i,j)`返回字符串`str`在`[i,j)`范围的切片

对于本题，如果允许使用内置函数，即可使用内置函数对字符串切片，然后相加返回即可。

#### 代码

*Java*

```java
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n,s.length()) + s.substring(0,n);
    }
}
```

#### 解题思路：字符串拼接

字符串拼接的思路也是可行的，首先对字符串`[n,len)`范围内的字符进行遍历，将每个字符拼接到待返回字符串上；然后对字符串`[0,n)`范围进行遍历，并添加，最终返回拼接后的字符串。

#### 代码

*Java*

```java
class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = n; i < s.length(); i++){
            sb.append(s.charAt(i));
        }
        for(int i = 0; i < n; i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
```

