class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        // map中存储的key为字符串对应的每个字符,value存储的为该字符在字符串中的索引
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right < s.length()){
            if(map.containsKey(s.charAt(right))){
                // 更新left
                left = Math.max(left,map.get(s.charAt(right)) + 1);
            }
            res = Math.max(res,right - left + 1);
            map.put(s.charAt(right),right);
            right++;
        }
        return res;
    }
}