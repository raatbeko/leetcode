package leetcode.easy;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int sI = 0;
        for (int i = 0; i < t.length(); i++) {
            if (sI == s.length()) return true;
            if (t.charAt(i) == s.charAt(sI)) {
                sI++;
            }
        }
        return sI == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }
}
