package leetcode.medium;

public class StringCompression {

    public static int compress(char[] chars) {
        int lastEmpty = 0;
        int count = 1;
        int length = 1;
        char ch = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == ch) {
                count++;
            } else {
                chars[lastEmpty++] = ch;
                if (count > 1) {
                    String s = String.valueOf(count);
                    for (int j = 0; j < s.length(); j++) {
                        chars[lastEmpty++] = s.charAt(j);
                        length++;
                    }
                    count = 1;
                }
                ch = aChar;
                length++;
            }
            if (i + 1 == chars.length) {
                chars[lastEmpty++] = ch;
                if (count > 1) {
                    String s = String.valueOf(count);
                    for (int j = 0; j < s.length(); j++) {
                        chars[lastEmpty++] = s.charAt(j);
                        length++;
                    }
                    count = 1;
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }
}
