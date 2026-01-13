package leetcode.medium;

import leetcode.easy.ListNode;

public class ReverseLinkedListII {
    ListNode leftPrev;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;

        ListNode leftNode = findThePoint(head, left, 1);
        ListNode currentLeftPrev = leftPrev;

        ListNode rightNode = findThePoint(head, right, 1);

        ListNode rightNext = rightNode.next;
        rightNode.next = null;

        ListNode listNode = reverseList(leftNode);
        leftNode.next = rightNext;
        if (currentLeftPrev != null) {
            currentLeftPrev.next = listNode;
        } else {
            return rightNode;
        }


        return head;
    }

    public ListNode findThePoint(ListNode head, int pointToReached, int level) {
        if (head.next == null) return head;
        if (level == pointToReached) return head;

        leftPrev = head;
        return findThePoint(head.next, pointToReached, level + 1);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;

            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
//        ListNode node7 = new ListNode(7);
//        ListNode node6 = new ListNode(6, node7);
//        ListNode node5 = new ListNode(5, node6);
//        ListNode node4 = new ListNode(4, node5);
//        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, null);
        ListNode head = new ListNode(1, node2);

        System.out.println(head);
        System.out.println(new ReverseLinkedListII().reverseBetween(head, 1, 1));
    }
}
