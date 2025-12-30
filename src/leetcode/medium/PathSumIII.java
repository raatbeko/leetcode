package leetcode.medium;

import structure.binaryTree.TreeNode;

public class PathSumIII {

    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int count = count(0, 0, targetSum, root);

        count += pathSum(root.left, targetSum);
        count += pathSum(root.right, targetSum);
        return count;
    }

    private static int count(int count, long sum, int target, TreeNode root) {
        if (root == null) return count;

        sum += root.val;
        if (sum == target) {
            count++;
        }
        count += count(0, sum, target, root.left);
        count += count(0, sum, target, root.right);

        return count;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1000000000);
        root.left = new TreeNode(1000000000);
        root.left.left = new TreeNode(294967296);
        root.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left.left = new TreeNode(1000000000);
        int targetSum = 2000000000;


        System.out.println(pathSum(root, targetSum));
    }
}
