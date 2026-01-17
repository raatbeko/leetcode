package leetcode.easy;

public class FlipSquareSubmatrixVertically {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int row = k;
        int i = y;
        int start = x;
        int end = x + k - 1;
        while (row != 0) {
            while (start <= end) {
                int val = grid[start][i];
                grid[start][i] = grid[end][i];
                grid[end][i] = val;

                start++;
                end--;
            }
            i++;
            row--;
            start = x;
            end = x + k - 1;
        }
        return grid;
    }
}
