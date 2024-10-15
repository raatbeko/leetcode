package leetcode.medium;

import java.util.Arrays;

public class MakeSumDivisibleByP {
    public static int minSubarray(int[] nums, int p) {
        long sum = Arrays.stream(nums).asLongStream().sum();
        long remains = sum % p;

        if (remains == 0) return 0;
        if (sum < p) return -1;

        int lengthOfSubArray = 0;
        for (int i = 0; i < nums.length; i++) {
            if (((sum - nums[i]) % p) == 0) return 1;

            int length = 1;
            int sumOfSubarray = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                sumOfSubarray += nums[j];
                length++;
                if (((sum - sumOfSubarray) % p) == 0) {
                    if (lengthOfSubArray == 0) {
                        lengthOfSubArray = length;
                    } else {
                        if (length < lengthOfSubArray) {
                            lengthOfSubArray = length;
                        }
                    }
                    break;
                }
            }

        }
        return (lengthOfSubArray == 0 && lengthOfSubArray == nums.length) ? -1 : lengthOfSubArray;
    }

    public static void main(String[] args) {
        System.out.println(minSubarray(new int[]{4,4,2}, 7));
    }
}
