package leetcode.easy;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        return split[split.length - 1].length();
    }
}
