package leetcode.easy;

import structure.binaryTree.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = right;
        invertTree(left);
        invertTree(right);

        return root;
    }
}
