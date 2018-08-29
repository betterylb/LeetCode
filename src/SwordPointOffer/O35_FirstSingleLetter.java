package SwordPointOffer;

import java.util.HashMap;

public class O35_FirstSingleLetter {
    public static int searchNum(String str){
        int len = str.length();
        int[] records = new int[len];
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), i);
            }
            records[map.get(str.charAt(i))]++;
        }

        int index = 0;
        for(;index<len; index++){
            if(records[index] == 1){
                break;
            }
        }

        return index<len?index:-1;
    }

    public int FirstNotRepeatingChar(String str) {
        int[] cnts = new int[256];
        for (int i = 0; i < str.length(); i++)
            cnts[str.charAt(i)]++;
        for (int i = 0; i < str.length(); i++)
            if (cnts[str.charAt(i)] == 1)
                return i;
        return -1;
    }
}
