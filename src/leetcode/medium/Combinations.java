package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        subset(n, k,1, lists, new ArrayList<>());
        return lists;
    }

    private static void subset(int n, int k, int start, List<List<Integer>> lists, List<Integer> current) {
        if (current.size() == k) {
            lists.add(new ArrayList<>(current));
            return;
        }

        // Проходим по всем числам от start до n
        for (int i = start; i <= n; i++) {
            current.add(i);
            subset(n, k, i + 1, lists, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 3));
    }
}
