package leetcode.easy;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {

    public static int minimumRecolors(String blocks, int k) {

        if (blocks == null || blocks.length() < k || k <= 0) {
            return 0;
        }
        char[] charArray = blocks.toCharArray();
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (charArray[i] == 'W') count++;
        }
        int minCount = count;
        for (int i = k; i < charArray.length; i++) {
            if (charArray[i-k] == 'W')
                --count;

            if (charArray[i] == 'W')
                ++count;

            if (count < minCount) {
                minCount = count;
            }

            if (count == 0) return 0;
        }
        return minCount;
    }

    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBBWWBBWBW", 7));
    }
}
