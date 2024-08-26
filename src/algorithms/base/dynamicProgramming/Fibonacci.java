package algorithms.base.dynamicProgramming;

/**
 * Решение задачи нахождения числа Фибоначчи с помощью динамического программирования.
 * <p>
 * В этой задаче необходимо найти n-е число Фибоначчи, где числа Фибоначчи определяются
 * рекуррентным соотношением F(n) = F(n-1) + F(n-2), с начальными условиями F(0) = 0 и F(1) = 1.
 * </p>
 */
public class Fibonacci {

    /**
     * Находит n-е число Фибоначчи, используя динамическое программирование.
     *
     * @param n Индекс числа Фибоначчи, которое требуется найти. Значение должно быть неотрицательным.
     * @return n-е число Фибоначчи.
     * @throws IllegalArgumentException Если значение параметра n отрицательное.
     */
    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Индекс числа Фибоначчи не может быть отрицательным.");
        }
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(fibonacci(n)); // Ожидаемый результат: 55
    }
}

