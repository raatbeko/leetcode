package leetcode.medium;

public class IntegerToRoman {

    public static void main(String[] args) {

        System.out.println(intToRoman(20));

    }

    private static String intToRoman(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        int length = nums.length;
        String roman = "";
        for (int i = 0; i < nums.length; i++) {
            int n = Integer.parseInt(String.valueOf(nums[i]));
            if (length == 4) {
                for (int M = 0; M < n; M++) {
                    roman += returnChar(1000);
                }
                length--;
                continue;
            }
            if (length == 3) {
                if (Integer.toString(n + 1).length() == 2) {
                    roman += returnChar(100);
                    roman += returnChar(1000);
                    length--;
                    continue;
                }
                if (n + 1 == 5) {
                    roman += returnChar(100);
                    roman += returnChar(500);
                    length--;
                    continue;
                }

                if (n >= 5) {
                    n = n - 5;
                    roman += returnChar(500);
                    for (int D = 0; D < n; D++) {
                        roman += returnChar(100);
                    }
                    length--;
                    continue;
                }
                if (n + 1 < 5) {
                    for (int I = 0; I < n; I++) {
                        roman += returnChar(100);
                    }
                    length--;
                    continue;
                }
            }

            if (length == 2) {
                if (Integer.toString(n + 1).length() == 2) {
                    roman += returnChar(10);
                    roman += returnChar(100);
                    length--;
                    continue;
                }
                if (n + 1 == 5) {
                    roman += returnChar(10);
                    roman += returnChar(50);
                    length--;
                    continue;
                }

                if (n >= 5) {
                    n = n - 5;
                    roman += returnChar(50);
                    for (int D = 0; D < n; D++) {
                        roman += returnChar(10);
                    }
                    length--;
                    continue;
                }
                if (n + 1 < 5) {
                    for (int I = 0; I < n; I++) {
                        roman += returnChar(10);
                    }
                    length--;
                    continue;
                }
            }

            if (length == 1) {
                if (Integer.toString(n + 1).length() == 2) {
                    roman += returnChar(1);
                    roman += returnChar(10);
                    length--;
                    continue;
                }
                if (n + 1 == 5) {
                    roman += returnChar(1);
                    roman += returnChar(5);
                    length--;
                    continue;
                }

                if (n >= 5) {
                    n = n - 5;
                    roman += returnChar(5);
                    for (int D = 0; D < n; D++) {
                        roman += returnChar(1);
                    }
                    length--;
                    continue;
                }
                if (n + 1 < 5) {
                    for (int I = 0; I < n; I++) {
                        roman += returnChar(1);
                    }
                    length--;
                }
            }
        }
        return roman;
    }

    private static char returnChar(int s) {
        char num = switch (s) {
            case 1:
                yield 'I';
            case 5:
                yield 'V';
            case 10:
                yield 'X';
            case 50:
                yield 'L';
            case 100:
                yield 'C';
            case 500:
                yield 'D';
            case 1000:
                yield 'M';
            default:
                throw new IllegalStateException("Unexpected value: " + s);
        };
        return num;
    }
}
