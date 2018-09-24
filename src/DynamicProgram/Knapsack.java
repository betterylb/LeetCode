package DynamicProgram;

/**
 *动态规划背包问题，NP完备的，子序列和可以规约到其中,是子问题(0-1背包问题）
 *类似的还有硬币找零问题(无限背包问题)
 */

public class Knapsack {
    public void subsetSum(){
    }

    /**
     * 递归的方案，难以对选择了那些物品做记录
     * opt(i, w)表示 1, ... ,i物品的最大值。
     *
     * opt(i, w)= { 0,   if i=0
     *              opt(i-1, w), if wi>w
     *              max{opt(i-1,w), vi+opt(i-1, w-wi)}, otherwise
     *             }
     *
     * @param values: 待选择的物品价值
     * @param weights: 带选择物品的重量
     * @param W: 背包容量限制
     */
    public static int knapsackReduce(int[] values, int[] weights, int i, int W){
        if(i < 0){
            return 0;
        }
        if(weights[i] > W){
            return knapsackReduce(values, weights,i-1, W);
        }
        return Integer.max(knapsackReduce(values, weights,i-1, W),
                values[i] + knapsackReduce(values, weights,i-1, W-weights[i]));
    }

    public static int knapsackDp(int[] values, int[] weights, int[] record, int W){
        int [][] opt = new int[values.length+1][W+1];
        for(int i = 0; i<W+1; i++) opt[0][i] = Integer.MIN_VALUE;

        for(int i=1; i<values.length+1; i++){
            for(int w=1; w<W+1; w++){
                if(weights[i-1] > w){
                    opt[i][w] = opt[i-1][w];
                }
                else {
                    if(opt[i-1][w] > opt[i-1][w-weights[i-1]]+values[i-1]){
                        opt[i][w] = opt[i-1][w];
                    }
                    else {
                        opt[i][w] = opt[i-1][w-weights[i-1]]+values[i-1];
                        record[i-1] = 1;
                    }
//                    opt[i][w] = Integer.max(opt[i-1][w],
//                            opt[i-1][w-weights[i-1]]+values[i-1]);
                }
            }
        }
        return opt[values.length][W];
    }

    public static int knapsackDpPromot(int[] values, int[] weights, int[] record, int W){
        int[] opt = new int[W+1];
        for(int i = 0; i<W+1; i++) opt[i] = 0;

        for(int i=1; i<values.length+1; i++){
            for(int w=W; w>0; w--){
                if(weights[i-1] > w){
                    opt[w] = opt[w];
                }
                else {
                    opt[w] = Integer.max(opt[w],opt[w-weights[i-1]]+values[i-1]);
                }
            }
        }

        return opt[W];
    }

    public static void main(String[] args){
        int[] values = {28,22,18,6,1};
        int[] weights = {7,6,5,2,1};
        int[] record = new int[values.length];
        System.out.println(knapsackDpPromot(values, weights, record,30));
        System.out.println(Integer.MIN_VALUE);
    }
}
