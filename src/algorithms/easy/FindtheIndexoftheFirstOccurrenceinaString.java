package algorithms.easy;

public class FindtheIndexoftheFirstOccurrenceinaString {

    public static int strStr(String haystack, String needle) {
        if (!haystack.contains(needle)){
            return -1;
        }
        int needLength = needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            if (!haystack.substring(i, needLength).contains(needle)){
                needLength ++;
                continue;
            }
            return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
//        System.out.println("mississippi".substring(0, "issip".length()));
    }
}
