package leetcode.medium;

import java.util.List;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = 0;
        int column = 0;
        while (true) {

            if (column == matrix[row].length - 1) {
                row++;
            }

            System.out.print(matrix[row][column]);

            if (column + 1 != matrix[row].length)
                ++column;

            if (row == matrix.length - 1) {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        }));
    }
}
