package SwordPointOffer;

public class RotateString {
    public String LeftRotateString(String str,int n) {
        if(n >= str.length()){
            return str;
        }

        char[] chars = str.toCharArray();
        reverse(chars,0, n-1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    public String ReverseSentence(String str) {
        if(str == null || str.length() == 0){
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int prev = 0;
        int head = 0;

        while (head <= str.length()){
            if(head == str.length() || chars[head] == ' '){
                reverse(chars, prev, head - 1);
                prev = head + 1;
            }
            head++;
        }
        return new String(chars);
    }

    private void reverse(char[] str, int start, int end){
        while (start < end){
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args){
        String str = "I am a student";
        char[] chars = str.toCharArray();
        RotateString a = new RotateString();
        System.out.println(a.ReverseSentence(str));
    }
}
