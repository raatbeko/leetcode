package structure.dynamicProgramming;

/**
 * Решение задачи о рюкзаке с помощью динамического программирования.
 * <p>
 * В этой задаче имеется рюкзак с ограниченной ёмкостью и набор предметов,
 * каждый с определённым весом и стоимостью. Необходимо определить,
 * какие предметы следует поместить в рюкзак, чтобы максимизировать
 * общую стоимость, не превышая его ёмкость.
 * </p>
 */
public class Knapsack {

    /**
     * Находит максимальную стоимость предметов, которые можно поместить в рюкзак,
     * используя динамическое программирование.
     *
     * @param weights Массив весов предметов.
     * @param values Массив стоимостей предметов.
     * @param capacity Ёмкость рюкзака.
     * @return Максимальная стоимость предметов, которые можно поместить в рюкзак.
     */
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3};
        int[] values = {10, 20, 30};
        int capacity = 5;
        System.out.println(knapsack(weights, values, capacity)); // Ожидаемый результат: 50
    }
}
