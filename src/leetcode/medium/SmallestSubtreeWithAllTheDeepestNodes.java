package leetcode.medium;

import structure.binaryTree.TreeNode;

public class SmallestSubtreeWithAllTheDeepestNodes {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return find(root);
    }

    public TreeNode find(TreeNode root) {
        if (root == null) return null;

        int leftCount = maxDepth(root.left);
        int rightCount = maxDepth(root.right);

        if (leftCount == rightCount) {
            return root;
        }
        if (leftCount > rightCount) {
            return find(root.left);
        }
        return find(root.right);
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
