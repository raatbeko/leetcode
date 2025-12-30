package leetcode.medium;

import structure.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CountGoodNodesInBinaryTree {

    public static int goodNodes(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        count(integers, Integer.MIN_VALUE, root);
        return integers.size();
    }

    private static void count(List<Integer> nums, int max, TreeNode root) {
        if (root == null)return;
        if (max <= root.val) {
            nums.add(max);
            max = root.val;
        }

        count(nums, max, root.left);
        count(nums, max, root.right);
    }
}
