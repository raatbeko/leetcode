package leetcode.medium;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CanMakeSubsequence {

    public static void main(String[] args) {
        LocalDateTime startDate = LocalDateTime.parse("2023-09-25T19:20:52.171582");
        LocalDateTime endDate = LocalDateTime.parse("2023-09-21T19:13:42.444476");

        LocalDateTime updateAt = LocalDateTime.parse("2023-09-12T16:30:13");

        long oldTtl = ChronoUnit.SECONDS.between(startDate, endDate);
        long newTtl = ChronoUnit.SECONDS.between(updateAt, endDate);
        System.out.println(oldTtl);
        System.out.println();

        System.out.println(startDate.plusSeconds(newTtl));
        System.out.println(startDate.plusSeconds(newTtl).isBefore(updateAt));
        System.out.println();

        LocalDateTime testUpdateAt = LocalDateTime.parse("2023-09-11T16:30:13");
        newTtl = ChronoUnit.SECONDS.between(testUpdateAt, endDate);

        System.out.println(startDate.plusSeconds(newTtl));
        System.out.println(startDate.plusSeconds(newTtl).isBefore(testUpdateAt));

//        System.out.println(ChronoUnit.SECONDS.between(LocalDateTime.parse("2023-09-13T16:30:13"), LocalDateTime.parse("2023-09-21T19:13:42")));
//        System.out.println(LocalDateTime.parse("2023-09-12T16:30:13").plusSeconds(355409));
    }

    public static boolean canMakeSubsequence(String str1, String str2) {
        StringBuilder newStr = new StringBuilder();

        char[] chars = str1.toCharArray();
        for (char aChar : chars) {
            newStr.append(subSequence(aChar));
        }
        String str = newStr.toString();

        return str.contains(str2) || str2.contains(str);
    }

    private static char subSequence(char c) {
        if (c == 'z') {
            return 'a';
        }
        boolean flag = false;
        for (char i = 'a'; i < 'z'; i++) {
            if (flag) {
                return i;
            }
            if (c == i) {
                flag = true;
            }
        }
        return ' ';
    }


}
