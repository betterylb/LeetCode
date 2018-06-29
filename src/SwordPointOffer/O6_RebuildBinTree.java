package SwordPointOffer;

import java.util.HashMap;

public class O6_RebuildBinTree {
    private HashMap<Integer, Integer> inMap= new HashMap<>();

    public TreeNode reBuild(int[] pre, int[] in){
        if(pre == null || pre.length == 0 || in == null || in.length == 0){
            return null;
        }
        for(int i = 0; i<in.length; i++) inMap.put(in[i], i);

        return reBuild(pre, 0, pre.length-1,
                       in, 0, in.length-1);
    }

    public TreeNode reBuild(int[] pre, int pre_start, int pre_end,
                            int[] in, int in_start, int in_end)
    {
        if(pre_start > pre_end){
            return null;
        }


        int in_mid = in_start;
        TreeNode root = new TreeNode(pre[pre_start]);
        /**
        for (int i = in_start; i <= in_end; i++){
            if(in[i] == pre[pre_start]){
                in_mid = i;
                break;
            }
        }*/
        in_mid = inMap.get(pre[pre_start]);
        root.left = reBuild(pre, pre_start+1, pre_start+in_mid-in_start,
                            in, in_start, in_mid-1);

        root.right = reBuild(pre,pre_start+in_mid-in_start+1, pre_end,
                             in,in_mid+1, in_end);
        return root;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
