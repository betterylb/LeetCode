package SwordPointOffer;

import java.util.ArrayList;

public class O20_PrintMatrixClockwisely {
    public ArrayList<Integer> print(int[][] matrix){
        if(matrix == null){
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;

        int start = 0;
        while (columns > start*2 && rows > start*2){
            printMatrixInCircle(matrix, rows, columns, start, result);
            start++;
        }

        return result;
    }

    private static void printMatrixInCircle(int[][] matrix,
                                            int rows, int columns,
                                            int start,
                                            ArrayList<Integer> result){
        int xEnd = columns - 1 - start;
        int yEnd = rows - 1 - start;

        // 从左到右
        for(int i=start; i<=xEnd; i++){
            result.add(matrix[start][i]);
        }

        //从上到下
        if(start < yEnd){
            for (int i = start + 1; i<=yEnd; i++){
                result.add(matrix[i][xEnd]);
            }
        }

        //从右到左
        if(start < xEnd && start < yEnd){
            for(int i = xEnd - 1; i >= start; i--){
                result.add(matrix[yEnd][i]);
            }
        }

        //从下到上
        if(start < yEnd -1 && start < xEnd){
            for(int i = yEnd - 1; i > start; i--){
                result.add(matrix[i][start]);
            }
        }
    }
}
