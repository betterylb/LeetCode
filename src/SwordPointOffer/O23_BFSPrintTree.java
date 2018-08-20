package SwordPointOffer;

import BaseDataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class O23_BFSPrintTree {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                TreeNode t = queue.poll();
                if (t == null)
                    continue;
                ret.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        return ret;
    }
}
