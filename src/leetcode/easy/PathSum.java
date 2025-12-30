package leetcode.easy;

import structure.binaryTree.TreeNode;

public class PathSum {

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        return count(0, targetSum, root);
    }

    private static boolean count(int sum, int target, TreeNode root) {
        if (root == null) return false;

        sum += root.val;
        if (root.left == null && root.right == null)
            if (sum == target) {
                return true;
            }

        boolean left = count(sum, target, root.left);
        boolean right = count(sum, target, root.right);
        return left || right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        root.right.right = new TreeNode(11);
        int targetSum = 15;

        System.out.println(hasPathSum(root, targetSum));
    }
}
