package leetcode.medium;

import structure.binaryTree.TreeNode;

public class SmallestSubtreeWithAllTheDeepestNodes {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return find(maxDepth(root), 1, root);
    }

    public TreeNode find(int maxDepth, int level, TreeNode root) {
        if (root == null) return null;
        if (maxDepth-1 == level){
            return root;
        }

        TreeNode left = find(maxDepth, level+1, root.left);
        TreeNode right = find(maxDepth, level+1, root.right);

        if (left != null && right != null){
            return root;
        }

        return left != null ? left : right;
    }

    public int maxDepth(TreeNode root) {
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
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println(new SmallestSubtreeWithAllTheDeepestNodes().subtreeWithAllDeepest(root));
    }
}
