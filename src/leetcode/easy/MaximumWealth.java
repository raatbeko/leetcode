package leetcode.easy;

public class MaximumWealth {

    public int maximumWealth(int[][] accounts) {
        int maximumWealth = 0;

        for (int[] account : accounts) {
            int sum = 0;
            for (int i : account) {
                sum += i;
            }
            if (sum > maximumWealth){
                maximumWealth = sum;
            }
        }
        return maximumWealth;
    }
}
