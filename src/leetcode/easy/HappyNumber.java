package leetcode.easy;

import java.util.HashSet;

public class HappyNumber {

    public static boolean isHappy(int n) {
        HashSet<Long> longs = new HashSet<>();

        long nLong = n;
        long num = 0;
        while (true) {
            while (nLong > 0) {
                long digit = nLong % 10;
                nLong = nLong / 10;
                num += digit * digit;
            }
            if (num == 1) return true;
            if (longs.contains(num)) return false;
            nLong = num;
            longs.add(num);
            num = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
