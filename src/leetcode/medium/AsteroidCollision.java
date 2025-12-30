package leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> integers = new Stack<>();
        integers.add(asteroids[0]);
        int i = 1;
        while (i != asteroids.length) {
            int peek = integers.isEmpty() ? 0 : integers.peek();

            int pop = asteroids[i];
            if (peek > 0 && pop < 0) {
                int newResult = peek + pop;
                if (newResult < 0) {
                    integers.pop();
                    continue;
                }
                if (newResult > 0) {
                    i++;
                    continue;
                }
                integers.pop();
                i++;
                continue;
            }

            if (peek == 0 || peek < 0 && pop != 0 || peek > 0 && pop > 0) {
                integers.add(pop);
                i++;
                continue;
            }

            i++;
        }
        return integers.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5,10,-5})));
    }
}
