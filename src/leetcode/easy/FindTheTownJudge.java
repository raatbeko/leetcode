package leetcode.easy;

public class FindTheTownJudge {

    public int findJudge(int n, int[][] trust) {
        int[] s = new int[n+1];
        int[] d = new int[n+1];
        for (int[] ints : trust) {
            d[ints[0]] += 1;
            s[ints[1]] += 1;
        }
        for (int i = 1; i < s.length; i++) {
            if (s[i] == n-1 && d[i] == 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheTownJudge().findJudge(2, new int[][]{{1,2}}));
    }
}
