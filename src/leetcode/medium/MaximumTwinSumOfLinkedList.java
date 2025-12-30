package leetcode.medium;

import leetcode.easy.ListNode;

import java.util.Stack;

public class MaximumTwinSumOfLinkedList {
    public static int pairSum(ListNode head) {
        Stack<Integer> integers = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            integers.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        int maxSum = 0;
        while (slow != null) {
            int val = slow.val;
            int sum = integers.pop() + val;
            if (sum > maxSum) {
                maxSum = sum;
            }
            slow = slow.next;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);
        System.out.println(pairSum(head));
    }
}
