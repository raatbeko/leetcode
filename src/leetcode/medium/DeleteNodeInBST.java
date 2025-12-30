package leetcode.medium;

import structure.binaryTree.TreeNode;

public class DeleteNodeInBST {

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        return deleteNode(null, root, key);
    }

    public static TreeNode deleteNode(TreeNode paren, TreeNode root, int key) {
        if (root == null) {
            return paren;
        }
        if (root.val == key) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left != null) {
                if (paren == null) {
                    paren = left;
                } else if (root == paren.right) {
                    paren.right = left;
                } else {
                    paren.left = left;
                }
                find(left, right);
            } else {
                if (paren == null) {
                    paren = right;
                } else if (root == paren.right) {
                    paren.right = right;
                } else {
                    paren.left = right;
                }
                find(right, null);
            }
        } else {
            if (paren == null) {
                paren = root;
            }
        }
        deleteNode(root, root.left, key);
        deleteNode(root, root.right, key);

        return paren;
    }

    public static void find(TreeNode paren, TreeNode root) {
        if (root == null) return;

        if (paren.val < root.val) {
            if (paren.right != null) {
                find(paren.right, root);
            } else {
                paren.right = root;
            }
        } else {
            if (paren.left != null) {
                find(paren.left, root);
            } else {
                paren.left = root;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(7);
        System.out.println(deleteNode(root, 3));
    }
}
