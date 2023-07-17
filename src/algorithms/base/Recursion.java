package algorithms.base;

import java.util.ArrayList;
import java.util.List;

public class Recursion {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        System.out.println(sum(integers));
    }

    private static Integer sum(List<Integer> nums) {
        if (nums.isEmpty())
            return 0;
        return nums.remove(0) + sum(nums);
    }

    private static Integer count(List<Integer> nums) {
        if (nums.isEmpty())
            return 0;
        int count = 1;
        nums.remove(0);
        return count + count(nums);
    }
}
