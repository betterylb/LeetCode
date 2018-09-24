package WrittenTest.NetEase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Selction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] votes = new int[m];
        sc.nextLine();
        ArrayList<ArrayList<Integer>> candies = new ArrayList<>();
        for(int i=0;i<m;i++){
            candies.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++) {
            String line = sc.nextLine();
            Scanner sc_line = new Scanner(line);
            int voter = sc_line.nextInt();
            int candie = sc_line.nextInt();
            votes[voter-1]++;
            candies.get(voter-1).add(candie);
        }

        int[] c = votes.clone();
        Arrays.sort(c);
        if(c[c.length-1] == votes[0]){
            System.out.println(0);
        }
    }
}
