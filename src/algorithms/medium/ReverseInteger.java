package algorithms.medium;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println();
    }

    public static int reverse(int x) {
        long rev = 0;
        long rem;

        while (x != 0) {
            rem = x % 10;
            rev = (rev * 10) + rem;
            x = x / 10;

            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }

        return (int)rev;
    }
}
