package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class QueenII {

    public static int totalNQueens(int n) {
        return count(n, 0, 0, new Integer[n], new ArrayList(), new ArrayList<>());
    }

    private static int count(int n, int row, int count, Integer[] cols, List<Integer> dg, List<Integer> udg) {
        for (int i = 0; i < n; i++) {
            if (cols[i] == null) {
                int dgSum = row + i;
                int udgSum = row - i + (n - 1);
                if (!dg.contains(dgSum) && !udg.contains(udgSum)) {
                    dg.add(dgSum);
                    udg.add(udgSum);
                    cols[row] = row;
                    if (row == n - 1) {
                        count += 1;
                    } else {
                        count += count(n, row + 1, count, cols, dg, udg);
                    }
                }

            }
            System.out.println(count);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
}
