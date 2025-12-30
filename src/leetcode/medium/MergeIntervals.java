package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(ints -> ints[0]));
        ArrayList<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int lastEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (lastEnd >= intervals[i][0]) {
                lastEnd = Math.max(intervals[i][1], lastEnd);
            } else {
                list.add(new int[]{start, lastEnd});
                start = intervals[i][0];
                lastEnd = intervals[i][1];
            }
        }
        list.add(new int[]{start, lastEnd});
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {3, 6}, {8, 10}, {15, 18}})));
    }
}
