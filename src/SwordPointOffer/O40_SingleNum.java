package SwordPointOffer;

public class O40_SingleNum {
    public void FindNumsAppearOnce(int[] nums, int num1[], int num2[]) {
        int diff = 0;
        for (int num : nums)
            diff ^= num;
        // 有意思
        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0)
                num1[0] ^= num;
            else
                num2[0] ^= num;
        }
    }

    public static void main(String[] args){
        int diff = 4;
        System.out.println(Integer.toBinaryString(diff));
        diff = -4;
        System.out.println(Integer.toBinaryString(diff));
    }
}
