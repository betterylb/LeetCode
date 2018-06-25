import java.util.Arrays;

public class MySort {
    public static void quickSort(int l, int r, int[] a){
        if(l>=r) return;
        int i=l,j=r,m=a[l], t;
        int p=l;
        while(i<j) {
            while (i < j && m >= a[i]) p=i++;
            while (i < j && m <= a[j]) j--;
            if(i<j){
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        //此时
        a[l] = a[p];
        a[p] = m;
        quickSort(l, p-1, a);
        quickSort(p+1, r, a);
    }

    public static void heapSort(int[] a){
        if(a == null || a.length<=0){
            return;
        }
        for(int i=a.length/2-1; i>=0; i--){
            maxHeap(i, a.length, a);
        }
        for(int i=a.length-1; i>=0; i--){
            int tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            maxHeap(0, i, a);
        }
    }

    private static void maxHeap(int nodeIndex, int arrayLength,int[] a){
        int largestIndex = nodeIndex;
        int left = 2*nodeIndex+1;
        int right = 2*nodeIndex +2;
        if(left < arrayLength && a[largestIndex] < a[left]){
            largestIndex = left;
        }
        if(right < arrayLength && a[largestIndex] < a[right]){
            largestIndex = right;
        }
        if(largestIndex != nodeIndex){
            int tmp = a[nodeIndex];
            a[nodeIndex] = a[largestIndex];
            a[largestIndex] = tmp;
            maxHeap(largestIndex, a.length, a);
        }
    }


    public static void main(String[] args){
        int[] a = {3,2,5,6,1,7,8};
        quickSort(0, a.length-1, a);
        System.out.println(Arrays.toString(a));
    }
}
