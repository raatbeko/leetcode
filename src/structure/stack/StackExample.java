package structure.stack;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // Добавление элементов в стек
        stack.push("first");
        stack.push("second");
        stack.push("third");

        // Просмотр верхнего элемента
        System.out.println("Top element: " + stack.peek()); // Вывод: third

        // Удаление и возвращение верхнего элемента
        System.out.println("Removed element: " + stack.pop()); // Вывод: third

        // Проверка пустоты стека
        System.out.println("Is stack empty? " + stack.isEmpty()); // Вывод: false

        // Вывод всех элементов стека
        System.out.println("Elements in stack: " + stack); // Вывод: [first, second]
    }
}
