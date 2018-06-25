/**
 * 深信服笔试遇到的一个题，找出一个字符串中最长的重复子串的长度；
 * 例如："abcabab"，中最长的就是"abab", 长度为4.
 *
 * 解题思路：KMP算法的next数组计算过程跟这个比较相似，只不过需要判断 next[i]是否等于i/2
 */

public class LongestDuplicate {
    private static int calc_next(String ptr){
        int max = 0;
        int k = -1;
        int[] next= new int[ptr.length()];
        next[0] = -1;

        for(int i=1; i<ptr.length(); i++){
            while(k > -1 && ptr.charAt(k+1) != ptr.charAt(i)){
                k = next[k];
            }

            if(ptr.charAt(k+1) == ptr.charAt(i)){
                k++;
            }
            next[i] = k;

            //要注意next数组中项的含义，表示的是最大前缀的最后一个字符位置，
            //例如："aaa"的最大前缀和后缀都是"aa",此时，那个位置标号1是重叠的。
            if(next[i] == i/2 && i%2 != 0){
                max = Integer.max(i+1, max);
            }
        }

        return max;
    }

    public static int kmpSolution(String str){
        int max = 0;
        for(int i=0; i<str.length(); i++){
            max = Integer.max(max, calc_next(str.substring(i)));
        }
        return max;
    }

    public static void main(String[] main){
        System.out.println(kmpSolution("acaaaba"));
    }
}
