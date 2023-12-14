package algorithms.easy;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode newNode = new ListNode();
        ListNode peek = newNode;
        while (list2 != null && list1 != null) {
            if (list1.val <= list2.val) {
                newNode.val = list1.val;
                list1 = list1.next;
                if (list1 != null) {
                    newNode.next = new ListNode();
                    newNode = newNode.next;
                }
            } else {
                newNode.val = list2.val;
                list2 = list2.next;
                if (list2 != null) {
                    newNode.next = new ListNode();
                    newNode = newNode.next;
                }
            }
        }
        if (list1 != null) {
            newNode.next = list1;
        } else if (list2 != null) {
            newNode.next = list2;
        }
        return peek;
    }
}
