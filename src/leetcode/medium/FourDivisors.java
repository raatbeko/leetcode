package leetcode.medium;

public class FourDivisors {

    public static int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            if (num < 6) continue;

            int firstVal = getFirstVal(num);
            if (firstVal != 0) {
                int other = num / firstVal;
                if (firstVal * firstVal != other && getFirstVal(other) != 0) continue;

                if (firstVal != num / firstVal) {
                    sum += 1 + firstVal + (num / firstVal) + num;
                }

            }
        }
        return sum;
    }

    private static int getFirstVal(int num) {
        int firstVal = 0;
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return i;
            }
        }
        return firstVal;
    }

    public static void main(String[] args) {
        System.out.println(sumFourDivisors(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }
}
