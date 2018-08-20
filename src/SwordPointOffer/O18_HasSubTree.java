package SwordPointOffer;

import BaseDataStructure.TreeNode;

public class O18_HasSubTree {
    public static boolean hasSubTree(TreeNode root1, TreeNode root2){
        boolean result = false;

        if(root1 != null && root2 != null){
            if(root1.val == root2.val){
                result = doesTree1HaveTree2(root1, root2);
            }
            if(!result){
                result = hasSubTree(root1.left, root2);
            }
            if(!result){
                result = hasSubTree(root1.right, root2);
            }
        }

        return result;
    }

    private static boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2){
        if(root2 == null){
            return true;
        }

        if(root1 == null){
            return false;
        }

        if(root1.val != root2.val){
            return false;
        }

        return doesTree1HaveTree2(root1.left, root2.left)
                && doesTree1HaveTree2(root1.right, root2.right);
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(0);
        TreeNode root2 = null;

        System.out.println(O18_HasSubTree.hasSubTree(root1, root2));
    }
}
