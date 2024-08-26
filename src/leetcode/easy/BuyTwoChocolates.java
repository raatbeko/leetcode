package leetcode.easy;

public class BuyTwoChocolates {

    public static int buyChoco(int[] prices, int money) {
        int min = Integer.MAX_VALUE;
        int preMin = Integer.MAX_VALUE;

        for (int num : prices) {
            if (num < min) {
                preMin = min;
                min = num;
            } else if (num < preMin) {
                preMin = num;
            }
        }

        if ((min + preMin) <= money) {
            return money - (min + preMin);
        }
        return money;
    }

    public static void main(String[] args) {
        System.out.println(buyChoco(new int[]{1,3, 2}, 3));
    }
}
