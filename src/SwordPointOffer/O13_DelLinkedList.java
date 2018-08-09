package SwordPointOffer;

import BaseDataStructure.ListNode;

public class O13_DelLinkedList {
    public void deleteNode(ListNode head, ListNode target){
        if(head == null || head.next == null || target == null){
            return;
        }

        else if (target.next != null){
            ListNode next = target.next;
            target.val = next.val;
            target.next = next.next;
        }
        else {
            ListNode cur = head;
            while(cur.next != target){
                cur = cur.next;
            }
            cur.next = null;
        }
    }

    public static void main(String[] args){
        int x = -1;
        assert x>0;
    }
}
