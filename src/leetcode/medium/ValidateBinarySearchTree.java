package leetcode.medium;

import structure.binaryTree.TreeNode;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValid(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }

    public boolean isValid(long min, long max, TreeNode root) {
        return  root == null ||
                !(root.val <= min || root.val >= max) &&
                isValid(min, root.val, root.left) &&
                isValid(root.val, max, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2147483648);
        root.right = new TreeNode(2147483647);

        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        System.out.println(validateBinarySearchTree.isValidBST(root));
    }
}
