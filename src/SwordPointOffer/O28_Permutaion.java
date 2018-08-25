package SwordPointOffer;

import java.util.ArrayList;
import java.util.Arrays;

public class O28_Permutaion {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str == null || str.length() <= 0)
            return result;
        char[] chrs = str.toCharArray();
        Arrays.sort(chrs);
        backtrace(chrs, new StringBuffer(), new boolean[str.length()], result);
        return result;
    }

    private static void backtrace(char[] chrs, StringBuffer s, boolean[] hasUsed, ArrayList<String> result){
        if (s.length() == chrs.length){
            result.add(s.toString());
        }
        for(int i = 0; i<chrs.length; i++){
            if(hasUsed[i]){
                continue;
            }

            if(i!=0&&chrs[i] == chrs[i-1]&& !hasUsed[i-1]){
                continue;
            }

            hasUsed[i] = true;
            s.append(chrs[i]);
            backtrace(chrs, s, hasUsed, result);
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }
    }

}
