package algorithms.easy;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()({()})"));
    }

    public static boolean isValid(String s) {
        if (s.length() == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '{' || aChar == '[') {
                stack.add(aChar);
            }
            if (aChar == ')' || aChar == '}' || aChar == ']') {
                if (stack.isEmpty())
                    return false;
                char peek = stack.peek();
                if (peek == '(' && aChar == ')') {
                    stack.pop();
                } else if (peek == '{' && aChar == '}') {
                    stack.pop();
                } else if (peek == '[' && aChar == ']') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
