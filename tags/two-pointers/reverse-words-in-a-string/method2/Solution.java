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