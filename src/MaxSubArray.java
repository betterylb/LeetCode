public class MaxSubArray{
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

    //扫描法，复杂度O(n)
    public int scanSolution(int[] nums){
        for(int i=0; i < nums.length; i++){

        }
        return max;
    }

    /**
     * 动态规划算法，动态规划表达式
     * sum[i]=
     *
     */
    public int dpSolution(int[] nums){
        for(int i=0; i < nums.length; i++){

        }
        return max;
    }

    /**
     * 分治法求解，递归的方式
     *
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
        MaxSubArray results = new MaxSubArray();
        System.out.println(results.reduceSolution(nums, 0, nums.length-1));
    }
}
