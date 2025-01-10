package leetcode.medium;

import java.util.Objects;

public class CountPrefixAndSuffixPairsI {


    public static int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (Objects.equals(words[i], words[j]) || words[i].length() < words[j].length() && isPrefixAndSuffix(words[i], words[j])) count++;
            }
        }
        return count;
    }

    private static boolean isPrefixAndSuffix(String w1, String w2) {
        return Objects.equals(w2.substring(0, w1.length()), w1) && Objects.equals(w2.substring(w2.length() - w1.length(), w2.length()), w1);
    }

    public static void main(String[] args) {
        System.out.println(countPrefixSuffixPairs(new String[]{"abab","ab"}));
    }
}
