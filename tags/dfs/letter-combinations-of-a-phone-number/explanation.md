## 电话号码的字母组合

[17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)

#### 解题思路：dfs

解题思路很简单直白，使用示例

```
input:"23"
output:["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
```

首先，我们使用map进行预处理，将电话号码按键与对应的字母映射起来；我们可以使用Java8之前的方式，一个一个put到map中，也可以使用Java9标准库的初始化工厂，当然这里面我更推荐使用java9的`Map.of()` 这种初始化方式，并且这个map是不变的，所以应当定义为final：

```java
static final Map<Character, String> map = Map.of(
    '1',"",
    '2', "abc", 
    '3', "def", 
    '4', "ghi", 
    '5', "jkl",
    '6', "mno", 
    '7', "pqrs", 
    '8', "tuv", 
    '9', "wxyz"
);
```

思路很简单了，遍历输入的每一个字符，找到对应字母，基本的dfs操作，代码如下

#### 代码

```java
class Solution {
    static final Map<Character, String> map = Map.of(
            '1',"",
            '2', "abc", 
            '3', "def", 
            '4', "ghi", 
            '5', "jkl",
            '6', "mno", 
            '7', "pqrs", 
            '8', "tuv", 
            '9', "wxyz"
        );
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        dfs(digits,res,0,map);
        return res;
    }

    private static void dfs(String digits,List<String> res,int curIndex,Map<Character,String> map){
        if(curIndex == digits.length()){
            return;
        }
        if(curIndex == 0){
           String s = map.get(digits.charAt(0));
           for(int i = 0; i < s.length(); i++){
               res.add(s.charAt(i) + "");
           }
           dfs(digits,res,curIndex + 1,map);
        }else {
            String s = map.get(digits.charAt(curIndex));
            int size = res.size();
            for(int i = 0; i < size; i++){
                String str = res.remove(0);
                for(int j = 0; j < s.length(); j++){
                    res.add(str + s.charAt(j));
                }
            }
            dfs(digits,res,curIndex + 1,map);
        }
    }
}
```



