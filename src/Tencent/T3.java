package Tencent;

import java.util.Scanner;

public class T3{
    public static void determin(int[] a, int[] b, int[] c){
        int n = a.length;
        for(int i=0; i<n; i++){
            int tmpa=a[i];
            int tmpb=b[i];
            int tmpc=c[i];
            boolean result = false;
            for(int j=0; j<tmpb; j++){
                if((tmpa*j)%tmpb==tmpc){
                    result=true;
                }
            }

            if(result){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        int[] c=new int[n];


        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            a[i]=sc.nextInt();
            a[i]=sc.nextInt();
        }

        determin(a,b,c);
    }

}

