package algorithms.easy;

import java.util.HashSet;
import java.util.Set;

public class ClimbingStairs {
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int climbStairs(int n) {
        if (n == 1)
            return 1;

        int pos = 0;
        int countOne = 0;
        if (n % 2 == 0) {
            pos = 1;
            int countTwo = n / 2;
            while (countOne != n) {
                countOne += 2;
                countTwo -= 1;
                pos += factorial(countOne + countTwo) / (factorial(countTwo) * factorial(countOne));
            }
            return pos;
        } else {
            pos = 1;
            countOne = 1;
            int countTwo = (n-1)/2;
            while (countOne != n) {
                countOne += 2;
                countTwo -= 1;
                pos += factorial(countOne + countTwo) / (factorial(countTwo) * factorial(countOne));
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(7));
    }
}
