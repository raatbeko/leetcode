package leetcode.medium;

import structure.binaryTree.TreeNode;

public class LongestZigZagPathInBinaryTree {

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;

        int left = countLeft(-1, root);
        int right = countRight(-1, root);

        int nextLeft = longestZigZag(root.left);
        int nextRight = longestZigZag(root.right);

        return Math.max(
                Math.max(left, right),
                Math.max(nextLeft, nextRight)
        );
    }

    private static int countLeft(int count, TreeNode root) {
        if (root == null) return count;
        count++;
        return countRight(count, root.right);
    }

    private static int countRight(int count, TreeNode root) {
        if (root == null) return count;
        else count++;
        return countLeft(count, root.left);
    }
}
