package SwordPointOffer;

public class SearchMatrix {
    public static boolean search(int[][] matrix, int target){
        if(matrix.length == 0 || matrix == null || matrix[0].length == 0){
            return false;
        }
        int rowMax = 0;
        int columnMax = matrix[0].length - 1;
        while (rowMax < matrix.length && columnMax >= 0){
            if(target == matrix[rowMax][columnMax]){
                return true;
            }
            else if(target < matrix[rowMax][columnMax]){
                columnMax--;
            }
            else {
                rowMax ++;
            }
        }
        return false;
    }
}
