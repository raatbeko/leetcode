package leetcode.medium;

import structure.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> arrayLists = new ArrayList<>();
        collect(arrayLists, new ArrayList<>(), 0, targetSum, root);
        return arrayLists;
    }

    private static void collect(List<List<Integer>> arrayLists, ArrayList<Integer> lists, int sum, int target, TreeNode root) {
        if (root == null) return;

        lists.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null)
            if (sum == target) {
                arrayLists.add(new ArrayList<>(lists));
            }

        collect(arrayLists, lists, sum, target, root.left);
        collect(arrayLists, lists, sum, target, root.right);

        lists.remove(lists.size() - 1);
    }
}
