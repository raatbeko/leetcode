package leetcode.easy;

import structure.binaryTree.TreeNode;

public class BalancedBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int left = height(root.left);
        int right = height(root.right);
        boolean global = Math.abs(left - right) <= 1;
        return global && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        int right = height(root.right);
        int left = height(root.left);
        return 1 + Math.max(right, left);
    }

    public static void main(String[] args) {
        // Level 0
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(isBalanced(root));
    }
}
