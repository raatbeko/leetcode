package leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        ArrayList<List<Integer>> lists = new ArrayList<>();

        HashSet<Integer> nums2Set = new HashSet<>();
        HashSet<Integer> nums1Set = new HashSet<>();

        HashSet<Integer> heap = new HashSet<>();

        for (int i : nums2) {
            nums2Set.add(i);
        }
        for (int i : nums1) {
            if (nums2Set.contains(i)) {
                heap.add(i);
            } else {
                if (nums1Set.contains(i))
                    continue;
                nums1Set.add(i);
            }
        }
        nums2Set.removeAll(heap);

        lists.add(List.copyOf(nums1Set));
        lists.add(List.copyOf(nums2Set));
        return lists;
    }
}
