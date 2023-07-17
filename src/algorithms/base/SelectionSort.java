package algorithms.base;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{2, 1, 4, 3, 6, 5})));
    }

    private static int findSmall(int[] array) {
        int smallest = array[0];
        for (int j : array) {
            if (smallest > j) {
                smallest = j;
            }
        }
        return smallest;
    }

    private static int[] sort(int[] array) {
        int length = array.length;
        int[] newArray = new int[length];
        for (int i = 0; i < length; i++) {
            int smallest = findSmall(array);
            newArray[i] = smallest;
            array = delete(array, smallest);
        }
        return newArray;
    }

    private static int[] delete(int[] array, int var1) {
        int[] newArray = new int[array.length - 1];
        int j = 0;
        for (int k : array) {
            if (k == var1)
                continue;
            newArray[j] = k;
            j++;
        }
        return newArray;
    }
}
