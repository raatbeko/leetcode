package leetcode.medium;

public class MaximumMatrixSum {
    public static long maxMatrixSum(int[][] matrix) {
        int negativeCount = 0;
        long sum = 0;
        long minVal = Integer.MAX_VALUE;

        for (int[] ints : matrix) {
            for (int matrix1 : ints) {
                if (matrix1 < 0) {
                    negativeCount++;
                }
                minVal = Math.min(minVal, Math.abs(matrix1));
                sum += Math.abs(matrix1);
            }
        }

        if (negativeCount % 2 != 0) {
            sum -= 2 * minVal;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maxMatrixSum(new int[][]
                {
                        {2, 9, 3},
                        {5, 4, -4},
                        {1, 7, 1}
                }
        ));
    }
}
