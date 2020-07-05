package zrc.test.linear;

import zrc.linear.Stack;

public class BracketsMatchTest {
    public static void main(String[] args) {
        String str = "(上海(长安)())";
        boolean match = isMatch(str);
        System.out.println(match);
    }

    public static boolean isMatch(String str) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            String currChar = str.charAt(i) + "";
            if (currChar.equals("(")) {
                stack.push(currChar);
            } else if (currChar.equals(")")) {
                String pop = stack.pop();
                if (pop == null) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
