package SwordPointOffer;

import java.util.ArrayList;
import java.util.Stack;

public class ReversePrintList {
    public static ArrayList<Integer> printList(ListNode listNode){
        ArrayList<Integer> a = new ArrayList<>();
        if(listNode !=null){
            a.addAll(printList(listNode.next));
            a.add(listNode.val);
        }
        return a;
    }

    public static ArrayList<Integer> printListWithStack(ListNode listNode){
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode tmp = a;
        for(int i=2; i<5;i++){
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        System.out.println(printList(a));
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
       this.val = val;
    }
}