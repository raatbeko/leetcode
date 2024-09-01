package leetcode.medium;

import java.util.HashSet;

public class RandomizedSet {

    private HashSet<Integer> set;

    public RandomizedSet() {
        this.set = new HashSet<>();
    }

    public boolean insert(int val) {
        if (!set.contains(val)) {
            set.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        return 0;
    }
}
