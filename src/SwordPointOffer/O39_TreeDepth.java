package SwordPointOffer;

import BaseDataStructure.TreeNode;

public class O39_TreeDepth {
    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return Integer.max(leftDepth+1, rightDepth+1);
    }
}
