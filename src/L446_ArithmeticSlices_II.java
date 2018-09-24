import java.util.*;

/**
 * 数组中的等差子序列的个数
 */
public class L446_ArithmeticSlices_II {
    // 记录长度
    private int n;
    // 子序列数量
    private int ans;

    // 回溯法递归暴力计算等差序列，计算复杂度O(2^n)
    private void dfs(int dep, int[] A, List<Integer> cur) {
        if (dep == n) {
            if (cur.size() < 3) {
                return;
            }
            long diff = cur.get(1) - cur.get(0);
            for (int i = 1; i < cur.size(); i++) {
                if (cur.get(i) - cur.get(i - 1) != diff) {
                    return;
                }
            }
            ans++;
            return;
        }
        dfs(dep + 1, A, cur);
        cur.add((Integer) A[dep]);
        dfs(dep + 1, A, cur);
        cur.remove((Integer) A[dep]);
    }
    public int numberOfArithmeticSlices(int[] A) {
        n = A.length;
        ans = 0;
        List<Integer> cur = new ArrayList<>();
        dfs(0, A, cur);
        return ans;
    }

    /**
     * 动态规划
     * f[i][d]代表等差数列公差为d，且数列最后一个元素是A[i]的弱等差数列个数
     *  for all j<i:
     *      f[i][A[i]-A[j]] += (f[j][A[i]-A[j]] + 1)
     *  定义一个“弱等差序列”如下：
     *      包含至少2个元素，且公差相同的序列
     *  而当A[i]可以加入等差序列时，等差序列数等于f[j][A[i]-A[j]]
     *
     * @param A
     * @return
     */
    public int dpSolution(int[] A){
        int n = A.length;
        long ans = 0;
        Map<Integer, Integer>[] cnt = new Map[n];
        for (int i = 0; i < n; i++) {
            cnt[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
                long delta = (long)A[i] - (long)A[j];
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }
                int diff = (int)delta;
                int sum = cnt[j].getOrDefault(diff, 0);
                int origin = cnt[i].getOrDefault(diff, 0);
                cnt[i].put(diff, origin + sum + 1);
                ans += sum;
            }
        }
        return (int)ans;
    }

    public static void main(String[] args){
        L446_ArithmeticSlices_II a = new L446_ArithmeticSlices_II();
        System.out.println(a.numberOfArithmeticSlices(new int[] {1,2,4,7,10,18}));
    }
}
