package SwordPointOffer;

public class O8_SearchRotateArray {
    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length-1;
        int mid = (left+right)/2;;
        while(array[left] >= array[right]){
            if(right-left == 1){
                return array[left];
            }
            mid = (left+right)/2;
            if(array[mid] >= array[left]){
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return array[mid];
    }
}
