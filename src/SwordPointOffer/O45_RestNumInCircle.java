package SwordPointOffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class O45_RestNumInCircle {
    /** k = (m-1)%n
     *
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0)     /* 特殊输入的处理 */
            return -1;
        if (n == 1)     /* 递归返回条件 */
            return 0;
        return (LastRemaining_Solution(n - 1, m) + m) % n;
    }

    public int iterSoultion(int n, int m){
        if(n < 1 || m < 1)
            return -1;
        int last = 0;
        for(int i = 2; i<=n; i++){
            last = (last+m)%i;
        }
        return last;
    }

    public int usingList(int n, int m){
        if(n==0)
            return -1;

        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<n; i++){
            nums.add(i);
        }

        Iterator<Integer> current = nums.iterator();

        while (nums.size()>1){
            for(int i=0; i<m; i++){
                if(current.hasNext()){
                    current.next();
                }
                else {
                    current = nums.iterator();
                    current.next();
                }
            }
            current.remove();
            if(!current.hasNext()){
                current = nums.iterator();
            }
        }

        return current.next();
    }
}
