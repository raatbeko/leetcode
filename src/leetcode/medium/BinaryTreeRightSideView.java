package leetcode.medium;

import structure.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        find(l, root);
        return l;
    }

    private void find(List<Integer> lRight, TreeNode root) {
        if (root == null) return;
        lRight.add(root.val);

        List<Integer> lLeft = new ArrayList<>(lRight);

        find(lRight, root.right);

        find(lLeft, root.left);

        if (lLeft.size() > lRight.size()) {
            for (int i = lRight.size(); i < lLeft.size(); i++) {
                lRight.add(lLeft.get(i));
            }
        }
    }

    public static void main(String[] args) {
        // Создаем тестовое дерево
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        // Создаем экземпляр класса и получаем правый вид
        BinaryTreeRightSideView btrsv = new BinaryTreeRightSideView();
        List<Integer> rightView = btrsv.rightSideView(root);

        // Печатаем результат
        System.out.println("Right Side View: " + rightView); // Ожидаемый вывод: [1, 3, 4]

    }
}
