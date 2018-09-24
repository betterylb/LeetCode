package WrittenTest.JingDong;

import java.util.Scanner;

public class BUhege {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] things = new int[n][3];

        for(int i=0; i<n; i++){
            things[i][0] = sc.nextInt();
            things[i][1] = sc.nextInt();
            things[i][2] = sc.nextInt();
        }

        int result = 0;

        for(int i=0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(things[i][0] < things[j][0]
                        && things[i][1] < things[j][1]
                        && things[i][2] < things[j][2]){
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);

    }
}





