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