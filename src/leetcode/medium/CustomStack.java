package leetcode.medium;

public class CustomStack {

    private int[] stack;
    private int elementLength = 0;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        elementLength = 0;
    }

    public void push(int x) {
        if (elementLength < stack.length) {
            stack[elementLength++] = x;
        }
    }

    public int pop() {
        return elementLength == 0 ? -1 : stack[--elementLength];
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, elementLength);
        for (int i = 0; i < limit; i++) {
            stack[i] += val;
        }
    }

    public int getElementLength() {
        return elementLength;
    }

    public void setElementLength(int elementLength) {
        this.elementLength = elementLength;
    }

    public static void main(String[] args) {
        // 1. Инициализация стека с максимальным размером 3
        CustomStack stack = new CustomStack(3);

        // 2. Добавляем элемент 1
        stack.push(1);  // Стек: [1]

        // 3. Добавляем элемент 2
        stack.push(2);  // Стек: [1, 2]

        // 4. Удаляем элемент с вершины стека
        System.out.println(stack.pop());  // Ожидается: 2, Стек: [1]

        // 5. Добавляем элемент 2
        stack.push(2);  // Стек: [1, 2]

        // 6. Добавляем элемент 3
        stack.push(3);  // Стек: [1, 2, 3]

        // 7. Пытаемся добавить элемент 4 (операция проигнорируется)
        stack.push(4);  // Стек остается: [1, 2, 3]

        // 8. Увеличиваем нижние 5 элементов на 100
        stack.increment(5, 100);  // Стек: [101, 102, 103]

        // 9. Увеличиваем нижние 2 элемента на 100
        stack.increment(2, 100);  // Стек: [201, 202, 103]

        // 10. Удаляем элемент с вершины стека
        System.out.println(stack.pop());  // Ожидается: 103, Стек: [201, 202]

        // 11. Удаляем элемент с вершины стека
        System.out.println(stack.pop());  // Ожидается: 202, Стек: [201]

        // 12. Удаляем элемент с вершины стека
        System.out.println(stack.pop());  // Ожидается: 201, Стек: []

        // 13. Удаляем элемент с пустого стека
        System.out.println(stack.pop());
    }
}
