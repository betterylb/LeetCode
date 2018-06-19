/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。

 示例 1：

 输入: "babad"
 输出: "bab"
 注意: "aba"也是一个有效答案。
 示例 2：

 输入: "cbbd"
 输出: "bb"
 */

import javafx.scene.transform.MatrixType;

import java.util.HashMap;

public class L5_LongestPalindrome {
    public static void main(String[] args){
        System.out.println(midExpansion("babad"));
    }


    /**
     * 思路是翻转后求最长公共子数组，但是"abcdasdfghjkldcba"这个例子指出，并不是所有的公共字数组都成立。
     * @param s
     * @return
     */
    public static String greedSolution(String s){
        int [][] matrix = new int[s.length()][s.length()];
        int max = 0;
        int[] max_list = new int[s.length()];
        int index = 0;
        String palimater = null;
        String reverse_s = new StringBuilder(s).reverse().toString();
        for(int i=0; i<s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == reverse_s.charAt(j)) {
                    if (i != 0 && j != 0) {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    } else matrix[i][j] = 1;
                }
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    index = j;
                }
            }
        }
        return s.substring(index-max+1, max+1);
    }

    /**
     * 中心扩散算法。
     * @param s
     * @return
     */
    public static String midExpansion(String s){
        int start=0, end=0;

        for(int i=0; i<s.length(); i++){
            int l1 = expansion(s, i, i);
            int l2 = expansion(s, i, i+1);
            int len = Integer.max(l1,l2);
            if(len > end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }

        return s.substring(start, end+1);
    }

    private static int expansion(String s, int left, int right){
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
