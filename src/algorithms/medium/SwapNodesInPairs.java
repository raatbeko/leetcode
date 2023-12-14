package algorithms.medium;

import algorithms.easy.ListNode;

public class SwapNodesInPairs {

    public static ListNode swapPairs(ListNode head) {
        ListNode node = head;
        ListNode next = head != null && head.next != null ? head.next : head;
        ListNode prev = null;
        while (node != null) {
            System.out.println("1");
            if (node.next != null) {
                if (prev != null) {
                    prev.next = node.next;
                }
                prev = node;
                ListNode list = node.next.next;
                node.next.next = node;
                node.next = list;
                node = list;
            } else {
                node = null;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        System.out.println(swapPairs(listNode));
    }
}