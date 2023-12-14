package algorithms.medium;

import algorithms.easy.ListNode;

public class RemoveZeroSumSublists {

    public static void main(String[] args) {
//        ListNode node4 = new ListNode(-2);
//        ListNode node3 = new ListNode(-3, node4);
//        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(-1);
        ListNode node = new ListNode(1, node1);
        System.out.println(removeZeroSumSublists(node));
    }

    private static ListNode removeZeroSumSublists(ListNode head) {
        ListNode newHead = new ListNode();
        ListNode headHead = newHead;
        ListNode last = null;
        while (head != null) {
            ListNode node = head;
            int sum = 0;
            while (true) {
                sum += node.val;
                if (sum == 0) {
                    head = node.next;
                    break;
                }
                if (node.next == null) {
                    last = newHead;
                    newHead.val = head.val;
                    newHead.next = new ListNode();
                    newHead = newHead.next;
                    head = head.next;
                    break;
                }
                node = node.next;
            }
        }
        if (last != null) {
            last.next = null;
        }
        return headHead.val == 0 ? null : headHead;
    }
}
