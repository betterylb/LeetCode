package WrittenTest.PingDuoDuo0805;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * {1,2,4,3,3,3}次数是3， 不能用贪心的递归，
 * 用枚举法先找出所有的升序或者降序序列的组合，再将剩余的序列递归
 */
public class ChooseCard {
    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int [] input = new int[n];
//        for(int i=0; i<n; i++){
//            input[i] = n;
//        }

        int[] input = {1,2,4,3,3,3};
        ChooseCard a = new ChooseCard();
//        int count = Integer.max(a.countTrace(input, true),
//                a.countTrace(input, false));
        System.out.println(input);
    }

    public int countTrace(int[] input, boolean ascend){
        if(input.length == 1){
            return 1;
        }

        int input0 = input[0];
        int[] rest = new int[input.length];
        int j = 0;

        if(ascend){
            for(int i=1; i<input.length; i++){
                if(input[i] > input0){
                    continue;
                }
                else {
                    rest[j++] = input[i];
                    input0 = input[i];
                }
            }
        }
        else {
            for(int i=1; i<input.length; i++){
                if(input[i] < input0){
                    continue;
                }
                else {
                    rest[j++] = input[i];
                    input0 = input[i];
                }
            }
        }

        return 1 + Integer.max(countTrace(Arrays.copyOfRange(rest, 0,j), true),
                countTrace(Arrays.copyOfRange(rest, 0,j), false));

    }

    public void getOrdered(int[] input, boolean ascend, int prev, Map<List<Integer>, List<Integer>> result){
        for(int i:input){
            if(i > prev){

            }
        }
    }
    
}
