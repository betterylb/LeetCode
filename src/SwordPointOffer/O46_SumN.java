package SwordPointOffer;

public class O46_SumN {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    public O46_SumN(){
        N++;
        sum += N;
    }

    public static int getSum(){
        return sum;
    }

    private static int N;
    private static int sum;

    public static int sumSolution2(int n){
        O46_SumN[] a = new O46_SumN[n];
        return O46_SumN.getSum();
    }

    public static void main(String[] args){
        System.out.println(sumSolution2(3));
    }
}
