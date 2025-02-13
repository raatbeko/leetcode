package leetcode.medium;

public class GridGame {

    public long gridGame(int[][] grid) {
        long firstRowSum = 0;
        for (int num : grid[0]) {
            firstRowSum += num;
        }
        long secondRow = 0;
        long minimumSum = Long.MAX_VALUE;

        for (int i = 0; i < grid[0].length; ++i) {
            firstRowSum -= grid[0][i];

            minimumSum = Math.min(
                    minimumSum,
                    Math.max(firstRowSum, secondRow)
            );
            secondRow += grid[1][i];
        }

        return minimumSum;
    }

    public static void main(String[] args) {
        GridGame gridGame = new GridGame();
        System.out.println(gridGame.gridGame(new int[][]{{20, 3, 20, 17, 2, 12, 15, 17, 4, 15},
                {20, 10, 13, 14, 15, 5, 2, 3, 14, 3}}));
    }
}
