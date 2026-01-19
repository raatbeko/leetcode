package leetcode.medium;

import structure.binaryTree.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator {
}

class BSTIterator {

    Stack<Integer> roots = new Stack<>();

    public BSTIterator(TreeNode root) {
        init(root);
    }

    private void init(TreeNode root) {
        if (root == null) return;
        init(root.right);
        roots.add(root.val);
        init(root.left);
    }

    public int next() {
        return roots.pop();
    }

    public boolean hasNext() {
        return !roots.isEmpty();
    }
}