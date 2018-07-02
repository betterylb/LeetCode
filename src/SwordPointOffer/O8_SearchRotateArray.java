package SwordPointOffer;

public class O8_SearchRotateArray {
    public static int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length-1;
        int mid = (left+right)/2;;
        while(array[left] >= array[right]){
            if(right-left == 1){
                return array[right];
            }
            mid = (left+right)/2;
            if(array[left] == array[right] && array[mid] == array[left])
                return minInOrder(array, left, right);

            if(array[mid] >= array[left]){
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return array[mid];
    }

    private static int minInOrder(int[] array, int left, int right){
        int min = array[left];
        for(int i=left+1; i<=right; i++){
            min = Integer.min(min, array[i]);
        }
        return min;
    }

    public static void main(String[] args){
        int[] a = {3,4,5,1,2};
        System.out.println(minNumberInRotateArray(a));
    }
}
