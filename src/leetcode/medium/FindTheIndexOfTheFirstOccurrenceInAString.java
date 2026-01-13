package leetcode.medium;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static int strStr(String haystack, String needle) {
        int start = 0;
        int hi = 0;
        int ni = 0;

        while (haystack.length() - start >= needle.length()) {
            if (haystack.charAt(hi) == needle.charAt(ni)) {
                hi++;
                ni++;
                if (ni == needle.length()) return start;
            } else {
                ni = 0;
                start++;
                hi = start;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("aaaab", "aaab"));
    }

    public int strStr(int i, String haystack, String needle) {
        String substring = haystack.substring(i);
        if (substring.length() < needle.length()) return -1;

        if (substring.startsWith(needle)) return i;
        return strStr(i + 1, haystack, needle);
    }
}
