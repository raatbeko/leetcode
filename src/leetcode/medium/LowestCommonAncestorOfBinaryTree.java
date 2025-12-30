package leetcode.medium;

import structure.binaryTree.TreeNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LowestCommonAncestorOfBinaryTree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashSet<TreeNode> treeNodes = new HashSet<>();
        find(treeNodes, root, p);
        return findQ(treeNodes, root, q);
    }

    public static TreeNode find(Set<TreeNode> set, TreeNode root, TreeNode toFind) {
        if (root == null) return null;
        if (Objects.equals(root, toFind)) {
            set.add(root);
            return root;
        }

        TreeNode p = find(set, root.left, toFind);
        TreeNode p1 = find(set, root.right, toFind);

        if (p == null && p1 == null) return null;

        set.add(root);
        return root;
    }

    public static TreeNode findQ(Set<TreeNode> set, TreeNode root, TreeNode toFind) {
        if (root == null) return null;
        if (Objects.equals(root, toFind)) {
            return root;
        }

        TreeNode p = findQ(set, root.left, toFind);
        TreeNode p1 = findQ(set, root.right, toFind);

        if (p == null && p1 == null) return null;

        if (set.isEmpty()) {
            if (p != null) return p;
            return p1;
        }
        if (p != null) {
            if (set.contains(p)) {
                set.clear();
                return p;
            }
        } else {
            if (set.contains(p1)) {
                set.clear();
                return p1;
            }
        }
        if (set.contains(root)) {
            set.clear();
        }
        return root;
    }

    public static CheckTreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }

    public static class CheckTreeNode {
        TreeNode root;
        boolean hasP;
        boolean hasQ;
    }

    public static void main(String[] args) {
        // Строим дерево
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Назначаем p и q
        TreeNode p = root.right.left;     // 5
        TreeNode q = root.right.left;    // 1

        System.out.println(lowestCommonAncestor(root, p, q));
    }
}
