package leetcode.easy;

import structure.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        addToList(integers, root);
        return integers;
    }

    public void addToList(List<Integer> integers, TreeNode root) {
        addToList(integers, root.left);
        integers.add(root.val);
        addToList(integers, root.right);
    }
}
