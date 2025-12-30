package leetcode.easy;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        int wordOne = 0;
        int wordTwo = 0;
        while (wordOne != word1.length() && wordTwo != word2.length()) {
            if (wordOne < word1.length()) {
                builder.append(word1.charAt(wordOne++));
            }
            if (wordTwo < word2.length()) {
                builder.append(word2.charAt(wordTwo++));
            }
        }

        if (word1.length() > word2.length()) {
            builder.append(word1.substring(wordOne));
        }

        if (word1.length() < word2.length()) {
            builder.append(word2.substring(wordTwo));
        }
        return builder.toString();
    }
}
