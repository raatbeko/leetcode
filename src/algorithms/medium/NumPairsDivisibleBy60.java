package algorithms.medium;

import java.util.HashMap;

public class NumPairsDivisibleBy60 {

    public static void main(String[] args) {
        System.out.println(numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
    }

    private static int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int t : time) {
            int remainder = t % 60;
            int complement = (60 - remainder) % 60;

            if (index.containsKey(complement)) {
                count += index.get(complement);
            }

            index.put(remainder, index.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }
}
