package leetcode.easy;

import structure.binaryTree.TreeNode;

public class MinimumDepthOfBinaryTree {

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int rightLength = 1;
        int leftLength = 1;


        return rightLength == 1 ? leftLength : leftLength == 1 ? rightLength : Math.min(rightLength, leftLength);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.right = new TreeNode(3);
        p.right.right.right = new TreeNode(4);
        p.right.right.right.right = new TreeNode(4);
        System.out.println(minDepth(p));
    }

}
