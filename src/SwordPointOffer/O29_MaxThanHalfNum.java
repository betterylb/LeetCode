package SwordPointOffer;

public class O29_MaxThanHalfNum {
    public static int patition(int[] nums){
        if(isValide(nums)){
            return 0;
        }

        int length = nums.length;
        int mid = length >> 1;
        int start  = 0;
        int end = length - 1;
        int index = partition(nums, start, end);

        return 0;
    }

    public static int partition(int[] nums, int start, int end){
        return 0;
    }

    public static boolean isValide(int[] nums){
        return true;
    }

    public static int iterolution(int[] nums){
        int majority = nums[0];
        for (int i = 1, cnt = 1; i < nums.length; i++) {
            cnt = nums[i] == majority ? cnt + 1 : cnt - 1;
            if (cnt == 0) {
                majority = nums[i];
                cnt = 1;
            }
        }

        int cnt = 0;
        for (int val : nums)
            if (val == majority)
                cnt++;
        return cnt > nums.length / 2 ? majority : 0;
    }
}
