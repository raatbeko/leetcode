package algorithms.easy;

import algorithms.base.TreeNode;

public class MaximumDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        int rightCount = 1;
        int leftCount = 1;
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            leftCount += maxDepth(root.left);
        }
        if (root.right != null) {
            rightCount += maxDepth(root.right);
        }
        return Math.max(rightCount, leftCount);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(2);
        System.out.println(maxDepth(root));
    }
}
