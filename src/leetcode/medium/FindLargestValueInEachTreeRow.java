package leetcode.medium;

import structure.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLargestValueInEachTreeRow {
    Map<Integer, Integer> levelAndMax = new HashMap<>();
    ArrayList<Integer> maxInRow = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        findMaxInRow(0, root);
        return maxInRow;
    }

    public void findMaxInRow(int level, TreeNode root) {
        if (root == null) return;
        if (levelAndMax.getOrDefault(level, Integer.MIN_VALUE) <= root.val) {
            if (levelAndMax.containsKey(level)) {
                maxInRow.set(level, root.val);
            } else {
                maxInRow.add(root.val);
            }
            levelAndMax.put(level, root.val);
        }
        findMaxInRow(level + 1, root.left);
        findMaxInRow(level + 1, root.right);
    }
}
