package algorithms.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTaskSecond {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-5, 3, -2, 7, 10, -1, 4);

        int sum = 0;
        for (Integer integer : numbers.stream()
                // Дополните код здесь
                .filter(item -> item >= 0)
                .toList()) {
            sum += integer;
        }

        System.out.println(sum); // Ожидаемый вывод: 24
    }
}
