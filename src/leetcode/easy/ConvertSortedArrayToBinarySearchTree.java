package leetcode.easy;

import structure.binaryTree.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

    public static TreeNode sortedArrayToBST(int[] nums) {
        return create(nums, 0, nums.length - 1);
    }

    private static TreeNode create(int[] nums, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
            TreeNode initial = new TreeNode(nums[mid]);

            initial.left = create(nums, left, mid - 1);
            initial.right = create(nums, mid + 1, right);
            return initial;
        }
        return null;
    }

    public static void recursiveTraversal(int[] array, int left, int right) {
        if (left <= right) {
            int middle = (left + right) / 2;

            // Делаем что-то с элементом в середине (array[middle])
            System.out.println(array[middle]);

            // Рекурсивный вызов для левой половины
            recursiveTraversal(array, left, middle - 1);

            // Рекурсивный вызов для правой половины
            recursiveTraversal(array, middle + 1, right);
        }
    }

    public static void main(String[] args) {
        System.out.println(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }
}
