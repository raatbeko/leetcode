package leetcode.medium;

import leetcode.easy.ListNode;

public class OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode oddStart = head;
        ListNode evenStart = head.next;
        ListNode odd = head;
        ListNode even = head.next;
        head = head.next.next;
        while (head != null) {
            odd.next = head;
            even.next = head.next;

            odd = head;
            even = head.next;

            if (head.next == null) {
                head = null;
            } else
                head = head.next.next;
        }
        odd.next = evenStart;
        return oddStart;
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        System.out.println(oddEvenList(head));
    }
}
