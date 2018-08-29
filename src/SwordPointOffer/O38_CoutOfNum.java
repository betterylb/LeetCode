package SwordPointOffer;

public class O38_CoutOfNum {
    public int GetNumberOfK(int[] nums, int K) {
        int first = binarySearch(nums, K);
        int last = binarySearch(nums, K + 1);
        return (first == nums.length || nums[first] != K) ? 0 : last - first;
    }

    private int binarySearch(int[] nums, int K) {
        int l = 0, h = nums.length;
        while (l < h) {
            // 跟m = (h+l)有啥区别？
            int m = l + (h - l) / 2;
            // 关键在这一步
            if (nums[m] >= K)
                h = m;
            else
                l = m + 1;
        }
        return l;
    }
}
