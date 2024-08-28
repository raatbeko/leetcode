package structure.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        nextPermutation(lists, Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList()));
        return lists;
    }

    public static void nextPermutation(List<List<Integer>> lists, List<Integer> current) {
        lists.add(new ArrayList<>(current));
        for (int i = current.size() - 1; i > 0; i--) {
            int rightSide = current.get(i - 1);
            int leftSide = current.get(i);
            if (rightSide < leftSide) {
                for (int j = current.size()-1; j > 0; j--) {
                    if (rightSide < current.get(j)) {
                        int num = current.get(j);
                        current.set(j, rightSide);
                        current.set(i - 1, num);
                        reverseArray(current,i);
                        nextPermutation(lists, current);
                        return;
                    }
                }
            }
        }
    }

    private static void reverseArray(List<Integer> nums, int start) {
        for (int i = start; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) > nums.get(j)) {
                    int num = nums.get(i);
                    nums.set(i, nums.get(j));
                    nums.set(j, num);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{0,-1,1}));
    }
}
