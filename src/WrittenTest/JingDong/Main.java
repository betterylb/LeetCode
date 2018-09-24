package WrittenTest.JingDong;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        int groups=in.nextInt();

        for(int group=0; group<groups; group++) {

            int n=in.nextInt();
            Node[] graph=new Node[n];
            for(int i=0; i<n; i++) {
                graph[i] = new Node(i+1);
            }

            int m = in.nextInt();

            for(int i=0;i<m;i++) {
                int v1=in.nextInt();
                int v2=in.nextInt();
                graph[v1-1].links.add(v2);
                graph[v2-1].links.add(v1);
            }

            if(judge(graph)) {
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }


    private static boolean judge(Node[] graph) {
        int n = graph.length;
        ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();


        boolean result = false;
        int index=1;

        for(int i=0; i<n; i++) {

            for(HashSet<Integer> set:list) {
                if(set.contains(i+1)) {
                    result=true;
                    index=list.indexOf(set);
                    break;
                }
            }


            if( result==false ) {
                HashSet<Integer> set=new HashSet<Integer>();
                set.add(i+1);
                for(int j=0; j<n; j++) {
                    if( i!=j && !graph[i].links.contains(j+1)) {
                        for(Set<Integer> set1:list) {
                            if(set.contains(j+1))
                                return false;
                        }
                        set.add(j+1);
                    }
                }
                list.add(set);
            }else {
                for(int k=0;k<n;k++) {
                    if(!list.get(index).contains(k+1)&&!graph[i].links.contains(k+1))
                        return false;
                }
                result=false;
            }
        }
        return true;
    }
}
class Node{
    int id;
    HashSet<Integer> links = new HashSet<>();

    Node(int id){
        this.id=id;
    }
}

