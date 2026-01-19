package leetcode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator {
}

class NestedIterator implements Iterator<Integer> {

    int i = 0;
    ArrayList<Integer> integers = new ArrayList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        init(nestedList);
    }

    private void init(List<NestedInteger> nestedList) {
        nestedList.forEach(item -> {
            if (item.isInteger()) {
                integers.add(item.getInteger());
            } else {
                init(item.getList());
            }
        });
    }

    @Override
    public Integer next() {
        if (i >= integers.size()) return 0;
        var val = integers.get(i);
        i++;
        return val;
    }

    @Override
    public boolean hasNext() {
        return i < integers.size();
    }
}
