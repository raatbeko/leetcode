package leetcode.medium;

import leetcode.easy.ListNode;

public class RemoveNthNodeFromEndOfList {

    int length;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            length--;
            return null;
        }

        length = n;
        ListNode listNode = removeNthFromEnd(head.next, n);
        if (length == 0) {
            length--;
            return listNode;
        } else if (length == -1) {
            head.next = listNode;
        } else {
            length--;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        System.out.println(new RemoveNthNodeFromEndOfList().removeNthFromEnd(listNode, 3));
    }


}
