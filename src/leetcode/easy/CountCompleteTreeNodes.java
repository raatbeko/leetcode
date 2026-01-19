package leetcode.easy;

import structure.binaryTree.TreeNode;

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int count = 1;
        count += countNodes(root.left);
        count += countNodes(root.right);
        return count;
    }
}
