package structure.stack;

import java.util.Stack;

/**
 * Класс для решения задачи оценки выражений в обратной польской записи.
 */
public class EvaluateRPN {

    /**
     * Метод для вычисления значения арифметического выражения в обратной польской записи.
     *
     * @param tokens Массив строк, представляющий выражение в обратной польской записи.
     * @return Результат вычисления выражения.
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int divisor = stack.pop();
                    int dividend = stack.pop();
                    stack.push(dividend / divisor);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    /**
     * Метод для запуска тестовых случаев.
     *
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        EvaluateRPN evaluator = new EvaluateRPN();

        // Тестовый случай 1
        String[] expression1 = {"2", "1", "+", "3", "*"};
        int result1 = evaluator.evalRPN(expression1);
        System.out.println("Результат для {\"2\", \"1\", \"+\", \"3\", \"*\"}: " + result1);  // Ожидается: 9

        // Тестовый случай 2
        String[] expression2 = {"4", "13", "5", "/", "+"};
        int result2 = evaluator.evalRPN(expression2);
        System.out.println("Результат для {\"4\", \"13\", \"5\", \"/\", \"+\"}: " + result2);  // Ожидается: 6

        // Тестовый случай 3
        String[] expression3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int result3 = evaluator.evalRPN(expression3);
        System.out.println("Результат для {\"10\", \"6\", \"9\", \"3\", \"+\", \"-11\", \"*\", \"/\", \"*\", \"17\", \"+\", \"5\", \"+\"}: " + result3);  // Ожидается: 22
    }
}

