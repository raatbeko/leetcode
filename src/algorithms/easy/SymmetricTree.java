package algorithms.easy;

import algorithms.base.TreeNode;

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode right, TreeNode left) {
        if (right == null && left == null) {
            return true;
        }
        if (right == null || left == null) {
            return false;
        }
        if (right.val != left.val) {
            return false;
        }
        return isSymmetric(right.left, left.right) && isSymmetric(right.right, left.left);

    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(2);
        p.left.left = new TreeNode(3);
        p.left.right = new TreeNode(4);
        System.out.println(isSymmetric(p));
    }
}
