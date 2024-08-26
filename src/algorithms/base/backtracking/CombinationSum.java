package algorithms.base.backtracking;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Класс для генерации всех возможных комбинаций чисел из массива, сумма которых равна заданному значению.
 */
public class CombinationSum {

    /**
     * Рекурсивный метод для генерации комбинаций.
     *
     * @param arr       Массив чисел, из которых генерируются комбинации.
     * @param targetSum Целевая сумма, которую должны составить элементы комбинации.
     * @param currSum   Текущая сумма комбинации.
     * @param path      Список, представляющий текущую комбинацию.
     * @param result    Список списков, содержащий все найденные комбинации.
     */
    private static void generateCombinations(int[] arr, int targetSum, int currSum, List<Integer> path, List<List<Integer>> result) {
        // Если текущая сумма больше целевой, возвращаемся (комбинация недопустима)
        if (currSum > targetSum) {
            return;
        }

        // Если текущая сумма равна целевой, сохраняем комбинацию в результат
        if (currSum == targetSum) {
            result.add(new ArrayList<>(path)); // Создаем копию текущего пути и добавляем в результат
            return;
        }

        // Проходим по массиву и добавляем элементы в текущую комбинацию
        for (int i = 0; i < arr.length; i++) {
            int currNum = arr[i];
            currSum += currNum; // Добавляем текущий элемент к текущей сумме
            path.add(currNum); // Добавляем текущий элемент в текущий путь

            // Рекурсивный вызов с оставшимися элементами массива
            generateCombinations(java.util.Arrays.copyOfRange(arr, i, arr.length), targetSum, currSum, path, result);

            // Откатываем изменения: удаляем последний добавленный элемент и уменьшаем сумму
            currSum -= currNum;
            path.remove(path.size() - 1);
        }
    }

    /**
     * Метод для поиска всех комбинаций чисел из массива, сумма которых равна заданной целевой сумме.
     *
     * @param arr       Массив чисел, из которых нужно найти комбинации.
     * @param targetSum Целевая сумма, которую должны составить элементы комбинации.
     * @return Список списков, содержащий все комбинации, сумма элементов которых равна targetSum.
     */
    public static List<List<Integer>> findCombinations(int[] arr, int targetSum) {
        List<List<Integer>> result = new ArrayList<>(); // Список для хранения результатов
        generateCombinations(arr, targetSum, 0, new ArrayList<>(), result); // Запуск рекурсивного поиска
        return result; // Возвращаем список комбинаций
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7, 5, 1, 2, 3, 4, 5, 6, 7, 2, 3, 1, 4, 5, 6};
        int targetSum = 10;

        // Поиск и вывод всех комбинаций, сумма которых равна targetSum
        List<List<Integer>> combinations = findCombinations(arr, targetSum);
        System.out.println("Combinations that sum to " + targetSum + ": " + combinations);

        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
    }
}

