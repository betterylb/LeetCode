package SwordPointOffer;

public class O31_MaxSumInSubarray {
    public static int maxSum(int[] array){
        int length;
        if( array == null || (length = array.length) == 0){
            return 0;
        }

        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < length; i++){
            if(currentSum <= 0){
                currentSum = array[i];
            }
            else {
                currentSum += array[i];
            }

            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }

        return maxSum;
    }
}
