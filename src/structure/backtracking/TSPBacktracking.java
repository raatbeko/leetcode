package structure.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс {@code TSPBacktracking} реализует алгоритм решения задачи коммивояжера (Travelling Salesman Problem, TSP) с использованием метода backtracking.
 * Задача коммивояжера является классической задачей комбинаторной оптимизации, целью которой является нахождение кратчайшего маршрута,
 * который проходит через все города ровно один раз и возвращается в исходный город.
 *
 * <p>
 * Основные элементы задачи:
 * <ul>
 *     <li><strong>Города:</strong> У нас есть множество городов, которые нужно посетить.</li>
 *     <li><strong>Маршрут:</strong> Коммивояжер должен начать свой путь в одном из городов, посетить все остальные города ровно один раз и вернуться в начальный город.</li>
 *     <li><strong>Расстояния или затраты:</strong> Между каждой парой городов существует определенное расстояние или стоимость перемещения.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Цель задачи:
 * Найти маршрут, который позволит посетить все города и вернуться в исходный город с минимальными затратами (например, с наименьшим расстоянием).
 * </p>
 *
 * <p>
 * Пример:
 * Представьте, что есть 4 города: A, B, C и D. Расстояния между городами известны:
 * <ul>
 *     <li>От A до B = 10</li>
 *     <li>От A до C = 15</li>
 *     <li>От A до D = 20</li>
 *     <li>От B до C = 35</li>
 *     <li>От B до D = 25</li>
 *     <li>От C до D = 30</li>
 * </ul>
 * Задача состоит в том, чтобы найти маршрут, который пройдет через все города, начиная и заканчивая, например, в городе A, и при этом общая длина маршрута будет минимальной.
 * </p>
 *
 * <p>
 * Сложность задачи:
 * Задача коммивояжера становится сложной, когда количество городов увеличивается, поскольку количество возможных маршрутов возрастает экспоненциально.
 * Например, для 4 городов существует всего 6 возможных маршрутов, а для 10 городов — уже 181440.
 * Именно поэтому для её решения часто используют различные алгоритмы, такие как backtracking, динамическое программирование или эвристические методы.
 * </p>
 *
 * <p>
 * Пример использования:
 * <pre>
 * {@code
 * int[][] graph = {
 *     {0, 10, 15, 20},
 *     {10, 0, 35, 25},
 *     {15, 35, 0, 30},
 *     {20, 25, 30, 0}
 * };
 *
 * int result = TSPBacktracking.solveTSP(graph);
 * System.out.println("Minimum cost: " + result);
 * }
 * </pre>
 * </p>
 *
 * @see java.util.Arrays
 * @see java.util.Collections
 */
public class TSPBacktracking {

    /**
     * Реализует алгоритм backtracking для нахождения минимальной стоимости тура.
     *
     * @param graph    Матрица смежности, представляющая расстояния между городами.
     * @param path     Массив, представляющий текущий маршрут.
     * @param visited  Массив, отмечающий посещенные города.
     * @param n        Количество городов.
     * @param currCost Текущая стоимость пути.
     * @param minCost  Минимальная стоимость, найденная на текущий момент.
     * @return Минимальная стоимость тура.
     */
    private static int tspBacktracking(int[][] graph, List<Integer> path, boolean[] visited, int n, int currCost, int minCost) {
        System.out.print(Arrays.deepToString(graph));
        System.out.print(" ");
        System.out.print(path);
        System.out.print(" ");
        System.out.print(Arrays.toString(visited));
        System.out.print(" ");
        System.out.print(n);
        System.out.print(" ");
        System.out.print(currCost);
        System.out.print(" ");
        System.out.print(minCost);
        System.out.println();
        if (path.size() == n) {
            // Если длина текущего маршрута равна количеству городов, значит, мы посетили все города.
            // Возвращаемся в начальный город и добавляем стоимость перехода от последнего города в маршруте к первому.
            return currCost + graph[path.get(path.size() - 1)][path.get(0)];
        }

        for (int i = 0; i < n; i++) {
            // Проверяем, был ли этот город уже посещен
            if (!visited[i]) {
                // Если город не был посещен, добавляем его в текущий маршрут
                path.add(i);
                // Помечаем его как посещенный
                visited[i] = true;

                // Рассчитываем новую стоимость маршрута, добавив стоимость перехода от предыдущего города к текущему
                int newCost = currCost + graph[path.get(path.size() - 2)][i];

                // Если новая стоимость меньше текущей минимальной стоимости, продолжаем исследование этого пути
                if (newCost < minCost) {
                    minCost = tspBacktracking(graph, path, visited, n, newCost, minCost);
                }

                // Откат изменений: отмечаем город как не посещенный и удаляем его из маршрута
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }

        // Возвращаем минимальную стоимость, найденную в текущей ветке рекурсии
        return minCost;
    }

    /**
     * Основной метод для запуска алгоритма backtracking и нахождения минимальной стоимости тура.
     *
     * @param graph Матрица смежности, представляющая расстояния между городами.
     * @return Минимальная стоимость тура.
     */
    public static int solveTSP(int[][] graph) {
        int n = graph.length;
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[n];
        visited[0] = true; // Начинаем с первого города
        path.add(0);
        int minCost = Integer.MAX_VALUE;
        minCost = tspBacktracking(graph, path, visited, n, 0, minCost);
        return minCost;
    }

    /**
     * Пример использования алгоритма для решения задачи коммивояжера.
     *
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        int[][] graph = {
                // Город A  Город B  Город C  Город D
                {0, 10, 15, 20},  // Город A
                {10, 0, 35, 25},  // Город B
                {15, 35, 0, 30},  // Город C
                {20, 25, 30, 0}   // Город D
        };

        int result = solveTSP(graph);
        System.out.println("Minimum cost: " + result);
    }
}
