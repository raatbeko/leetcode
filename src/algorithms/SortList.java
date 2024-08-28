//package algorithms;
//
//import algorithms.easy.ListNode;
//
//public class SortList {
//    public ListNode sortList(ListNode head) {
//        ListNode val = head;
//        while (true ) {
//            ListNode next = head;
//            while (next != null) {
//                if (next.next != null) {
//                    if (next.val > next.next.val) {
//                        int nextVal = next.val;
//                        next.val = next.next.val;
//                        next.next.val = nextVal;
//                        next = next.next;
//                    } else {
//                        next = next.next;
//                    }
//                } else {
//                    next = null;
//                }
//            }
//        }
//    }
//}
