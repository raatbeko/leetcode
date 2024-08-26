package leetcode.easy;

public class AddBinary {

//    public String addBinary(String a, String b) {
//        String s = "";
//        int length = a.length() > b.length() ? a.length() : b.length();
//    }

    private static String binary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int al = a.length() - 1, bl = b.length() - 1;
        while (al >= 0 || bl >= 0) {
            char aCh = al >= 0 ? a.charAt(al) : '0';
            char bCh = bl >= 0 ? b.charAt(bl) : '0';
            if (aCh == '1' && bCh == '1') {
                result.insert(0, (carry));
                carry = 1;
            }
            if (aCh == '1' && bCh == '0' || aCh == '0' && bCh == '1') {
                if (carry != 1) {
                    result.insert(0, 1);
                } else {
                    result.insert(0, 0);
                }
            }
            if (aCh == '0' && bCh == '0') {
                if (carry == 1) {
                    result.insert(0, carry);
                    carry = 0;
                } else {
                    result.insert(0, 0);
                }
            }

            al--;
            bl--;
        }
        if (carry == 1) {
            result.insert(0, 1);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(binary("10110000", "10110000"));
    }
}
