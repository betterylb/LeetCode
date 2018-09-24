package WrittenTest.NetEase;

import java.util.ArrayList;
import java.util.Scanner;

public class BuyHouse {

    public static void buyHosue(ArrayList<ArrayList<Integer>> neighbors){
        for(ArrayList<Integer> neighbor:neighbors){
            int n = neighbor.get(0);
            int k = neighbor.get(1);

            int rest = n-k;
            int empty = k-1;

            int maxHouse;
            if(rest <= empty){
                maxHouse = rest;
            }else{
                maxHouse = empty;
            }
            if(maxHouse < 0){
                maxHouse = 0;
            }
            System.out.println(0 +" "+maxHouse);
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        ArrayList<ArrayList<Integer>> neighbors=new ArrayList<>();
        for(int i=0;i<test;i++){
            int n=scanner.nextInt();
            int k=scanner.nextInt();

            ArrayList<Integer> neighbor=new ArrayList<>();
            neighbor.add(n);
            neighbor.add(k);
            neighbors.add(neighbor);
        }
        buyHosue(neighbors);
    }
}

