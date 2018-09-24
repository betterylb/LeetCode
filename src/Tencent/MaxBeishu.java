package Tencent;

public class MaxBeishu {
    static int cnt = 0, N = 1000006;
    static boolean[] tag = new boolean[N];
    static int[] prime = new int[N]; // 素数的个数

    public static void main(String[] main){
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        getPrime(n);
//        long ans = 2;
//        for (int i = 0; i < cnt; i++) {
//            int p = prime[i];
//            long a = 1;
//            while (a * p <= n) {
//                a *= p;
//            }
//            long b = (n / a + 1) * a;
//            ans = Math.max(b, ans);
//        }
//        System.out.println(ans);
//        for(int i=0; i<100; i++){
//            System.out.println(i+": "+isPrime(i));
//        }
        System.out.println(isPrime(92));
    }


    private static void getPrime(int maxnum) {
        tag[0] = tag[1] = true;
        int i, j;
        for (i = 2; i <= maxnum; i++) {
            if (!tag[i]) {
                prime[cnt++]=i;
                for(j = i + i; j <= maxnum; j += i)
                {
                    tag[j] = true;
                }
            }
        }
    }

    /**
     * 判断一个数是否是素数，首先大于等于5的素数一定在6的倍数两边
     * 证明：
     *     6n-2, 6n-1, 6n, 6n+1, 6n+2, 6n+3
     *   = 2(3n-1), 6n-1, 6n, 6n+1, 2(3n+1), 3(2n+1)
     *
     *   明显除了6n-1和6n+1其他都不是素数
     *   但是6n-1和6n+1不一定是素数
     *
     * @param n
     * @return
     */
    private static boolean isPrime(int n){
        if(n<5){
            if(n==2 || n==3){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if (n % 6 != 1 && n % 6 != 5) {
                return false;
            }

            int i = 5;
            while (i < Math.sqrt(n)) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
                i += 6;
            }
            return true;
        }
    }
}
