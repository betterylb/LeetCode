package LinkedList;

/**
 * 1.给一个单链表，判断其中是否有环的存在；
 *
 * 2.如果存在环，找出环的入口点；
 *
 * 3.如果存在环，求出环上节点的个数；
 *
 * 4.如果存在环，求出链表的长度；
 *
 * 5.如果存在环，求出环上距离任意一个节点最远的点（对面节点）；
 *
 * 6.（扩展）如何判断两个无环链表是否相交；
 *
 * 7.（扩展）如果相交，求出第一个相交的节点；
 */

import BaseDataStructure.ListNode;

import java.util.Iterator;
import java.util.LinkedList;

public class FindCircle {
    public <T> boolean fromLinkedList(LinkedList<T> head){
        Iterator<T> iter = head.iterator();
        //Todo
        return true;
    }

    public boolean fromSinglist(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (slow != null
                && fast != null
                && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
