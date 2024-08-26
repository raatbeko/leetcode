package structure.stack;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isBalanced(String s) {
        // Реализуйте метод
        Stack<Character> stack = new Stack<>();
        for (char aChar : s.toCharArray()) {
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
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("(])"));
    }
}
