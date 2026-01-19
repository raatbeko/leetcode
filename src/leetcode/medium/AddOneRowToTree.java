package leetcode.medium;

import structure.binaryTree.TreeNode;

public class AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode newNode = root;
        if (depth == 1) {
            newNode = new TreeNode();
            newNode.val = val;
            newNode.right = root;
            return newNode;
        }
        return addOneRow(root, 1, val, depth);
    }

    public TreeNode addOneRow(TreeNode root, int level, int val, int depth) {
        if (root == null) return null;

        if (level + 1 == depth) {
            TreeNode treeNode = new TreeNode();
            treeNode.val = val;
            treeNode.left = addOneRow(root.left, level + 1, val, depth);
            treeNode.right = addOneRow(root.right, level + 1, val, depth);

            return treeNode;
        }
        root.left = addOneRow(root.left, level + 1, val, depth);
        root.right = addOneRow(root.right, level + 1, val, depth);
        return root;
    }
}
