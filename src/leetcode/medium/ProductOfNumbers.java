package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {
    private List<Integer> nums = new ArrayList<>();
    private int[] prefix;

    public ProductOfNumbers() {
    }

    public void add(int num) {
        nums.add(num);

        if (num == 0) {
            prefix = new int[nums.size()];
            return;
        }
        int pref = 1;

        prefix = new int[nums.size()];
        int j = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums.get(i) == 0) return;

            prefix[j] = nums.get(i) * pref;
            pref = nums.get(i) * pref;
            j++;
        }
    }


    public int getProduct(int k) {

        System.out.println(prefix[k - 1]);
        return prefix[k - 1];
    }

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);
        productOfNumbers.getProduct(2);
        productOfNumbers.getProduct(3);
        productOfNumbers.getProduct(4);
        productOfNumbers.add(8);
        productOfNumbers.getProduct(2);
    }
}
