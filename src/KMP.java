public class KMP {

    /**
     * 失配的时候回退到之前最小匹配的地方
     * @param ptr
     * @param next
     */
    public static void calc_next(String ptr, int[] next){
        int k = -1;
        next[0] = -1;
        for(int i=1; i<ptr.length(); i++) {
            while (k > -1 && ptr.charAt(k + 1) != ptr.charAt(i)) {
                k = next[k];//失配回退
            }

            if (ptr.charAt(k + 1) == ptr.charAt(i)) {
                k++;
            }
            next[i] = k;
        }
    }

    public static int kmp(String str, String ptr){
        int[] next = new int[ptr.length()];
        calc_next(ptr, next);
        int k = -1;
        for(int i=0; i<str.length(); i++){
            while (k > -1 && ptr.charAt(k+1) != str.charAt(i)){
                k = next[k];
            }
            if(ptr.charAt(k+1) == str.charAt(i)){
                k++;
            }

            if (k == ptr.length() -1 ){
                return i- ptr.length()+1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] next = new int[8];
        calc_next("abaabcac", next);
        for(int i : next){
            System.out.print(i+ " ");
        }
    }
}
