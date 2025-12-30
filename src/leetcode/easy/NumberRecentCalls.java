package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class NumberRecentCalls {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        recentCounter.ping(1);
        recentCounter.ping(100);
        recentCounter.ping(3001);
        recentCounter.ping(3002);
    }
}

class RecentCounter {
    Queue<Integer> list;

    public RecentCounter() {
        list = new LinkedList<>();
    }

    public int ping(int t) {
        if (list.isEmpty()) {
            list.add(t);
            return list.size();
        }
        while (!list.isEmpty() && list.peek() < t - 3000) {
            list.poll();
        }
        list.add(t);
        System.out.println(list.size());
        return list.size();
    }
}

