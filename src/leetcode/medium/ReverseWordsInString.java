package leetcode.medium;

import java.util.ArrayList;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        ArrayList<String> strings = new ArrayList<>();
        String[] s1 = s.split(" ");
        for (int i = s1.length - 1; i >= 0; i--) {
            if (!s1[i].isBlank()) strings.add(s1[i]);
        }
        return String.join(" ", strings);
    }

    public static void main(String[] args) {
        System.out.println(String.join("-", "name", "asdf"));
    }
}
