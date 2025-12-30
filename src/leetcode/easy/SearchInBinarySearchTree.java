package leetcode.easy;

import structure.binaryTree.TreeNode;

public class SearchInBinarySearchTree {
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) return root;
        System.gc();
        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);
        return left != null ? left : right;
    }
}
