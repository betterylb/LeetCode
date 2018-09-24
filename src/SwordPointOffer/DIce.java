package SwordPointOffer;

public class DIce {
    public double[] reduceSolution(int n){
        if(n<1)
            return null;
        int maxSum = n*6;
        long[] proba = new long[maxSum - 6 + 1];
        countPoints(n, proba);

        double total = Math.pow(6,n);
        double[] results = new double[maxSum - 6 + 1];
        for(int i=0; i<proba.length; i++){
            results[i] = proba[i]/total;
        }
        return results;
    }

    private void countPoints(int n, long[] proba){
        for(int i=1; i<=6; i++){
            countPoints(n, n, i, proba);
        }
    }

    private void countPoints(int original, int current, int sum, long[] proba){
        if(current == 1)
            proba[sum - original]++;
        else {
            for(int i=1; i<=6; i++){
                countPoints(original, current -1, i+sum, proba);
            }
        }
    }

    public double[] dpSolution(int n){
        if(n < 1){
            return null;
        }

        long[][] points= new long[2][6*n+1];
        int flag = 0;

        // 第一轮掷骰子
        for(int i=1; i<=6; i++)
            points[flag][i] = 1;

        //模拟第k轮掷骰子
        for(int k=2; k<=n; k++){
            for(int i=0; i<k; ++i)
                points[1-flag][i] = 0;

            for(int i=k; i<=6*k; i++){
                points[1-flag][i] = 0;
                for(int j=1; j<=i && j<=6; j++){
                    points[1-flag][i] += points[flag][i-j];
                }
            }
            flag = 1 - flag;
        }
        double[] result = new double[n*6];
        double base = Math.pow(6,n);
        for(int i = 6; i <= 6*n; i++)
            result[i]  = points[flag][i] / base;
        return result;
    }
    public static void main(String[] args){
        DIce a = new DIce();
        double[] results = a.reduceSolution(8);
        double[] r2 = a.reduceSolution(8);
        for(double i:results){
            System.out.print(i+" ");
        }
        System.out.println(" ");
        for(double i:r2){
            System.out.print(i+" ");
        }
    }
}
