package SwordPointOffer;

public class O24_VerifySquenceOfBST {
    public boolean verify(int[] sequence){
        if(sequence == null || sequence.length <= 0){
            return false;
        }

        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int start, int end){
//        if(end - start <= 1){
//            return true;
//        }

        int root = sequence[end];

        int i = start;
        for(; i<end; i++){
            if(sequence[i] > root)
                break;
        }

        int j=i;
        for(; j<end; j++){
            if(sequence[j] < root)
                return false;
        }

        boolean left = true;
        boolean right = true;

        if(i>start){
            left = verify(sequence, start, i-1);
        }

        if(i<end){
            right = verify(sequence, i, end-1);
        }

        return left && right;
    }
}
