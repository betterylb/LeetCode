package SwordPointOffer;

public class O10_BitCalc {
    public static int numberOf1(int n){
        int count = 0;
        int flag = 1;

        //这里跟c的实现不一样，因为java没有无符号数。
        while ( flag !=0 ){
            if( (n & flag) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static int decreaseSolution(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(decreaseSolution(-3));
        System.out.println(Integer.bitCount(-3));
    }
}
