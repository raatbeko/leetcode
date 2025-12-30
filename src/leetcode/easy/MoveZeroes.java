package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) return;

        Queue<Integer> zeroIndexes = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndexes.add(i);
                continue;
            }
            if (!zeroIndexes.isEmpty()) {
                nums[zeroIndexes.poll()] = nums[i];
                nums[i] = 0;
                zeroIndexes.add(i);
            }
        }
    }
}
