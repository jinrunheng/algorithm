## 翻转字符串里的单词

[151. 翻转字符串里的单词](https://leetcode-cn.com/problems/reverse-words-in-a-string/)

#### 思路一：使用 Java API

1. 首先去掉字符串两侧的空格`str.trim()`
2. 然后按照空格分割成字符串数组`str.trim().split(" ")`
3. 从后向前遍历字符串数组，添加到`StringBuilder`对象中，每添加一个字符串同时也添加一个空格
4. 最后的`StringBuilder`对象中末尾有一个空格，再次调用`trim()`方法，去除空格并返回

#### 代码

```java
class Solution {
    public static String reverseWords(String s) {
        // API
        String[] strings = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!strings[i].equals("")) {
                sb.append(strings[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
```

#### 思路二：双指针

1. 倒序遍历字符串s，记录单词的左右边界索引 `left`,right
2. 每确定一个单词边界，则将其添加至单词列表 StringBuilder对象中
3. 最终，将单词列表拼接为字符串，并返回即可。

#### 代码

```java
class Solution {
    public static String reverseWords(String s) {
        // 双指针
        s = s.trim();
        char[] chars = s.toCharArray();
        int left = chars.length - 1;
        int right = chars.length - 1;
        StringBuilder sb = new StringBuilder();
        while (left >= 0) {
            while (left >= 0 && chars[left] != ' ') {
                left--;
            }
            sb.append(s.substring(left + 1, right + 1) + " ");
            while (left >= 0 && chars[left] == ' ') {
                left--;
            }
            right = left;
        }
        return sb.toString().trim();
    }
}
```

