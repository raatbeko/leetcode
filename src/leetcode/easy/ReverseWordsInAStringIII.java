package leetcode.easy;

public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder words = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            words.append(new StringBuilder(s1[i]).reverse());
            if (i + 1 != s1.length) words.append(" ");
        }
        return words.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAStringIII reverseWordsInAStringIII = new ReverseWordsInAStringIII();
        System.out.println(reverseWordsInAStringIII.reverseWords("Let's take LeetCode contest"));
    }

}
