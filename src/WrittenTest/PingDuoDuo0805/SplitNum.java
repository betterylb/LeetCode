package WrittenTest.PingDuoDuo0805;

import java.util.Scanner;

public class SplitNum {
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
        String str = "000011";
        int len = str.length();


        int count = 0;
        for(int i=1; i<len; i++){
            String s1 = str.substring(0, i);
            String s2 = str.substring(i, len);
            int s1_num = 0;
            int s2_num = 0;

            if(s1.charAt(0) == '0' && s1.charAt(s1.length()-1) == '0'){
                if(s1.length() == 1){
                    s1_num = 1;
                }
                else {
                    continue;
                }
            }
            else if(s1.charAt(0) == '0' && s1.charAt(s1.length()-1) != '0'){
                s1_num = 1;
            }
            else if(s1.charAt(0) != '0' && s1.charAt(s1.length()-1) == '0'){
                s1_num = 1;
            }
            else {
                s1_num = s1.length();
            }

            if(s2.charAt(0) == '0' && s2.charAt(s2.length()-1) == '0'){
                if(s2.length() == 1){
                    s2_num = 1;
                }
                else {
                    continue;
                }
            }
            else if(s2.charAt(0) == '0' && s2.charAt(s2.length()-1) != '0'){
                s2_num = 1;
            }
            else if(s2.charAt(0) != '0' && s2.charAt(s2.length()-1) == '0'){
                s2_num = 1;
            }
            else {
                s2_num = s2.length();
            }

            count += s1_num*s2_num;
        }

        System.out.println(count);
    }
}
