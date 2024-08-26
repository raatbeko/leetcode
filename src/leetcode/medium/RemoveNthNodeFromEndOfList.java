package leetcode.medium;

import leetcode.easy.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode slow = head;
        while (slow != null) {
            nodes.add(slow);
            slow = slow.next;
        }
        if (nodes.size() > 1){
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        System.out.println(removeNthFromEnd(listNode, 1));
    }


}
