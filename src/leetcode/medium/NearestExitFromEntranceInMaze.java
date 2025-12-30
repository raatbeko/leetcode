package leetcode.medium;

public class NearestExitFromEntranceInMaze {
    public static int nearestExit(char[][] maze, int[] entrance) {

        return 0;
    }

    public static void main(String[] args) {
        // Тест 1
        char[][] maze1 = {
                {'+', '+', '.', '+'},
                {'.', '.', '.', '+'},
                {'+', '+', '+', '.'}
        };
        int[] entrance1 = {1, 2}; // Вход

        System.out.println("Test 1: Steps to nearest exit = "); // Ожидается: 1

        // Тест 2
        char[][] maze2 = {
                {'+', '+', '+'},
                {'.', '.', '.'},
                {'+', '+', '+'}
        };
        int[] entrance2 = {1, 0};

        System.out.println("Test 2: Steps to nearest exit = "); // Ожидается: 2
    }
}
