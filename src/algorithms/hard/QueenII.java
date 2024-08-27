package algorithms.hard;

public class QueenII {

    public static int totalNQueens(int n) {
        return count(n, 0,0, new Integer[n], new Integer[n][2]);
    }

    private static int count(int n, int current, int count, Integer[] rows, Integer[][] anti) {
    return 0;
    }

    public static void main(String[] args) {
        totalNQueens(1);
    }
}
