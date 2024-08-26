package leetcode.easy;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(makeToInt("LVIII"));
    }

    private static int makeToInt(String s) {
        char[] roman = s.toCharArray();
        int num = 0;
        int length = roman.length;
        for (int i = 0; i < length; i++) {
            int currentNum = returnInt(roman[i]);
            if (i + 1 < roman.length)
                if (currentNum < returnInt(roman[i + 1])) {
                    currentNum = returnInt(roman[i + 1]) - currentNum;
                    num += currentNum;
                    ++i;
                    continue;
                }
            num += returnInt(roman[i]);
        }
        return num;
    }

    private static int returnInt(char s) {
        int num = switch (s) {
            case 'I':
                yield 1;
            case 'V':
                yield 5;
            case 'X':
                yield 10;
            case 'L':
                yield 50;
            case 'C':
                yield 100;
            case 'D':
                yield 500;
            case 'M':
                yield 1000;
            default:
                throw new IllegalStateException("Unexpected value: " + s);
        };
        return num;
    }
}
