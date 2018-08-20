package SwordPointOffer;

import BaseDataStructure.TreeNode;

public class O27_Convert {
    public TreeNode convert(TreeNode root){
        TreeNode[] tail = new TreeNode[1];
        convert(root, tail);
        TreeNode head = tail[0];
        while (head != null && head.left !=null){
            head = head.left;
        }
        return head;
    }

    private static void convert(TreeNode root, TreeNode[] tail){
        if(root == null)
            return;

        if(root.left != null)
            convert(root.left, tail);

        root.left = tail[0];

        if(tail[0] != null)
            tail[0].right = root;

        tail[0] = root;

        if(root.right != null)
            convert(root.right, tail);
    }

    public static void main(String[] args){
        O27_Convert a = new O27_Convert();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        TreeNode cursor = root.right;
        cursor.left = new TreeNode(4);
        a.convert(root);
    }
}
