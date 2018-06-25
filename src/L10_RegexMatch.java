import java.util.regex.Pattern;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。

 '.' 匹配任意单个字符。
 '*' 匹配零个或多个前面的元素。
 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。

 说明:

 s 可能为空，且只包含从 a-z 的小写字母。
 p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。

 示例 1:
 输入:
 s = "aa"
 p = "a"
 输出: false
 解释: "a" 无法匹配 "aa" 整个字符串。


 示例 2:
 输入:
 s = "aa"
 p = "a*"
 输出: true
 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。

 示例 3:
 输入:
 s = "ab"
 p = ".*"
 输出: true
 解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 示例 4:

 输入:
 s = "aab"
 p = "c*a*b"
 输出: true
 解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
 示例 5:

 输入:
 s = "mississippi"
 p = "mis*is*p*."
 输出: false
 */

public class L10_RegexMatch {

    public static void main(String[] args){
        System.out.println(reduceSolution("aaa","a*a"));
    }

    /**
     * 这个解答不行，因为"a*a"对应"aaa"难以解决
     * @param s
     * @param p
     * @return
     */
    public static boolean scanSoulution(String s, String p){

        int j = 0;
        int i = 0;
        for(; i<p.length(); i++){
            if(i < p.length()-1 && p.charAt(i+1) == '*'){
                while(j<s.length() && matchSingle(s, p.charAt(i), j)){
                    j++;
                }
                int l = i+2;
                while (l<p.length() && p.charAt(l) == s.charAt(i)){
                    l++;
                }
                i = l-1;
            }
            else {
                if(matchSingle(s, p.charAt(i), j)){
                    j++;
                }
                else
                    return false;
            }
        }
        if(i < p.length()) return false;
        else return true;
    }

    static boolean matchSingle(String s,char a, int index){
        if(index>=s.length()) return false;
        if(a == '.') return true;
        else{
            if (a==s.charAt(index)) return true;
            else return false;
        }
    }

    public static boolean reduceSolution(String s, String p){
        if(p.isEmpty()) return s.isEmpty();
        boolean first_match = !s.isEmpty() && (p.charAt(0)==s.charAt(0) || p.charAt(0)=='.');

        if(p.length() >=2 && p.charAt(1) == '*'){
            return reduceSolution(s, p.substring(2)) //重复0次
                    || (first_match && reduceSolution(s.substring(1), p)); //重复1或多次
        }
        else {
            return first_match && reduceSolution(s.substring(1), p.substring(1));
        }
    }
}
