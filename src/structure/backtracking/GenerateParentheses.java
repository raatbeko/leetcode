package structure.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        StringBuilder par = new StringBuilder();
        n = n * 2;
        for (int i = 0; i < n; i++) {
            if (par.length() <= n) {
                par.append("(");
            }
            if (par.length() >= n) {
                par.append(")");
            }
        }
        ArrayList<String> objects = new ArrayList<>();
        parentheses(objects, par.toString());
        return objects;
    }

    private static String parentheses(ArrayList<String> parentheses, String pre) {
        String newPre = "";
        for (char c : pre.toCharArray()) {

        }
    }
}
