package algorithms.medium;

public class BestTimeToBuyAndSellStockII {

    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            if (price - minPrice > maxProfit) {
                maxProfit += price - minPrice;
                minPrice = price;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,3,3}));
    }
}
