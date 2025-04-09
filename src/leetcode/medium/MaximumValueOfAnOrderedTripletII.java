package leetcode.medium;

public class MaximumValueOfAnOrderedTripletII {

    public long maximumTripletValue(int[] nums) {
        int i = 0;
        int j = 1;
        int k = 2;

        int currentDo = k;
        int kMaxVal = Integer.MIN_VALUE;
        for (int kDo = k; kDo < nums.length; kDo++) {
            if (kMaxVal <= nums[kDo]) {
                kMaxVal = nums[kDo];
                currentDo = kDo;
            }
        }
        int iMaxVal = Integer.MIN_VALUE;
        int end = currentDo;
        for (int iDo = 0; iDo < currentDo - 1; iDo++) {
            if (iMaxVal < nums[iDo]) {
                iMaxVal = nums[iDo];
                iMaxVal = Math.max(nums[iDo], iMaxVal);
                end = iDo;
            }
        }

        int jMinVal = Integer.MAX_VALUE;
        for (int jDo = end == 0 ? 1 : end; jDo < currentDo; jDo++) {
            if (jMinVal >= nums[jDo]) {
                jMinVal = nums[jDo];
            }
        }

        long max = (long) (iMaxVal - jMinVal) * kMaxVal;
        return Math.max(0, max);
    }

    public static void main(String[] args) {
        MaximumValueOfAnOrderedTripletII maximumValueOfAnOrderedTripletII = new MaximumValueOfAnOrderedTripletII();
        System.out.println(maximumValueOfAnOrderedTripletII.maximumTripletValue(new int[]{6, 14, 20, 19, 19, 10, 3, 15, 12, 13, 8, 1, 2, 15, 3}));

    }
}
