package leetcode.medium;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (turnToPlus(divisor) > turnToPlus(dividend) || divisor == 0) {
            return 0;
        }
        boolean isDivisorPlus = divisor > 0;
        boolean isDividendPlus = dividend > 0;

        if (turnToPlus(divisor) == 1) {
            return getResult(isDividendPlus, isDivisorPlus, turnToPlus(dividend));
        }

        if (divisor == dividend) return 1;

        long newDivisor = turnToPlus(divisor);
        long newDividend = turnToPlus(dividend);


        long divideNum = 0;
        long move = 0;
        while (move <= newDividend) {
            move = newDivisor << divideNum;
            divideNum++;
        }

        return getResult(isDividendPlus, isDivisorPlus, divideNum);
    }

    private int getResult(boolean isDividendPlus, boolean isDivisorPlus, long divideNum) {
        if (isDividendPlus && isDivisorPlus || !isDividendPlus && !isDivisorPlus) {
            if (divideNum >= Integer.MAX_VALUE) return (int) (divideNum - 1);

            return (int) divideNum;
        }

        return (int) turnToMinus(divideNum);
    }

    public long turnToPlus(long num) {
        if (num >= 0) return num;

        return -(num);
    }

    public long turnToMinus(long num) {
        return -num;
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(7, -3));
    }
}
