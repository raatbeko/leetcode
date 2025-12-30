package leetcode.easy;

public class ReverseVowelsOfString {

    public static String reverseVowels(String s) {
        StringBuilder builder = new StringBuilder(s);
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (isVowel(Character.toLowerCase(leftChar))) {
                if (isVowel(Character.toLowerCase(rightChar))) {
                    builder.setCharAt(left, rightChar);
                    builder.setCharAt(right, leftChar);
                    left++;
                }
                right--;
                continue;
            }
            if (isVowel(Character.toLowerCase(rightChar))) {
                if (isVowel(Character.toLowerCase(leftChar))) {
                    builder.setCharAt(left, rightChar);
                    builder.setCharAt(right, leftChar);
                    right--;
                }
                left++;
                continue;
            }
            right--;
            left++;
        }
        return builder.toString();
    }

    private static boolean isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm"));
    }
}
