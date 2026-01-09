package leetcode.hard;

import java.util.Stack;

public class LongestValidParentheses {

//    public static int longestValidParentheses(String s) {
//        Stack<Integer> index = new Stack<>();
//        index.push(-1);
//        int max = 0;
//        char[] aChar = s.toCharArray();
//        for (int i = 0; i < aChar.length; i++) {
//            if (aChar[i] == '(') {
//                index.push(i);
//            } else {
//                index.pop();
//                if (index.isEmpty()) {
//                    index.push(i);
//                } else {
//                    max = Math.max(max, i - index.peek());
//                }
//            }
//        }
//        return max;
//    }

    public static int longestValidParentheses(String s) {
        int lastCount = 0;
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (char aChar : s.toCharArray()) {
            if (aChar == '(') {
                stack.add(aChar);
            }
            if (aChar == ')') {
                if (stack.isEmpty()) {
                    if (lastCount < count) {
                        lastCount = count;
                        count = 0;
                    }
                    continue;
                }

                char peek = stack.peek();
                if (peek == '(') {
                    stack.pop();
                    count++;
                } else {
                    if (lastCount < count) {
                        lastCount = count;
                        count = 0;
                    }
                }
            }
        }
        return Math.max(count, lastCount) * 2;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()"));
    }
}
