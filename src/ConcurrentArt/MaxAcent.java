package ConcurrentArt;

import java.util.ArrayList;

public class MaxAcent {
    public static int findDecent(int[] a){
        ArrayList<int[]> pairs = new ArrayList<>();
        ArrayList<int[]> checkpoints = new ArrayList<>();

        int start = 0;
        int end = 0;

        for(int i=0; i<a.length-1; i++){
            if(a[i] < a[i+1]){
                continue;
            }
            else {
                end = i;
                if(start < end){
                    int [] pair = {start, end};
                    pairs.add(pair);
                }
                start = i+1;
            }
        }
        int max = 0;
        for(int[] pair:pairs){
            max = Integer.max(max, pair[1]-pair[0]+1);
        }

        int[] delete;

        for(int i = 0; i<pairs.size()-1; i++){
            int[] prev = pairs.get(i);
            int[] next = pairs.get(i+1);
            if(next[0] - prev[1] == 1){
                if(a[prev[1]-1] < a[next[0]] || a[prev[1]] < a[next[0]+1]){
                    max = Integer.max(max, next[1]-prev[0]);
                }
            }
            else if(next[0] - prev[1] == 2){
                if(a[next[0]] > a[prev[1]]){
                    max = Integer.max(max, next[1]-prev[0]);
                }
            }
            else {
                if(a[prev[1]] < a[prev[1]+2] ){
                    max = Integer.max(max, prev[1]-prev[0]+2);
                }
                if(a[next[0]-2] < a[next[0]]){
                    max = Integer.max(max, next[1]-next[0]+2);
                }
            }

        }
        return max;
    }

    public static void main(String[] args){
        int[] a = {1,2};
        System.out.println(findDecent(a));
    }
}
