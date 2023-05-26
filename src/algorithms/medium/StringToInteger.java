package algorithms.medium;

public class StringToInteger {

    public static void main(String[] args) {
        System.out.println(myAtoi("-91283"));
    }

    private static int myAtoi(String s) {
        char[] strs = s.toCharArray();
        String num = "";
        for (int i = 0; i < strs.length; i++) {
            if (check(strs[i])) {
                num += strs[i];
                if (i + 1 < strs.length)
                    if (!check(strs[i + 1])) {
                        return Integer.parseInt(num);
                    }
                if (Long.parseLong(num) < -2147483648 || Long.parseLong(num) > 2147483648L) {
                    return 2147483647;
                }
            }
            if (strs[i] == '-') {
                if (i + 1 < strs.length) {
                    if (check(strs[i + 1])) {
                        num += strs[i];
                    }
                }
            }
        }

        return Integer.parseInt(num);
    }

    private static boolean check(char num) {
        char[] nums = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (char c : nums) {
            if (c == num) {
                return true;
            }
        }
        return false;
    }

}
