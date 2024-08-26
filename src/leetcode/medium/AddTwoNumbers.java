package leetcode.medium;

import leetcode.easy.ListNode;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode initial = l1;
        ListNode last = l1;
        int num = 0;
        while (l1 != null || l2 != null) {
            int lVal = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;

            lVal += l2Val + num;
            if ((lVal / 10) == 1) {
                num = lVal / 10;
                lVal = lVal % 10;
            }else {
                num = 0;
            }
            if (l1 != null) {
                l1.val = lVal;
                if (l1.next == null)
                    last = l1;
                l1 = l1.next;
            } else {
                last.next = new ListNode(lVal);;
                last = last.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (num == 1){
            last.next = new ListNode(1);
        }
        return initial;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l1, l2));
    }
}
