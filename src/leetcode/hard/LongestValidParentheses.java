package leetcode.hard;

import java.util.Stack;

public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        Stack<Integer> index = new Stack<>();
        index.push(-1);
        int max = 0;
        char[] aChar = s.toCharArray();
        for (int i = 0; i < aChar.length; i++) {
            if (aChar[i] == '(') {
                index.push(i);
            } else {
                index.pop();
                if (index.isEmpty()) {
                    index.push(i);
                } else {
                    max = Math.max(max, i - index.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()()"));
    }
}
