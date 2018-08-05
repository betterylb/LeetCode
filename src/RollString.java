import java.util.Scanner;

public class RollString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String target = in.nextLine();
        int strLen = target.length();
        int k = strLen/4;

        System.out.println(target.substring(0,k+1));

        for (int i = 1;i < k; i++){
            System.out.print(target.charAt(strLen - i));
            for(int j=1; j < k;j++){
                System.out.print(" ");
            }
            System.out.println(target.charAt( k + i));
        }

        for (int i=strLen-k;i>=strLen-2*k; i--){
            System.out.print(target.charAt(i));
        }

    }
}