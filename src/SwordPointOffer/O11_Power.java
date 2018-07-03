package SwordPointOffer;

public class O11_Power {
    public static double power(double base, int exponent) throws ArithmeticException{
        if(Double.compare(base, 0.0) == 0 && exponent < 0){
            throw new ArithmeticException();
        }

        double result = 1.0;
        int abs_exp = Math.abs(Math.abs(exponent));
        for(int i = 0; i<abs_exp; i++){
            result *= base;
        }

        if(exponent < 0){
            result = 1.0/result;
        }
        return result;
    }

    /**
     * 递归的方式，时间复杂度O(log n)
     * @param base
     * @param exponent
     * @return
     */
    public static double reducePower(double base, int exponent) throws ArithmeticException{
        if(base == 0 && exponent < 0){
            throw new ArithmeticException("0的指数不能为负数");
        }

        if(exponent == 0){
            return 1.0;
        }

        if(exponent == 1 || exponent == -1){
            return base;
        }

        double result = reducePower(base, exponent >> 1);
        result *= result;
        //更快的方式判断就
        if((exponent & 1) == 1){
            result *= base;
        }

        if(exponent < 0){
            result = 1.0/result;
        }

        return result;

    }

    public static void main(String[] args){
        double a = 3;
        System.out.println(reducePower(0, 0));
        System.out.println(Integer.toBinaryString(-4));
    }
}
