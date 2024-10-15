package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class AllOne {

    private Map<String, Integer> keyAndLength;

    public AllOne() {
        keyAndLength = new HashMap<>();
    }

    public void inc(String key) {
        if (!keyAndLength.containsKey(key)) {
            keyAndLength.put(key, 1);
        } else {
            Integer i = keyAndLength.get(key);
            keyAndLength.replace(key, i + 1);
        }
    }

    public void dec(String key) {
        if (keyAndLength.containsKey(key)) {
            Integer i = keyAndLength.get(key);
            i -= 1;
            if (i == 0) {
                keyAndLength.remove(key);
            } else {
                keyAndLength.replace(key, i);
            }
        }
    }

    public String getMaxKey() {
        return null;
    }

    public String getMinKey() {
        return null;
    }
}
