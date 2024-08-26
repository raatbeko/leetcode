package leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SudokuSolver {

    public static void solveSudoku(char[][] board) {
        Map<Integer, Set<Character>> charColumn = new HashMap<>();
        Map<Integer, Set<Character>> charRow = new HashMap<>();
        Map<Integer, Set<Character>> charCount3x3 = new HashMap<>();
        saveExistsElement(board, charColumn, charRow, charCount3x3);
        fill3x3(board, 0, charCount3x3);
    }

    private static void saveExistsElement(char[][] board, Map<Integer, Set<Character>> charColumn, Map<Integer, Set<Character>> charRow, Map<Integer, Set<Character>> charCount3x3) {
        int count3x3 = 0;
        int countRow = 0;
        int countColum = 0;
        for (int i = 0; i < board.length; i++) {
            charColumn.put(i, new HashSet<>());
            for (int j = 0; j < board[i].length; j++) {
                if (!charRow.containsKey(j)) {
                    charRow.put(j, new HashSet<>());
                }
                if (countColum == 0 && !charCount3x3.containsKey(count3x3)) {
                    charCount3x3.put(count3x3, new HashSet<>());
                }
                if (board[i][j] != '.') {
                    charCount3x3.get(count3x3).add(board[i][j]);
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
    }

    private static void fill3x3(char[][] board, int current3x3, Map<Integer, Set<Character>> charCount3x3) {
        if (current3x3 == 9)
            return;

        int rowLength = 0;
        int columnLength = 0;

        for (int i = 0; i < 9; i++) {
            if (board[rowLength][columnLength] == '.') {
                for (char j = '1'; j <= '9'; j++) {
                    if (!charCount3x3.get(current3x3).contains(j)) {
                        charCount3x3.get(current3x3).add(j);
                        board[rowLength][columnLength] = j;
                        break;
                    }
                }
            }
            columnLength++;
            if (columnLength == 3) {
                columnLength = 0;
                rowLength++;
            }
        }
        fill3x3(board, current3x3 + 1, charCount3x3);
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '6', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        solveSudoku(chars);
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
    }
}
