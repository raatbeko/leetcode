package leetcode.easy;

public class MinimumTimeVisitingAllPoints {

    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        for (int i = 0; i < points.length; i++) {
            if (i+1 == points.length) continue;

            int dx =  Math.abs(points[i][0] - points[i+1][0]);
            int dy =  Math.abs(points[i][1] - points[i+1][1]);

            time += Math.max(dx, dy);
        }
        return time;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumTimeVisitingAllPoints().minTimeToVisitAllPoints(new int[][]{{1, 1}, {3, 4}, {-1, 0}}));
    }
}
