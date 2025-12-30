package leetcode.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms {

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> keys = new HashSet<>();
        return rooms.size() == canVisitAllRooms(rooms, keys, 0, 0);
    }

    public static int canVisitAllRooms(List<List<Integer>> rooms, Set<Integer> keys, int room, int count) {
        if (keys.contains(room)) {
            return count;
        }
        keys.add(room);
        count++;

        for (Integer i : rooms.get(room)) {
            count = canVisitAllRooms(rooms, keys, i, count);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), List.of())));
    }
}
