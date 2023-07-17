package algorithms.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    private static List<List<Integer>> combinationSum(int[] can, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        int i = 0;
        while (i != can.length) {
            int num = can[i];
            if (num > target)
                continue;
            if (num == target) {
                lists.add(List.of(num));
                continue;
            }

            if ((target % num) == 0) {
                int j = target / num;
                List<Integer> integers = new ArrayList<>();
                for (int k = 0; k < j; k++) {
                    integers.add(j);
                }
                lists.add(integers);
                i++;
            }
            if (num < target){
            }

        }

        return lists;
    }
}
