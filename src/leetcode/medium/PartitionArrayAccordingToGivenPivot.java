package leetcode.medium;

import java.util.ArrayList;

public class PartitionArrayAccordingToGivenPivot {

    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> low = new ArrayList<>();
        ArrayList<Integer> high = new ArrayList<>();
        ArrayList<Integer> mid = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) {
                low.add(num);
            } else if (num > pivot) {
                high.add(num);
            } else {
                mid.add(num);
            }
        }

        low.addAll(mid);
        low.addAll(high);

        return low.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {

    }
}
