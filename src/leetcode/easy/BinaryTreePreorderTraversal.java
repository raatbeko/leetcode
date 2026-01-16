package leetcode.easy;

import structure.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        get(numbers, root);
        return numbers;
    }

    public void get(List<Integer> integers, TreeNode root) {
        if (root == null) return;
        integers.add(root.val);
        get(integers, root.left);
        get(integers, root.right);
    }
}
