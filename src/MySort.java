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

    private static void maxHeap(int nodeIndex, int arrayLength, int[] a){
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

    /**
     * 插入排序
     * @param a
     * @param <T>
     */
    public static <T extends Comparable> void insertSort(T[] a){
        int j;

        for(int p = 1; p<a.length; p++){
            T tmp = a[p];
            for(j = p; j>0 && tmp.compareTo(a[j-1])<0; j--){
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }

    /**
     * 归并排序
     */
    public static <T extends Comparable> void mergeSort(T[] A, T[] tmp, int left, int right){
        if(left < right){
            int center = (left+right)/2;
            mergeSort(A, tmp, left, center);
            mergeSort(A, tmp,center+1, right);
            merge(A, tmp, left, center, right);
        }
    }

    /**
     * 归并操作，我要原址归并
     * @param A
     * @param left
     * @param center
     * @param right
     * @param <T>
     */
    public static <T extends Comparable> void merge(T[] A, T[] tmp, int left,int center, int right){
        int leftPos = left;
        int rightPos = center+1;

        for(int i=left; i<=right; i++){
            if(leftPos <= center && rightPos <= right){
                if(A[leftPos].compareTo(A[rightPos]) <= 0)
                    tmp[i] = A[leftPos++];
                else{
                    tmp[i] = A[rightPos++];
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

    /**
     * 实现算法导论的方法，是稳定的排序算法，时间复杂度O(n)
     * 计数排序，思想是通过一个数组C记录小于等于数组下标的数的数量,
     * C的长度是目标数组A中最大的数加1，
     * 然后，在B中放入排好序的数字。
     * 问题，好像是非比较排序算法，因此无法写成Comparable泛型形式
     * 对于其他类型的变量只能先做好编码；
     * @param A
     * @return
     */
    public static int[] countSort(int[] A){
        if(A==null){

        }

        int max = 0;
        for(int i:A){
            if(i>max){
                max = i;
            }
        }

        int[] B = new int[A.length];

        int[] C = new int[max+1];

        for(int i=0; i<A.length; i++){
            C[A[i]] = C[A[i]] + 1;
        }

        for(int i=1; i<C.length; i++){
            C[i] += C[i-1];
        }

        for(int i=A.length-1; i>=0; i--){
            B[C[A[i]]-1] = A[i];
            //这一步是为了解决非互异的元素，即是有多个相同的元素的情况
            C[A[i]] -= 1;
        }
    return B;
    }

    /**
     * 希尔排序
     * @param A
     * @param <T>
     */
    public static <T extends Comparable> void shellSort(T[] A){
        int j;
        for(int gap = A.length/2; gap>0; gap/=2){
            for (int i=gap; i<A.length;i++){
                T tmp = A[i];
                for (j = i; j>=gap && tmp.compareTo(A[j-gap])<0; j-=gap){
                    A[j] = A[j-gap];
                }
                A[j] = tmp;
            }
        }
    }

    public static void main(String[] args){
//        int[] a = null;
        int [] a = {3,2,5,6,1,7,8};
//        Integer[] tmp = new Integer[a.length];
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
