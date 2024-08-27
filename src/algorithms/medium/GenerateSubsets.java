package algorithms.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubsets {
    public List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        // Добавляем текущее подмножество в результат
        result.add(new ArrayList<>(current));

        // Итерируем по всем следующим числам
        for (int i = start; i < nums.length; i++) {
            // Добавляем число в текущее подмножество
            current.add(nums[i]);
            System.out.println(nums[i]);
            // Рекурсивно исследуем возможности добавления оставшихся чисел
            backtrack(result, current, nums, i + 1);
            // Удаляем последнее число из текущего подмножества для бэктрекинга
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateSubsets solution = new GenerateSubsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = solution.generateSubsets(nums);
        // Выводим все подмножества
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
