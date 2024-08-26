package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        sum(candidates, target, 0, lists, new ArrayList<>(), 0);
        return lists;
    }

    private static void sum(int[] can, int target, int arrayIndex, List<List<Integer>> lists, List<Integer> currentListIndex, int lastSum) {
        int actualSum = lastSum;
        for (int i = arrayIndex; i < can.length; i++) {
            actualSum += can[i];
            if (actualSum < target) {
                currentListIndex.add(can[i]);
                sum(can, target, i, lists, currentListIndex, actualSum);
                currentListIndex.remove(currentListIndex.size() - 1);
            }
            if (actualSum == target) {
                currentListIndex.add(can[i]);
                ArrayList<Integer> integers = new ArrayList<>(currentListIndex);
                lists.add(integers);
                currentListIndex.remove(currentListIndex.size() - 1);
            }
            actualSum = lastSum;
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{1}, 2));
    }
}
