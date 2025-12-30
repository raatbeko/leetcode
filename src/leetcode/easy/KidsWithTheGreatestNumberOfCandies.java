package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            if (candy > max) {
                max = candy;
            }
        }
        ArrayList<Boolean> booleans = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies > max) {
                booleans.add(true);
            } else {
                booleans.add(false);
            }
        }
        return booleans;
    }
}
