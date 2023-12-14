package algorithms.easy;

import algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        if (root == null)
            return integers;
        return integers;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(postorderTraversal(root));
    }
}
