import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class SocialRecommand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        sc.nextLine();

        HashSet<Integer>[] friendship = new HashSet[n];
        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            String line = sc.nextLine();
            Scanner sc_line = new Scanner(line);
            HashSet<Integer> tmpSet = new HashSet<>();
            while(sc_line.hasNextInt()) {
                int a = sc_line.nextInt();
                tmpSet.add(a);
            }

            friendship[i] = tmpSet;
        }

        int max = 0;
        int max_index = -1;
        for(int i=0; i<n; i++){
            System.out.println(friendship[target]);
            if(i == target || friendship[i].contains(i)){
                result[i] = 0;
                continue;
            }

            HashSet<Integer> tmp = new HashSet<>();
            tmp.addAll(friendship[target]);
            tmp.retainAll(friendship[i]);

            if(tmp.size() > max){
                max = tmp.size();
                max_index = i;
            }
        }
        System.out.println(max_index);
    }
}
