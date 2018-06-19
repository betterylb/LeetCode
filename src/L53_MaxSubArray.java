/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 示例:

 输入: [-2,1,-3,4,-1,2,1,-5,4],
 输出: 6
 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */

public class L53_MaxSubArray {
    public int max = Integer.MIN_VALUE;

    //暴力算法，直接计算，复杂度O(n^2)
    public int greedSolution(int[] nums){

        int sum;
        for(int i=0; i < nums.length; i++){
            sum = 0;
            for(int j=i; j < nums.length; j++){
                sum += nums[j];
                if(sum > max){
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * 动态规划算法，动态规划表达式，也就是《编程珠玑》的8.4节扫描法
     * 设sum[i]为以第i个元素结尾且和最大的连续子数组
     * sum[i]={
     *         max{sum[i-1]+ nums[i], nums[i]},  if i > 0;
     *         nums[i],                          if i=0;
     *        }
     */
    public int dpSolution(int[] nums){
        int sum = nums[0];
        int n = nums[0];
        for(int i=0; i < nums.length; i++){
            if(n>0) n+=nums[i];
            else    n=nums[i];
            sum = Integer.max(sum, n);
        }
        return max;
    }

    /**
     * 分治法求解，递归的方式
     * 递归分三步,maxSum(left,right)=max{left+right, maxSum(left, median), maxSum(median+1,right)}
     * 计算left+right时考虑：
     * (1)right < left，子数组空
     * (2)right = left, 子数组只有一个元素
     * (3)right > left, 正常,分别计算左右最大值
     * @param nums
     * @return
     */
    public int reduceSolution(int[] nums, int left, int right){
        if(left > right) /*子数组无元素*/
            return 0;
        if(left == right)
            return Integer.max(0, nums[left]);
        int median = (left + right)/2;

        int leftMax = max;
        int sum = 0;
        for(int i=median; i>=left; i--){
            sum += nums[i];
            leftMax = Integer.max(leftMax, sum);
        }

        int rightMax = max;
        sum = 0;
        for(int i=median+1; i<=right; i++){
            sum += nums[i];
            rightMax = Integer.max(rightMax, sum);
        }

        return Math.max(rightMax+leftMax,
                        Math.max(reduceSolution(nums, left, median),
                        reduceSolution(nums, median+1, right)));
    }


    public static void main(String[] args){
        int[] nums = {-1,2,-3,-4,5};
        L53_MaxSubArray results = new L53_MaxSubArray();
        System.out.println(results.reduceSolution(nums, 0, nums.length-1));
    }
}
