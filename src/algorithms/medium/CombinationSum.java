package algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    private static List<List<Integer>> combinationSum(int[] can, int target) {
        Arrays.sort(can);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        sum(can, target, 0, lists, 0, 0);
        return lists;
    }

    private static int sum(int[] can, int target, int arrayIndex, List<List<Integer>> lists, int currentListIndex, int lastSum) {
        List<Integer> integers = lists.get(currentListIndex);
        for (int i = arrayIndex; i < can.length; i++) {
            if (lastSum < target) {
                lastSum += can[i];
                integers.add(can[i]);
                int sum = sum(can, target, i, lists, currentListIndex, lastSum);
                if (sum > target) {
                    integers.remove(can[i]);
                }
            } else if (lastSum > target) {
                lastSum += can[i];
                lastSum = sum(can, target, i + 1, lists, currentListIndex, lastSum);
            } else {
                ArrayList<Integer> newArray = new ArrayList<>();
                lists.add(newArray);
                lastSum = sum(can, target, i + 1, lists, currentListIndex + 1, 0);
            }
        }
        return lastSum;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
