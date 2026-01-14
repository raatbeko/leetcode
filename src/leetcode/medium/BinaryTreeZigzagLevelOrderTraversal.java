package leetcode.medium;

import structure.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> link = new ArrayList<>();
        if (root == null) return link;
        Stack<TreeNode> nodes = new Stack<>();
        nodes.add(root);
        link.add(List.of(root.val));

        Stack<TreeNode> child = new Stack<>();
        List<Integer> list = new ArrayList<>();

        boolean zigzag = false;
        while (!nodes.isEmpty()) {
            TreeNode peek = nodes.pop();
            if (zigzag) {
                if (peek.left != null) {
                    child.add(peek.left);
                    list.add(peek.left.val);
                }
                if (peek.right != null) {
                    child.add(peek.right);
                    list.add(peek.right.val);
                }
            } else {
                if (peek.right != null) {
                    child.add(peek.right);
                    list.add(peek.right.val);
                }
                if (peek.left != null) {
                    child.add(peek.left);
                    list.add(peek.left.val);
                }
            }

            if (nodes.isEmpty()) {
                nodes = child;
                child = new Stack<>();
                zigzag = !zigzag;
                if (!list.isEmpty()) {
                    link.add(list);
                    list = new ArrayList<>();
                }
            }
        }

        return link;
    }
}
