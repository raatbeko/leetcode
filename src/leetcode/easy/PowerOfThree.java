package leetcode.easy;

public class PowerOfThree {

    public static boolean isPowerOfThree(int n) {
        if (n < 0 || n == 0) return false;
        long log = Math.round(Math.log(n) / Math.log(3));
        return Math.pow(3, log) == n;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(243));
    }
}
