class Solution {
    static final Map<Character,Integer> map = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );
    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if(i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                res += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                i++;
            }else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }
}