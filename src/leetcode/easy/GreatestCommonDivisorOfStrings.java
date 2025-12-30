package leetcode.easy;

import java.util.Objects;

public class GreatestCommonDivisorOfStrings {

    public static String gcdOfStrings(String str1, String str2) {
        String toJob = str1.length() > str2.length() ? str2 : str1;

        StringBuilder max = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < toJob.length(); i++) {
            builder.append(toJob.charAt(i));
            if (Objects.equals(constr(builder, str1.length()), str1) && Objects.equals(constr(builder, str2.length()), str2)) {
                max = new StringBuilder(builder);
            }
        }
        return max.toString();
    }

    public static String constr(StringBuilder s, int length) {
        StringBuilder builder = new StringBuilder();
        while (builder.length() != length) {
            builder.append(s);
            if (builder.length() > length) return "";
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
    }
}
