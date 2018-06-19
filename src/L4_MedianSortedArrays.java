import java.util.HashSet;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。

 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。

 示例 1:
 nums1 = [1, 3]
 nums2 = [2]

 中位数是 2.0

 示例 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 中位数是 (2 + 3)/2 = 2.5
 */

public class L4_MedianSortedArrays {
    public static void main(String[] args){
        int[] a = {1,3};
        int[] b = {2,4};
        System.out.println(mergSolution(a,b));
    }

    public static double reduceSolution(int[] nums1, int[] nums2){
        int left1=0, right1 = nums1.length-1;
        int left2=0, right2 = nums2.length-1;
        int mid1 = (left1+right1)/2;
        int mid2 = (left2+right2)/2;

        int median;
        if (nums1[mid1] > nums2[mid1]){
        }
        return 0;
    }



    //题目要求O(log (m+n))，这个算法其实是O(m+n)的
    public static double mergSolution(int[] nums1, int[] nums2){
        int i=0, j=0;
        int sum_count = nums1.length+nums2.length;
        int[] result = new int[sum_count/2+1];

        for(int count=0; count<result.length; count++) {
            if(i >= nums1.length){
                result[count] = nums2[j++];
                continue;
            }

            if(j >= nums2.length){
                result[count] = nums1[i++];
                continue;
            }

            if (nums1[i] < nums2[j]) result[count] = nums1[i++];
            else result[count] = nums2[j++];

        }
        if(sum_count%2!=0) return (double) result[result.length-1];
        else return (double) (result[result.length-2]+result[result.length-1])/2.0;
    }
}
