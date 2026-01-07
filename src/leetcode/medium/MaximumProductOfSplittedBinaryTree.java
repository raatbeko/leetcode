package leetcode.medium;

import structure.binaryTree.TreeNode;

public class MaximumProductOfSplittedBinaryTree {
    long lastMax = 0;

    public int maxProduct(TreeNode root) {
        if (root == null) return 0;
        int totalSum = getSum(root);
        findMax(totalSum, root);
        return Math.toIntExact(lastMax % 1_000_000_007);
    }

    public long findMax(int totalSum, TreeNode root) {
        if (root == null) return 0;
        long sum = root.val;

        long rightSum = findMax(totalSum, root.right);
        lastMax = Math.max((totalSum - rightSum) * rightSum, lastMax);

        long leftSum = findMax(totalSum, root.left);
        lastMax = Math.max((totalSum - leftSum) * leftSum, lastMax);

        return sum + rightSum + leftSum;
    }

    public int getSum(TreeNode root) {
        if (root == null) return 0;

        int sum = root.val;
        sum += getSum(root.right);
        sum += getSum(root.left);
        return sum;
    }

    public static void main(String[] args) {
        // Строим дерево:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        MaximumProductOfSplittedBinaryTree solution = new MaximumProductOfSplittedBinaryTree();
        int result = solution.maxProduct(root);

        System.out.println(result);
    }

}
