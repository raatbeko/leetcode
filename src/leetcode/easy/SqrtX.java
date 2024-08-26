package leetcode.easy;

public class SqrtX {

    public static int mySqrt(int x) {
        long left = 0;
        long right = x;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long midSquare = mid * mid;
            if (midSquare == x)
                return (int) mid;
            if (midSquare < x) {
                left = mid + 1;
                result = mid;
            }
            if (midSquare > x)
                right = mid - 1;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
