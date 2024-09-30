package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            count(l, i, n);
        }
        return l;
    }

    private static void count(List<Integer> l, int currentNum, int n) {
        int num = currentNum;
        if (currentNum > n){
            return;
        } else if(currentNum == n){
            l.add(num);
            return;
        }
        l.add(num);
        count(l, num * 10, n);
        if (num >= 10)
            for (int i = 0; i < 10 - 1; i++) {
                num += 1;
                if (num > n) return;
                l.add(num);
                count(l, num * 10, n);
            }
    }

    public static void main(String[] args) {
        System.out.println(lexicalOrder(192));
    }
}
