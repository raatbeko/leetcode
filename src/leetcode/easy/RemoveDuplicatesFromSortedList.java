package leetcode.easy;

public class RemoveDuplicatesFromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode item = head;
        if (head == null)
            return null;
        while (item.next != null) {
            if (item.val == item.next.val) {
                item.next = item.next.next;
            } else {
                item = item.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
