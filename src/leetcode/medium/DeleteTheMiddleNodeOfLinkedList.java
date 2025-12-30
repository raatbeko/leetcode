package leetcode.medium;

import leetcode.easy.ListNode;

public class DeleteTheMiddleNodeOfLinkedList {

    public static ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        ListNode preSlow = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        preSlow.next = slow.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(6);

        System.out.println(deleteMiddle(node7));
    }
}
