package algorithms.easy;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestPrefix(new String[]{"flower","flow","flight"}));
    }

    public static String longestPrefix(String[] strs) {
        String prefix = strs[0];
        String longest = strs[0];

        for (int j = 1; j < strs.length; j++) {
            for (int k = prefix.length(); k > 0; k--) {
                prefix = prefix.substring(0, k);
                if (strs[j].startsWith(prefix)) {
                    longest = prefix;
                    k = 0;
                } else {
                    longest = "";
                }
            }
            if (longest.equals(""))
                return "";
        }
        return longest;
    }
}
