package algorithms.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isBlank())
            return new ArrayList<>();

        return combination(digits, "", 0, "");
    }

    private List<String> combination(String digit, String currentNum, int i, String letter) {
        List<String> combinations = new ArrayList<>();
        String num = String.valueOf(digit.charAt(i)); // A
        i += 1;
        String let = letter;
        for (String s : getLetter(num)) {
            let += s;
            if (let.length() < digit.length()) {
                combinations.addAll(combination(digit, num, i, let));
            } else {
                combinations.add(let);
            }
            let = letter;
        }
        return combinations;
    }

    private String[] getLetter(String digits) {
        Map<String, String[]> letter = new HashMap<>();

        letter.put("2", new String[]{"a", "b", "c"});
        letter.put("3", new String[]{"d", "e", "f"});
        letter.put("4", new String[]{"g", "h", "i"});
        letter.put("5", new String[]{"j", "k", "l"});
        letter.put("6", new String[]{"m", "n", "o"});
        letter.put("7", new String[]{"p", "q", "r", "s"});
        letter.put("8", new String[]{"t", "u", "v"});
        letter.put("9", new String[]{"w", "x", "y", "z"});

        return letter.get(digits);
    }
}
