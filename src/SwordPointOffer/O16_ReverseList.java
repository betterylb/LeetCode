package SwordPointOffer;

import BaseDataStructure.ListNode;

public class O16_ReverseList {
    public ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        ListNode reversedHead = null;
        ListNode curNode = head;
        ListNode prev = null;

        while(curNode != null){
            ListNode next = curNode.next;
            if(next == null){
                reversedHead = curNode;
            }

            curNode.next = prev;
            prev = curNode;
            curNode = curNode.next;
        }

        return reversedHead;
    }
}
