package algorithms.medium;

public class WordSearch {

    public static boolean exist(char[] board, String word) {
        if (word.length() > board.length) return false;
        System.out.println(board.length);
        System.out.println(word.length());
        System.out.println(board.length - word.length());
        for (int i = 0; i <= board.length - word.length(); i++) {
            if (word.charAt(0) == board[i]) {
                boolean match = true;
                for (int j = 0; j < word.length(); j++) {
                    if (word.charAt(j) != board[i + j]) {
                        match = false;
                        break;
                    }
                }
                if (match) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[]{'A', 'B', 'C', 'D'}, "BCD"));
    }
}
