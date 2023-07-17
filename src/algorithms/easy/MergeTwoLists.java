package algorithms.easy;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeTwoLists {

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode newList = new ListNode();
        ListNode next = newList;

        while (true) {
            if (list1.val <= list2.val) {
                newList.val = list1.val;
                newList.next = list2;
                newList.next.next = new ListNode();
                newList = next.next;
                list1 = list1.next;
                list2 = list2.next;
            }
        }
    }
}
