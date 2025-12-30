package leetcode.medium;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        int start = 0;
        int row = 0;
        int zig = 0;

        Set<Integer> indexes = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        while (indexes.size() != s.length()) {
            if (row > 0) {
                if (zig != 0 && !indexes.contains(zig - row)) {
                    builder.append(s.charAt(zig - row));
                    indexes.add(zig - row);
                }

                if (zig + row < s.length() && !indexes.contains(zig + row)) {
                    builder.append(s.charAt(zig + row));
                    indexes.add(zig + row);
                }
            } else {
                builder.append(s.charAt(zig));
                indexes.add(zig);
            }

            start += 2 * (numRows - 1);

            if (start >= s.length()) {
                start = 0;
                row++;
            }
            zig = start;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(Objects.equals(convertTest("PAYPALISHIRING", 4), "PINALSIGYAHRPI"));
    }

    private static String convertTest(String s, int numRows) {
        if (numRows == 1) return s;
        int row = 0;
        boolean wasUnder = false;

        StringBuilder[] builders = new StringBuilder[numRows];
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < s.length(); j++) {
            if (builders[row] == null) {
                builders[row] = new StringBuilder();
            }
            builders[row].append(s.charAt(j));

            if (row == numRows - 1 && !wasUnder)
                wasUnder = true;

            if (wasUnder)
                row--;
            else row++;

            if (row == 0) wasUnder = false;
        }

        for (StringBuilder stringBuilder : builders) {
            if (stringBuilder != null)
                builder.append(stringBuilder);
        }
        return builder.toString();
    }
}