package algorithms.base.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс GenerateParentheses предоставляет метод для генерации всех возможных комбинаций правильно расставленных скобок для заданного количества пар.
 */
public class GenerateParentheses {

    /**
     * Генерирует все комбинации правильно расставленных скобок для заданного количества пар.
     *
     * @param n Количество пар скобок.
     * @return Список всех допустимых комбинаций правильно расставленных скобок.
     */
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> objects = new ArrayList<>();
        // Запускаем рекурсивное построение комбинаций скобок.
        parentheses(objects, n, 1, 0, "(");
        return objects;
    }

    /**
     * Рекурсивный метод для генерации комбинаций скобок.
     *
     * @param parentheses Список, в который будут добавляться допустимые комбинации скобок.
     * @param n Общее количество пар скобок.
     * @param countLeft Текущее количество использованных '('.
     * @param countRight Текущее количество использованных ')'.
     * @param current Текущая комбинация скобок, которая формируется.
     */
    private static void parentheses(ArrayList<String> parentheses, int n, int countLeft, int countRight, String current) {
        // Базовый случай: Если текущая комбинация завершена и допустима, добавляем ее в список.
        if (current.length() == n * 2 && countLeft == countRight) {
            parentheses.add(current);
        }
        // Рекурсивный случай: Добавляем '(', если не достигли предела 'n'.
        if (countLeft < n) {
            parentheses(parentheses, n, countLeft + 1, countRight, current + "(");
        }
        // Рекурсивный случай: Добавляем ')', если это не превысит количество уже использованных '('.
        if (countRight < countLeft) {
            parentheses(parentheses, n, countLeft, countRight + 1, current + ")");
        }
    }

    /**
     * Основной метод для тестирования генерации комбинаций скобок.
     *
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        // Выводим сгенерированные комбинации для 3 пар скобок.
        System.out.println(generateParenthesis(3));
    }
}

