package leetcode.easy;

public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        int p = 0;
        int[] preMat = null;
        for (int[] ints : grid) {
            int per = 0;
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == 1 && per > 0) {
                    per += 4 - 2;
                }else if (ints[j] == 1 && per == 0) {
                    per = 4;
                }
                if (preMat != null && preMat[j] == 1 && ints[j] == 1) {
                    per = per - 2;
                }
            }
            preMat = ints;
            p += per;
        }

        return p;
    }

    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{{1,1,1}, {1,0,1}}));
    }
}