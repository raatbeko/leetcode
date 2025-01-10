package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class StringMatchingInAnArray {

    public static List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                String wordJ = words[j];
                String wordI = words[i];
                if (wordJ.length() > wordI.length() && wordJ.contains(wordI)) {
                    list.add(wordI);
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(stringMatching(new String[]{"mass","as","hero","superhero"}));
    }
}
