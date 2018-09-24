/**
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 例如，以下数列为等差数列:
 *
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 以下数列不是等差数列。
 *
 * 1, 1, 2, 5, 7
 *
 *
 * 数组A包含N个数，且索引从0开始。数组A的一个子数组划分为数组(P, Q)，P与Q是整数且满足0<=P<Q<N。
 *
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 *
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 *
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 *
 * 示例:
 *
 * A = [1, 2, 3, 4]
 *
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 */


public class L413_ArithmeticSlices {
    /**
     * 注意这里子数组划分是连续划分的，即子数组相邻的元素在原数组中相邻
     * @param A
     * @return
     */
    public static int numberOfArithmeticSlices(int[] A) {
        if(A.length<3){
            return 0;
        }

        int number = 1;
        int res = 0;
        int diff = A[1] - A[0];

        for(int i=2; i<A.length; i++){
            if(A[i] - A[i-1] == diff){
                res += number++;
            }
            else {
                diff = A[i] - A[i-1];
                number = 1;
            }
        }

        return res;
    }

    public static void main(String[] args){
        System.out.println(numberOfArithmeticSlices(new int[] {1,2,4,7,10,18}));
    }
}
