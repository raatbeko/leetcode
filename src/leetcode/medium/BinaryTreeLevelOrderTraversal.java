package leetcode.medium;

import structure.binaryTree.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> link = new ArrayList<>();
        if (root == null) return link;
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);
        link.add(List.of(root.val));

        Queue<TreeNode> child = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        while (!nodes.isEmpty()) {
            TreeNode peek = nodes.poll();
            if (peek.left != null) {
                child.add(peek.left);
                list.add(peek.left.val);
            }
            if (peek.right != null) {
                child.add(peek.right);
                list.add(peek.right.val);
            }
            if (nodes.isEmpty()) {
                nodes = child;
                child = new ArrayDeque<>();
                if (!list.isEmpty()) {
                    link.add(list);
                    list = new ArrayList<>();
                }
            }
        }
        Collections.reverse(link);
        return link;
    }
}
