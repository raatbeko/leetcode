package algorithms.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> charColumn = new HashMap<>();
        Map<Integer, Set<Character>> charRow = new HashMap<>();
        Map<Integer, Set<Character>> charCount = new HashMap<>();

        int count3x3 = 0;
        int countRow = 0;
        int countColum = 0;
        for (int i = 0; i < board.length; i++) {
            charColumn.put(i, new HashSet<>());
            for (int j = 0; j < board[i].length; j++) {
                if (!charRow.containsKey(j)) {
                    charRow.put(j, new HashSet<>());
                }
                if (countColum == 0 && !charCount.containsKey(count3x3)) {
                    charCount.put(count3x3, new HashSet<>());
                }
                if (board[i][j] != '.') {
                    if (charCount.get(count3x3).contains(board[i][j]) || charColumn.get(i).contains(board[i][j]) || charRow.get(j).contains(board[i][j])) {
                        return false;
                    }
                    charCount.get(count3x3).add(board[i][j]);
                    charColumn.get(i).add(board[i][j]);
                    charRow.get(j).add(board[i][j]);
                }

                ++countColum;

                if (countColum == 3) {
                    countColum = 0;
                    count3x3 += 1;
                }
            }
            ++countRow;
            if (countRow == 3) {
                countRow = 0;
            } else {
                count3x3 -= 3;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '6', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        }));

    }
}
