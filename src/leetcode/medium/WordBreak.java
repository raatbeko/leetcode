package leetcode.medium;

import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        System.out.println(wordBreak("cars", List.of("car","ca","rs")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        String s2 = s;
        for (String value : wordDict) {
            if (s2.contains(value)) {
                s2 = s2.replace(value, "");
                if (s2.isEmpty())
                    return true;
                wordBreak(s2, wordDict);
            }
        }
        return s2.isEmpty();
    }
}
