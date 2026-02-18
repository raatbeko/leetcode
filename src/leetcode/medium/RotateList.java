package leetcode.medium;

import leetcode.easy.ListNode;

import java.util.HashMap;
import java.util.Map;

public class RotateList {

    ListNode first = null;
    ListNode last = null;
    Map<ListNode, ListNode> preElements = new HashMap<>();

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        first = head;

        ListNode next = head;
        ListNode preEl = null;
        while (next != null) {
            preElements.put(next, preEl);

            if (next.next == null) {
                last = next;
            }
            preEl = next;
            next = next.next;
        }

        for (int i = 0; i < k; i++) {
            last.next = first;
            preElements.put(first, last);
            first = last;

            last = preElements.get(last);
            last.next = null;
        }
        return first;
    }
}
