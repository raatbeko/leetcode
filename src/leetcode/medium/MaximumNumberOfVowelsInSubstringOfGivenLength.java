package leetcode.medium;

public class MaximumNumberOfVowelsInSubstringOfGivenLength {

    public static void main(String[] args) {
        System.out.println(maxVowels("leetcode", 3));
    }

    public static int maxVowels(String s, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i)))
                count++;
        }
        if (k == s.length()) return count;
        int newCount = count;
        for (int i = 0; i < s.length(); i++) {
            if (k == s.length()) break;

            if (isVowel(s.charAt(i))) {
                newCount--;
            }
            if (isVowel(s.charAt(k))) {
                newCount++;
            }
            if (newCount > count) {
                count = newCount;
            }
            k++;
        }
        return count;
    }

    private static boolean isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }
}
