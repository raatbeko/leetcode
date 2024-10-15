package leetcode.medium;

import java.util.Arrays;

public class SeparateBlackAndWhiteBalls {
    public static long minimumSteps(String s) {
        char[] charArray = s.toCharArray();
        long count = count(charArray, 0);
        System.out.println(Arrays.toString(charArray));
        return count;
    }

    private static long count(char[] charArray, long count) {
        long localCount = 0;
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == '1' && charArray[i + 1] == '0') {
                charArray[i] = '0';
                charArray[i + 1] = '1';
                count++;
                localCount++;
            } else if (i - 1 >= 0 && charArray[i - 1] == '1' && charArray[i] == '0') {
                charArray[i - 1] = '0';
                charArray[i] = '1';
                count++;
                localCount++;
            }
        }
        if (localCount != 0) {
            return count(charArray, count);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minimumSteps("10"));
    }
}
