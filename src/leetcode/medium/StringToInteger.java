package leetcode.medium;

public class StringToInteger {

    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483647"));
    }

    private static int myAtoi(String s) {
        long num = 0;
        boolean hasMark = false;
        char mark = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' && !hasMark) continue;
            if ((c == '+' || c == '-') && !hasMark) {
                hasMark = true;
                mark = c;
                continue;
            }

            if (contains(c)) {
                hasMark = true;
                num = num * 10 + (c - '0');

                if (num >= ((long) Integer.MAX_VALUE + 1) && mark == '-') return Integer.MIN_VALUE;

                if (num >= Integer.MAX_VALUE) {
                    return mark == '-' ? -Integer.MAX_VALUE : Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }
        return (int) (mark == '-' ? -num : num);
    }

    private static boolean contains(char c) {
        switch (c) {
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }
}
