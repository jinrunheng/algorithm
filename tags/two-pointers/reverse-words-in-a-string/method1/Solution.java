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