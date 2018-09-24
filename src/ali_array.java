import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ali_array {
    public static void numOfSubarray(int[] a, int max, int min){
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i=0; i<a.length;i++){
            numMap.put(a[i], i);
        }
        if(a.length < 3){
            System.out.println(0);
            return;
        }
        if(a.length == 3){
            if(a[0] + a[2] == 2*a[1]){
                System.out.println(1);
                return;
            }
            else {
                System.out.println(0);
                return;
            }
        }

        for(int gap = 1; gap<max-min; gap++){
            ArrayList<Integer> rest = new ArrayList<>();
            int count = 1;
            for(int i = 2; i<a.length;i++){
                if(a[i-1] + gap == a[i]){
                    count += 1;
                }
                else {
                    rest.add(a[i]);
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
            max = Integer.max(a[i], max);
            min = Integer.min(a[i], min);
        }
        numOfSubarray(a, max, min);
    }
}
