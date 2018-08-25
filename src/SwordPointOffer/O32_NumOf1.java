package SwordPointOffer;

public class O32_NumOf1 {
    public static int numOf1(int n){
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            // a是高位
            int a = n / m;

            // b是去掉高位的余数
            int b = n % m;

            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }

    public static void main(String[] args){
        System.out.println(numOf1(13));
    }
}
