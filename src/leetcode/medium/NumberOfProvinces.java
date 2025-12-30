package leetcode.medium;

import java.util.Objects;

public class NumberOfProvinces {

    private boolean[] visited;

    public int findCircleNum(int[][] isConnected) {
        visited = new boolean[isConnected.length];

        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                count(isConnected, i, 0);
                count++;
            }
        }
        return count;
    }

    public void count(int[][] isConnected, int city, int count) {
        visited[city] = true;

        int[] edges = isConnected[city];
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] == 1 && !visited[i]) {
                count(isConnected, i, count);
            }
        }
    }

    public static void main(String[] args) {
        Integer a = 200;
        Integer b = 200;
        System.out.println(Objects.equals(a, b));
        System.out.println(new NumberOfProvinces().findCircleNum(new int[][]{{1, 1, 1}, {0, 1, 0}, {0, 0, 1}}));
    }
}
