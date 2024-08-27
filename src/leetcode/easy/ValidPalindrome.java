package leetcode.easy;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int right = charArray.length - 1;
        int left = 0;
        while (left < right) {
            if (!Character.isLetterOrDigit(charArray[right])) {
                right--;
            } else if (!Character.isLetterOrDigit(charArray[left])) {
                left++;
            } else if (Character.toLowerCase(charArray[left]) == Character.toLowerCase(charArray[right])) {
                right--;
                left++;
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("AAAA"));
    }
}
