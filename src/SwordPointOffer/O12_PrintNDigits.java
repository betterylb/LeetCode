package SwordPointOffer;

public class O12_PrintNDigits {
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, -1);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length - 1) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit + 1] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }

    public static void main(String[] args){
        O12_PrintNDigits a = new O12_PrintNDigits();
        a.print1ToMaxOfNDigits(-1);
    }
}
