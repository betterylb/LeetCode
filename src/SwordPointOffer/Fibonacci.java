package SwordPointOffer;

public class Fibonacci {
    public static int reduce(int n){
        if(n<=0){
            return 0;
        }
        if (n==1){
            return 1;
        }

        return reduce(n-2)+reduce(n-1);
    }

    /**
     * 循环解法
     * @param n
     * @return
     */
    public static int dp(int n){
        if (n<0){
            return 0;
        }

        if (n<2){
            return n;
        }

        int f_n_2 = 0;
        int f_n_1 = 1;
        int f = 0;
        for(int i=2; i<=n; i++){
            f = f_n_2 + f_n_1;

            f_n_2 = f_n_1;
            f_n_1 = f;
        }
        return f;
    }

    /**
     * 利用公式
     * [ [f(n),  f(n-1)]    [[1, 1] ^(n-1)
     *   [f(n-1),f(n-2)]] = [1, 0]]
     * @param n
     * @return
     */
    public static int matrixSolution(int n){
        if (n<0){
            return 0;
        }

        if (n<2){
            return n;
        }

        int[][] a;
        a = matrixpower(n-1);
        return a[0][0];
    }

    private static int[][] matrixpower(int n){

        int[][] a = {{1,1},{1,0}};
        if(n == 1){
            return a;
        }
        else if(n%2==0){
            a = matrixpower(n/2);
            a = multiply(a, a);
        }
        else if(n%2==1){
            a = matrixpower((n-1)/2);
            a = multiply(a, a);
            a = multiply(a, new int[][] {{1,1},{1,0}});
        }

        return a;
    }
    private static int[][] multiply(int[][] m1, int[][] m2){
        int[][] result = new int[2][2];
        result[0][0] = m1[0][0]*m2[0][0] + m1[0][1]*m2[1][0];
        result[0][1] = m1[0][0]*m2[0][1] + m1[0][1]*m2[1][1];
        result[1][0] = m1[1][0]*m2[0][0] + m1[1][1]*m2[1][0];
        result[1][1] = m1[1][0]*m2[0][1] + m1[1][1]*m2[1][1];
        return result;
    }

    /**
     * 用n个2*1的小矩形填充2*n的矩形有几种填法
     * @param target
     * @return
     */
    public static int RectCover(int target) {
        if(target <= 0){
            return 0;
        }

        if(target <= 2){
            return target;
        }

        int f_n_2 = 1;
        int f_n_1 = 2;
        int f = 0;
        for(int i=3; i<=target; i++){
            f = f_n_2 + f_n_1;
            f_n_2 = f_n_1;
            f_n_1 = f;
        }
        return f;
    }

    public static void main(String[] args){
        System.out.println(RectCover(3));
    }
}
