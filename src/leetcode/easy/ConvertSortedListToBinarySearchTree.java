package leetcode.easy;

import structure.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head != null){
            values.add(head.val);
            head = head.next;
        }
        return create(values, 0, values.size());
    }

    private TreeNode create(List<Integer> nums, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
            TreeNode initial = new TreeNode(nums.get(mid));

            initial.left = create(nums, left, mid - 1);
            initial.right = create(nums, mid + 1, right);
            return initial;
        }
        return null;
    }

}
