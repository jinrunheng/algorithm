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