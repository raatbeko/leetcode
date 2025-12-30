package leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;

public class LargestColorValueInADirectedGraph {
    public static int largestPathValue(String colors, int[][] edges) {
        int colorsI = 0;
        int maxLargest = 0;
        HashSet<Integer> firstSet = new HashSet<>();
        HashSet<Integer> secondSet = new HashSet<>();
        HashMap<Character, Integer> counting = new HashMap<>();
        for (int[] edge : edges) {
            int first = edge[0];
            int second = edge[1];
            if (firstSet.contains(second) || first == second) return -1;

            if (!firstSet.contains(first) && !secondSet.contains(first)) {
                if (colorsI == colors.length()) return -1;
                char c = colors.charAt(colorsI);
                Integer orDefault = counting.getOrDefault(c, 0);
                counting.put(c, orDefault + 1);

                if (orDefault > maxLargest) maxLargest = orDefault;
                firstSet.add(first);
                colorsI++;
            }
            if (!secondSet.contains(second)) {
                if (colorsI == colors.length()) return -1;
                char c = colors.charAt(colorsI);
                Integer orDefault = counting.getOrDefault(c, 0);
                counting.put(c, orDefault + 1);

                orDefault = counting.get(c);
                if (orDefault > maxLargest) maxLargest = orDefault;
                secondSet.add(second);
                colorsI++;
            }
        }
        return maxLargest;
    }

    public static void main(String[] args) {
        System.out.println(largestPathValue("hhqhuqhqff", new int[][]{{0,1},{0,2},{2,3},{3,4},{3,5},{5,6},{2,7},{6,7},{7,8},{3,8},{5,8},{8,9},{3,9},{6,9}}));
    }
}
