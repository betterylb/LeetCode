//括号字符串的有效性和最长有效长度
public class KuoMaxLen{

    //(1)判断括号字符串是否有效
    public static boolean isValid(String str)
    {
        if(str==null||str.equals(""))
        {
            return false;
        }
        //字符串转换为数组
        char[]chas=str.toCharArray();
        int status=0;
        for(int i=0;i<chas.length;i++)
        {
            if(chas[i]!=')'&&chas[i]!='(')
            {
                return false;
            }
        }

        return true;
    }

    //(2)动态规划法求解括号字符串的匹配情况(时间复杂度O(n),空间复杂度O(n))
    //dp[i]的含义是str[0...i]中必须以字符str[i]结尾的最长的有效括号子串长度
    public static int GetKuoMaxLen(String str)
    {
        if(str==null||str.equals(""))
        {
            return -1;
        }
        //判断字符串是否是有效的字符串

        int maxlen=0; //括号字符串的最大长度
        int pre = 0;
        char[]chas=str.toCharArray();//字符串转换成字符数组
        //生成与字符串长度相同的数组
        int[]dp=new int[chas.length];
        dp[0]=0; //一个字符不是有效的匹配括号
        for(int i=1;i<chas.length;i++)
        {

            if(chas[i]==')')
            {
                pre=i-dp[i-1]-1;//之前位置的长度
                if(pre>=0 && chas[pre]=='(')
                {
                    dp[i]=dp[i-1]+2+(pre>0?dp[pre-1]:0);
                }
                maxlen=Math.max(maxlen,dp[i]);

            }

        }

        return maxlen;

    }

    public static void main(String[]args)
    {

        String str1="()(()()(";
        String str2="()(())";
        String str3="()";
        String str4="()a";
        String str5="()()()()()))";

        System.out.println(isValid(str3));
        System.out.println(isValid(str4));

        //最长串的长度
        System.out.println(GetKuoMaxLen(str1));
        System.out.println(GetKuoMaxLen(str2));
        System.out.println(GetKuoMaxLen(str5));

    }

}

