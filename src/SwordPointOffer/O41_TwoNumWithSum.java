package SwordPointOffer;

import java.util.ArrayList;

public class O41_TwoNumWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int left = 0;
        int right = array.length -1;
        ArrayList<Integer> result = new ArrayList<>();

        while (left < right){
            if(array[left] + array[right] == sum){
                result.add(array[left]);
                result.add(array[right]);
                break;
            }
            else if(array[left] + array[right] > sum){
                right--;
            }
            else {
                left++;
            }
        }

        return result;
    }


    /**
     * big = small+n-1
     * sum = (small+big)*n/2 = small*n + n*(n-1)/2
     */

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int small = 1;
        int big = 2;
        int middle = (1+sum)/2;
        int curSum = 3;
        while (small<middle){
            if(curSum == sum){
                ArrayList<Integer> serial = new ArrayList<>();
                for(int i=small; i<=big; i++){
                    serial.add(i);
                }
                result.add(serial);
                curSum -= small;
                small++;
                big++;
                curSum += big;
            }
            else if (curSum > sum){
                curSum -= small;
                small++;
            }
            else {
                big++;
                curSum += big;
            }
        }
        return result;
    }
}
