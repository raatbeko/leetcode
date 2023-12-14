package algorithms.easy;

import algorithms.base.TreeNode;

public class BalancedBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int left = height(root.left);
        int right = height(root.right);
        return left - 1 == right || right - 1 == left || right == left;
    }

    private static int height(TreeNode root) {
        if (root == null)
            return 0;
        int rightLength = 1;
        int leftLength = 1;

        rightLength += height(root.right);
        leftLength += height(root.left);
        return Math.max(rightLength, leftLength);
    }

    public static void main(String[] args) {
        // Level 0
        TreeNode root = new TreeNode(1);

        // Level 1
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        // Level 2
        root.left.left = new TreeNode(3);
        root.left.right = null;
        root.right.left = null;
        root.right.right = new TreeNode(3);

        // Level 3
        root.left.left.left = new TreeNode(4);
        root.left.left.right = null;
        root.right.right.right = new TreeNode(4);
        System.out.println(isBalanced(root));
    }
}
