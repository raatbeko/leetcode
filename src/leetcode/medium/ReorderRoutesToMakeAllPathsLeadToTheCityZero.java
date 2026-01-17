package leetcode.medium;

import java.util.*;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {

    public int minReorder(int n, int[][] connections) {
        var count = 0;
        var map = new HashMap<Integer, List<int[]>>();
        for (int[] connection : connections) {
            List<int[]> first = map.getOrDefault(connection[0], new ArrayList<>());
            map.put(connection[0], first);
            first.add(connection);
            List<int[]> second = map.getOrDefault(connection[1], new ArrayList<>());
            map.put(connection[1], second);
            second.add(connection);
        }

        ArrayDeque<Integer> toVisit = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<>();
        toVisit.add(0);
        while (!toVisit.isEmpty()) {
            Integer pop = toVisit.pop();
            for (int[] ints : map.get(pop)) {
                if (ints[1] != pop) {
                    if (!visited.contains(ints[1])) {
                        swap(ints);
                        toVisit.add(pop);
                        count++;
                    }
                } else {
                    toVisit.add(ints[0]);
                }
            }
            visited.add(pop);
        }

        return count;
    }

    private void swap(int[] nums) {
        var val = nums[1];
        nums[1] = nums[0];
        nums[0] = val;
    }

    public static void main(String[] args) {
        System.out.println(new ReorderRoutesToMakeAllPathsLeadToTheCityZero().minReorder(5, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}));
    }

}
