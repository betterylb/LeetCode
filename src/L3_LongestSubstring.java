import java.util.*;


/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。

 示例：

 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。

 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。

 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */

public class L3_LongestSubstring {
    public static void main(String[] args){
//        List<Integer> a = new LinkedList<>(Arrays.asList(1,2,3,4));
//        System.out.println(a);
        L3_LongestSubstring a = new L3_LongestSubstring();
        System.out.println(a.lengthOfLCS("abba"));
    }

    public int lengthOfLCS(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int i = 0, j = 0; i < s.length(); i++) {
            char sub = s.charAt(i);
            if (map.containsKey(sub)) {
                j = Math.max(map.get(sub)+1, j);
            }
            max = Integer.max(max, j - i + 1);
            map.put(sub, i);
        }
        return max;
    }

    //暴力解法超时,简单减少最开始循环勉强通过
    public int useHashset(String s) {
        int max = Integer.MIN_VALUE;
        HashSet<Character> sset = new HashSet<Character>(){{
            for (char a:s.toCharArray()){
                add(a);
            }
        }
        };

        for (int i = 0; i <= sset.size(); i++) {
            for (int j=0; j<= s.length() - i; j++){
                String substr = s.substring(j, j+i);
                HashSet<Character> stringset = new HashSet<Character>(){{
                    for (char a:substr.toCharArray()){
                        add(a);
                    }
                }
                };

                if(stringset.size() == i){
                    max = Integer.max(max, i);
                    break;
                }
            }
        }
        return max;
    }
}



