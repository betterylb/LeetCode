package SwordPointOffer;

public class O47_Sum {
    public static int add(int num1, int num2){
        int sum;
        int carry;

        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        }while (num2 != 0);

        return num1;
    }

    public static void main(String[] args){
        System.out.println(add(3, -1));
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(2));
    }
}
