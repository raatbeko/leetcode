package leetcode.medium;

import java.util.Stack;

public class CheckValidString {

    public static void main(String[] args) {
        System.out.println(checkValidString(")(()(()(()))"));
    }

    public static boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (item == '('){
                stack.add(i);
            } else if (item == '*'){
                starStack.add(i);
            } else{
                if (!stack.isEmpty()){
                    stack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                }else {
                    return false;
                }
            }
        }

        while (!stack.isEmpty()){
            if (starStack.isEmpty()){
                return false;
            }
            if (stack.peek() < starStack.peek()){
                stack.pop();
                starStack.pop();
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
