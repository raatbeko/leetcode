package algorithms.base.depthFirstSearch;

import java.util.*;

/**
 * Класс для демонстрации работы алгоритма поиска в глубину (DFS).
 */
public class DepthFirstSearch {

    /**
     * Запускает алгоритм поиска в глубину (DFS) для заданного графа, начиная с указанного узла.
     *
     * @param graph Граф, представленный в виде карты (Map), где ключ - узел, а значение - список соседних узлов.
     * @param start Стартовый узел, с которого начинается обход графа.
     */
    public static void dfs(Map<Character, List<Character>> graph, char start) {
        Set<Character> visited = new HashSet<>();  // Множество для хранения посещённых узлов
        dfsHelper(graph, start, visited);  // Запуск рекурсивного обхода графа
    }

    /**
     * Вспомогательный рекурсивный метод для выполнения поиска в глубину (DFS).
     *
     * @param graph   Граф, представленный в виде карты (Map), где ключ - узел, а значение - список соседних узлов.
     * @param node    Текущий узел, который обрабатывается.
     * @param visited Множество, содержащее посещённые узлы, чтобы избежать повторного посещения.
     */
    private static void dfsHelper(Map<Character, List<Character>> graph, char node, Set<Character> visited) {
        if (visited.contains(node)) {
            return;  // Если узел уже посещён, выходим из метода
        }

        // Помечаем текущий узел как посещённый
        visited.add(node);
        System.out.print(node + " ");  // Выводим узел

        // Рекурсивно исследуем соседние узлы
        for (char neighbor : graph.get(node)) {
            dfsHelper(graph, neighbor, visited);  // Рекурсивный вызов для соседнего узла
        }
    }

    /**
     * Основной метод для запуска программы.
     *
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        // Пример графа
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('A', Arrays.asList('B', 'C'));
        graph.put('B', Arrays.asList('A', 'D', 'E'));
        graph.put('C', Arrays.asList('A', 'F'));
        graph.put('D', Arrays.asList('B'));
        graph.put('E', Arrays.asList('B'));
        graph.put('F', Arrays.asList('C'));

        // Запуск DFS с узла A
        System.out.print("DFS: ");
        dfs(graph, 'A');  // Ожидаемый вывод: A B D E C F
    }
}
