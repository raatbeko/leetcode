package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromePartitioning {
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
        System.out.println("sub".substring(0, 3));
    }

    public List<List<String>> partition(String s) {
        Set<List<String>> partition = new HashSet<>();
        List<List<String>> lists = new ArrayList<>();
        List<String> words;


        return lists;
    }
}
