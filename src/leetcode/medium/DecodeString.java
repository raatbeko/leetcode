package leetcode.medium;

import java.util.Objects;
import java.util.Stack;

public class DecodeString {

    public static String decodeString(String s) {
        StringBuilder builder = new StringBuilder();
        Stack<String> characters = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ']') {
                String pop = characters.pop();
                while (!Objects.equals(pop, "[")) {
                    builder.insert(0, pop);
                    pop = characters.pop();
                }
                pop = characters.pop();
                StringBuilder nums = new StringBuilder();
                while (isNumber(pop)) {
                    nums.insert(0, pop);
                    pop = characters.isEmpty() ? null : characters.pop();
                }
                if (pop != null && !isNumber(pop))
                    characters.add(pop);

                int reverse = Integer.parseInt(nums.toString());
                String repeat = String.valueOf(builder).repeat(Math.max(0, reverse));

                characters.add(repeat);

                builder = new StringBuilder();
            } else {
                characters.add(String.valueOf(c));
            }
        }
        return String.join("", characters);
    }

    private static boolean isNumber(String c) {
        if (c == null) return false;

        return switch (c) {
            case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> true;
            default -> false;
        };
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
