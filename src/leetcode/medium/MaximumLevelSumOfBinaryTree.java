package leetcode.medium;

import structure.binaryTree.TreeNode;

import java.util.Map;
import java.util.TreeMap;

public class MaximumLevelSumOfBinaryTree {

    static int currentLevel = Integer.MIN_VALUE;
    static int maxSum = Integer.MIN_VALUE;

    public static int maxLevelSum(TreeNode root) {
        TreeMap<Integer, Integer> integerIntegerHashMap = new TreeMap<>();
        count(integerIntegerHashMap, 1, root);

        for (Map.Entry<Integer, Integer> integerIntegerEntry : integerIntegerHashMap.entrySet()) {
            if (integerIntegerEntry.getValue() > maxSum) {
                maxSum = integerIntegerEntry.getValue();
                currentLevel = integerIntegerEntry.getKey();
            }
        }
        return currentLevel;
    }

    private static void count(Map<Integer, Integer> levelAndSum, int level, TreeNode root) {
        if (root == null) return;

        levelAndSum.put(level, levelAndSum.getOrDefault(level, 0) + root.val);
        count(levelAndSum, level + 1, root.left);
        count(levelAndSum, level + 1, root.right);
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

        System.out.println(maxLevelSum(root));
        System.out.println(maxLevelSum(new TreeNode(1)));
    }
}
