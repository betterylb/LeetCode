package DSAA_JAVA;

import java.util.*;

public class RebuildHighway {
    public static void main(String[] args){
        //优先级队列默认是小根堆，通过传入一个自定义的比较器
        PriorityQueue<Integer> d = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        d.addAll(Arrays.asList(1,2,2,2,3,3,3,4,5,5,5,6,7,8,10));

//        System.out.println(contain(d, Arrays.asList(1,2,2,2)));
        int n = 6;
        int[] x = new int[7];
        RebuildHighway a = new RebuildHighway();
        boolean result = a.turnpike(x, d, n);
        System.out.println(result);
        for(int i:x){
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public boolean turnpike(int[] x, PriorityQueue<Integer> d, int n){
        x[1] = 0;
        x[n] = d.remove();
        return place(x, d, n, 2, n-1);

    }

    private static boolean place(int[] x, PriorityQueue<Integer> d, int n, int left, int right){
        int dmax;
        boolean found = false;

        if(d.isEmpty()){
            return true;
        }

        dmax = d.peek();

        ArrayList<Integer> out4r = new ArrayList<>();
        for(int i=1; i<left; i++){
            out4r.add(Math.abs(x[i]- dmax));
        }

        for(int i=right+1; i<=n; i++){
            out4r.add(Math.abs(x[i] - dmax));
        }



        if(contain(d, out4r)){
            x[right] = dmax;
            for(int i:out4r){
                d.remove(i);
            }
            found = place(x, d, n, left, right-1);

            if(!found){
                d.addAll(out4r);
            }
        }

        ArrayList<Integer> out4l = new ArrayList<>();
        for(int i=1; i<left; i++){
            out4l.add(Math.abs(x[n]-x[i]- dmax));
        }

        for(int i=right+1; i<=n; i++){
            out4l.add(Math.abs(x[n]-x[i]- dmax));
        }

        if(!found && contain(d, out4l)){
            x[left] = x[n] - dmax;
            for(int i:out4l){
                d.remove(i);
            }

            found = place(x, d, n, left+1, right);

            if(!found){
                d.addAll(out4l);
            }
        }

        return found;
    }

    private static boolean contain(PriorityQueue<Integer> d, List<Integer> out){
        ArrayList<Integer> d_list = new ArrayList<>(d);
        for(Integer i:out){
            if(!d_list.remove(i)){
                return false;
            }
        }
        return true;
    }
}
