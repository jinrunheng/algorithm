class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (canConvertNum(s)) {
                stack.push(Integer.valueOf(s));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (s.equals("*")) {
                    stack.push(num2 * num1);
                }
                if (s.equals("+")) {
                    stack.push(num2 + num1);
                }
                if (s.equals("-")) {
                    stack.push(num2 - num1);
                }
                if (s.equals("/")) {
                    stack.push(num2 / num1);
                }
            }
        }
        return stack.pop();
    }

    private static boolean canConvertNum(String s) {
        return !s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/");
    }
}