package leetcode.medium;

public class NearestExitFromEntranceInMaze {
    public static int nearestExit(char[][] maze, int[] entrance) {
        int row = entrance[0];
        int column = entrance[1];
        return count(maze, row, column, 0);
    }

    public static int count(
            char[][] maze,
            int row,
            int column,
            int steps
    ) {
        int minCount = Integer.MAX_VALUE;

//        if (
//                row - 1 == 0 || column - 1 == 0 ||
//                        row + 1 == maze.length || column + 1 == maze[row].length
//        ) {
//            return steps;
//        }

        maze[row][column] = '+';

        //check up
        if (maze[row - 1][column] == '.') {
            minCount = Math.min(count(
                    maze,
                    row - 1,
                    column,
                    steps + 1
            ), minCount);
        }

        //check down
        if (maze[row + 1][column] == '.') {
            minCount = Math.min(count(
                    maze,
                    row + 1,
                    column,
                    steps + 1
            ), minCount);
        }

        //check left
        if (maze[row][column - 1] == '.') {
            minCount = Math.min(count(
                    maze,
                    row,
                    column - 1,
                    steps + 1
            ), minCount);
        }

        //check right
        if (maze[row][column + 1] == '.') {
            minCount = Math.min(count(
                    maze,
                    row,
                    column + 1,
                    steps + 1
            ), minCount);
        }

        return Math.min(minCount, steps);
    }

//    public static int count(
//            char[][] maze,
//            int row,
//            int column,
//            int steps,
//            boolean up,
//            boolean down,
//            boolean left,
//            boolean right
//    ) {
//        int minCount = Integer.MAX_VALUE;
//

    /// /        if (
    /// /                row - 1 == 0 || column - 1 == 0 ||
    /// /                        row + 1 == maze.length || column + 1 == maze[row].length
    /// /        ) {
    /// /            return steps;
    /// /        }
//
//        if (row - 1 < 0) {
//            up = true;
//        }
//        if (row + 1 > maze.length) {
//            down = true;
//        }
//        if (column - 1 < 0) {
//            left = true;
//        }
//        if (column + 1 > maze[row].length) {
//            right = true;
//        }
//
//        //check up
//        if (!up && maze[row - 1][column] == '.') {
//            minCount = Math.min(count(
//                    maze,
//                    row - 1,
//                    column,
//                    steps + 1,
//                    false,
//                    true,
//                    false,
//                    false
//            ), minCount);
//        }
//
//        //check down
//        if (!down && maze[row + 1][column] == '.') {
//            minCount = Math.min(count(
//                    maze,
//                    row + 1,
//                    column,
//                    steps + 1,
//                    true,
//                    false,
//                    false,
//                    false
//            ), minCount);
//        }
//
//        //check left
//        if (!left && maze[row][column - 1] == '.') {
//            minCount = Math.min(count(
//                    maze,
//                    row,
//                    column - 1,
//                    steps + 1,
//                    false,
//                    false,
//                    false,
//                    true
//            ), minCount);
//        }
//
//        //check right
//        if (!right && maze[row][column + 1] == '.') {
//            minCount = Math.min(count(
//                    maze,
//                    row,
//                    column + 1,
//                    steps + 1,
//                    false,
//                    false,
//                    true,
//                    false
//            ), minCount);
//        }
//
//        return Math.min(minCount, steps);
//    }

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

        System.out.println(nearestExit(maze1, entrance1));
    }
}
