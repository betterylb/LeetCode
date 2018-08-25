package SwordPointOffer;

public class O36_InversedPairs {
    private long count = 0;

    public int InversePairs(int[] data){
        int[] tmp = new int[data.length];
        mergeSort(data, tmp,0, data.length - 1);
        return (int) (count % 1000000007);
    }

    private void mergeSort(int[] A, int[] tmp, int left, int right){
        if(left < right){
            int center = (left+right)/2;
            mergeSort(A, tmp, left, center);
            mergeSort(A, tmp,center+1, right);
            merge(A, tmp, left, center, right);
        }
    }

    /**
     * 归并操作
     * @param A
     * @param left
     * @param center
     * @param right
     */
    private void merge(int[] A, int[] tmp, int left, int center, int right){
        int leftPos = left;
        int rightPos = center+1;

        for(int i=left; i<=right; i++){
            if(leftPos <= center && rightPos <= right){
                if(A[leftPos] <= (A[rightPos]))
                    tmp[i] = A[leftPos++];
                else{
                    tmp[i] = A[rightPos++];
                    this.count += center - leftPos + 1;
                }
            }

            else if(rightPos > right){
                tmp[i] = A[leftPos++];
            }

            else{
                tmp[i] = A[rightPos++];
            }
        }

        for(int i=left; i<=right; i++){
            A[i] = tmp[i];
        }
    }
}
