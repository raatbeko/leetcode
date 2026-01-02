package leetcode.medium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class MaximizeHappinessOfSelectedChildren {

    public static long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long max = 0;
        int val = 0;
        for (int i = happiness.length - 1; i >= 0; i--) {
            if (k == 0) return max;
            k--;

            max += Math.max(happiness[i] - val, 0);
            val++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximumHappinessSum(new int[]{1,1,1,1}, 2));
    }
}
