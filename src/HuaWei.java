public class HuaWei {
    public static int longest(String s) {
        int index = 0;
        char[] ca = s.toCharArray();
        int prev;
        int maxLen = 0;
        int len;

        while (index<ca.length) {
            while (index<ca.length && ca[index]!=')')
                index++;
            if (index==ca.length)
                break;
            prev = index-1;
            while (prev>=0 && ca[prev]=='-')
                prev--;
            if (prev>=0 && ca[prev]=='(') {
                ca[prev] = '-';
                ca[index] = '-';
            }
            index ++;
        }

        index = 0;
        while (index<ca.length) {
            while (index<ca.length && ca[index]!='-')
                index++;
            if (index==ca.length)
                break;
            int start = index;
            while (index<ca.length && ca[index]=='-')
                index++;
            len = index-start;
            if (len>maxLen)
                maxLen = len;
        }

        return maxLen;
    }

    public static void main(String[] args){
        System.out.println(longest("()(()()("));
    }
}
