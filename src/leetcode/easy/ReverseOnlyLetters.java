package leetcode.easy;

public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int j = 0;
        int i = s.length() - 1;

        while (i >= j) {
            if (Character.isAlphabetic(s.charAt(j))) {
                if (Character.isAlphabetic(s.charAt(i))) {
                    chars[j] = s.charAt(i);
                    chars[i] = s.charAt(j);
                    i--;
                    j++;
                } else {
                    i--;
                }
            } else {
                j++;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseOnlyLetters().reverseOnlyLetters("a-bC-dEf-ghIj"));
    }
}
