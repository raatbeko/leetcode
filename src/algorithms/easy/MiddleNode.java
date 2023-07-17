package algorithms.easy;

import java.util.ArrayList;
import java.util.List;

public class MiddleNode {
    private static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> nodes = new ArrayList<>();

        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        int middle = (nodes.size() / 2) +
                1;
        return nodes.get(middle);
    }
}
