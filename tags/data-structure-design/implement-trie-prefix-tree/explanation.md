## 实现Trie

[实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)

#### Trie

Trie即前缀树，又称为字典树或单词查找树。

Trie的特点：

1. 根节点不包含字符，除了根节点外，每个节点只包含一个字符

2. 一个节点一般含有这样的几个基本信息：

   ```java
   class TrieNode {
   	boolean isEnd; // 标记这个节点是否为一个路径上的尾节点
       TrieNode[] subNodes; // 这个节点的子节点
   }
   ```

3. 从根节点开始到尾节点，路径上经过的字符连接起来的字符串为插入到Trie中的一个词汇



示例：

将`{"abc","abd","b","ba","cb","cd"}` 这些字符串插入到Trie中

插入到Trie中的结果为：

```
               root
           /   |     \
          a    b(e)    c 
        /      |      |  \
       b       a(e)   b(e) d(e)
     /   \
    c(e) d(e)
```



Trie典型的应用是搜索引擎系统用于文本词频统计，例如：

一个文本文件，大约有一万行，每行有一个词，要求统计出现频率最高的十个词汇。

#### 代码

```java
class Trie {
    public static class TrieNode {
        public boolean isEnd;
        public Map<Character,TrieNode> subNodes;

        public TrieNode(){
            isEnd = false;
            subNodes = new HashMap<>();
        }
    }
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null) return;
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for(int i = 0; i < chars.length; i++){
            if(!node.subNodes.containsKey(chars[i])){
                node.subNodes.put(chars[i],new TrieNode());
            }
            node = node.subNodes.get(chars[i]);
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null){
            return false;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for(int i = 0; i < chars.length; i++){
            if(!node.subNodes.containsKey(chars[i])){
                return false;
            }
            node = node.subNodes.get(chars[i]);
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null){
            return false;
        }
        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        for(int i = 0; i < chars.length; i++){
            if(!node.subNodes.containsKey(chars[i])){
                return false;
            }
            node = node.subNodes.get(chars[i]);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```



