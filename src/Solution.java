public class Solution {
    // 求解字符串中的最长重复子串
    public static String maxRepat(String input) {
        // 参数检查
        if (input == null || input.length() == 0) {
            return null;
        }
        // 重复子串的最长长度
        int max = 0;
        // 最长重复子串的起始位置
        int first = 0;
        int k = 0;
        for (int i = 1; i < input.length(); i++) {
            for (int j = 0; j < input.length() - i; j++) {
                if (input.charAt(j) == input.charAt(i + j)) {
                    k++;
                } else {
                    k = 0;
                }
                if (k > max) {
                    max = k;
                    first = j - k + 1;
                }
            }
        }
        if (max > 0) {
            System.out.println(max);
            return input.substring(first, first + max);
        }
        return null;
    }

    public static void main(String[] args) {
        String str1 = "hellowdhelloko";
        String result = Solution.maxRepat(str1);
        System.out.println(result);
    }
}

