package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FirstCompletelyPaintedRowOrColumn {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, RowColDetails> columnInx = new HashMap<>();
        Map<Integer, RowColDetails> rowInx = new HashMap<>();
        Map<Integer, RowColDetails> colObj = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            RowColDetails obj = create(i/* index */, mat[i].length); // row count
            for (int j = 0; j < mat[i].length; j++) {
                RowColDetails obj2;
                if (colObj.containsKey(j)) {
                    obj2 = colObj.get(j);
                } else {
                    obj2 = create(j, mat.length);
                    colObj.put(j, obj2);
                }
                rowInx.put(mat[i][j], obj2);
                columnInx.put(mat[i][j], obj);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            {
                RowColDetails rowColDetails = columnInx.get(arr[i]);
                rowColDetails.count = rowColDetails.count - 1;
                if (rowColDetails.count == 0)
                    return i;
            }
            {
                RowColDetails rowColDetails = rowInx.get(arr[i]);
                rowColDetails.count = rowColDetails.count - 1;
                if (rowColDetails.count == 0)
                    return i;
            }
        }
        return 0;
    }

    private RowColDetails create(int indx, int count) {
        RowColDetails obj = new RowColDetails();
        obj.indx = indx;
        obj.count = count;
        return obj;
    }
}


class RowColDetails {

    int indx;
    int count;
}