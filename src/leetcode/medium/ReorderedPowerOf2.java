package leetcode.medium;

public class ReorderedPowerOf2 {

    private static boolean reorderedPowerOf2(int n){
        String strNumber = String.valueOf(n);

        for (int i = 1; i < strNumber.length(); i++) {
            if (strNumber.charAt(i) < strNumber.charAt(i - 1)) {
                return false;
            }
        }

        return true;
    }
}
