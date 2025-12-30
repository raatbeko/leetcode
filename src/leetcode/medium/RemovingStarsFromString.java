package leetcode.medium;

public class RemovingStarsFromString {

    public static String removeStars(String s) {
        StringBuilder builder = new StringBuilder();
        int last = s.length() - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '*') {
                last -= 2;
            } else {
                if (i > last) continue;

                builder.append(s.charAt(last));
                last--;
            }
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeStars("erase*****"));
    }
}
