package SwordPointOffer;

import BaseDataStructure.TreeNode;

public class O19_MirrorBinaryTree {
    public void mirrorTransfer(TreeNode binTree){
        if(binTree == null)
            return;
        TreeNode tmp = binTree.left;
        binTree.left = binTree.right;
        binTree.right = tmp;
        mirrorTransfer(binTree.left);
        mirrorTransfer(binTree.right);
    }

    public void traceTree(TreeNode root){
        if(root == null){
            return;
        }
        traceTree(root.left);
        System.out.print(root.val);
        traceTree(root.right);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        O19_MirrorBinaryTree mbTree = new O19_MirrorBinaryTree();
        mbTree.traceTree(root);
        mbTree.mirrorTransfer(root);
        mbTree.traceTree(root);
    }
}
