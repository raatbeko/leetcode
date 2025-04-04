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
        int jMinVal = Integer.MAX_VALUE;
        int end = currentDo;
        for (int jDo = j; jDo < currentDo; jDo++) {
            if (jMinVal >= nums[jDo]) {
                jMinVal = nums[jDo];
                end = jDo;
            }
        }

        int iMaxVal = Integer.MIN_VALUE;
        for (int iDo = 0; iDo < end; iDo++) {
            iMaxVal = Math.max(nums[iDo], iMaxVal);
        }
        long max = (long) (iMaxVal - jMinVal) * kMaxVal;
        return Math.max(0, max);
    }

    public static void main(String[] args) {
        MaximumValueOfAnOrderedTripletII maximumValueOfAnOrderedTripletII = new MaximumValueOfAnOrderedTripletII();
        System.out.println(maximumValueOfAnOrderedTripletII.maximumTripletValue(new int[]{8, 6, 3, 13, 2, 12, 19, 5, 19, 6, 10, 11, 9}));

    }
}
