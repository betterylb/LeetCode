import java.util.ArrayList;
import java.util.List;

public class StringAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();

        int[] map = new int[256];

        for (int i = 0; i < pArray.length; i++) {
            map[pArray[i]]--;
            map[sArray[i]]++;
        }
        int difference = 0;
        for (int i = 0; i < 256; i++) {
            difference += Math.abs(map[i]);
        }
        if (difference == 0) {
            result.add(0);
        }

        for (int i = 0; i < sArray.length - pArray.length; i++) {
            difference = difference - Math.abs(map[sArray[i]]);
            map[sArray[i]]--;
            difference = difference + Math.abs(map[sArray[i]]);

            difference = difference - Math.abs(map[sArray[i + pArray.length]]);
            map[sArray[i + pArray.length]]++;
            difference = difference + Math.abs(map[sArray[i + pArray.length]]);
            if (difference == 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args){
        String s = "baebabacd";
        String p = "abc";

        List<Integer> result = findAnagrams(s, p);
        System.out.println(result);
    }
}
