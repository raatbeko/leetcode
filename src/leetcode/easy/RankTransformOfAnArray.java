package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

public class RankTransformOfAnArray {

    public static int[] arrayRankTransform(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rankCount = 1;
        for (int i : newArr) {
            if (!rankMap.containsKey(i)) {
                rankMap.put(i, rankCount);
                rankCount += 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            Integer i1 = rankMap.get(arr[i]);
            arr[i] = i1;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12})));
    }
}
