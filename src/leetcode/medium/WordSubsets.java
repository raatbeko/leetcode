package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public static List<String> wordSubsets(String[] words1, String[] words2) {
        ArrayList<String> strings = new ArrayList<>();
        boolean flag = false;
        for (String s : words1) {
            for (String j : words2) {
                if (s.length() < j.length()) continue;
                if (!s.contains(j)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                strings.add(s);
            }
            flag = false;
        }
        return strings;
    }

    public static void main(String[] args) {
        System.out.println(wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"lo", "eo"}));
    }
}
