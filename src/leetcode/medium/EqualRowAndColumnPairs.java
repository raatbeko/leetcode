package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        HashMap<Integer, List<Integer>> column = new HashMap<>();
        HashMap<Integer, List<Integer>> row = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            row.put(i, new ArrayList<>());
            for (int j = 0; j < grid[i].length; j++) {
                row.get(i).add(grid[i][j]);

                if (column.containsKey(j)) {
                    column.get(j).add(grid[i][j]);
                } else {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(grid[i][j]);
                    column.put(j, integers);
                }

            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            List<Integer> integers = row.get(i);
            for (int j = 0; j < grid.length; j++) {
                if (integers.equals(column.get(j))) {
                    count++;
                }
            }
        }

        return count;
    }
}
