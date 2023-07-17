package algorithms.base;

import java.util.Objects;

public class HashFunction {
    public static void main(String[] args) {
        System.out.println(hashIndex("a"));
    }

    private static int hashNum(Objects objects){
        return 1;
    }

    private static int hashLength(String s){
        return s.length();
    }

    private static int hashIndex(String s){
        return s.charAt(0);
    }

}
