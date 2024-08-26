package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        mapSum.sum("ap");           // return 3 (apple = 3)
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));

    }

    Map<String, Integer> values = new HashMap<>();

    public MapSum() {

    }

    public void insert(String key, int val) {
        values.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (Map.Entry<String, Integer> set : values.entrySet()) {
            if (set.getKey().startsWith(prefix))
                sum += set.getValue();
        }
        return sum;
    }
}
