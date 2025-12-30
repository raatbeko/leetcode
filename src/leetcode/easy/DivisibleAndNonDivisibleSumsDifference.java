package leetcode.easy;

public class DivisibleAndNonDivisibleSumsDifference {

    public static int differenceOfSums(int n, int m) {
        int k = n / m;
        int totalSum = n * (n + 1) / 2,
                sumDivisible = m * ((k * (k + 1)) / 2);

        return totalSum - 2 * sumDivisible;
    }

    public static void main(String[] args) {
        System.out.println(differenceOfSums(5, 1));
    }
}
