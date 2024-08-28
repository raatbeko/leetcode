package algorithms.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class StreamTaskOne {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "apricot", "Avocado", "grape");

        List<String> result = words.stream()
                .filter(item-> item.toLowerCase(Locale.ROOT).startsWith("a"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(result); // Ожидаемый вывод: [APPLE, APRICOT, AVOCADO]
    }
}
