package leetcode.easy;

import structure.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> root1List = new ArrayList<>();
        ArrayList<Integer> root2List = new ArrayList<>();

        collect(root1List, root1);
        collect(root2List, root2);

        return root1List.equals(root2List);
    }

    private static void collect(List<Integer> list, TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            list.add(node.val);
        }
        collect(list, node.left);
        collect(list, node.right);
    }
}


