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

    /**
     * 只需要判断是不是有环
     * @param head
     * @return
     */
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

    /**
     * 问题2：找出入口点，
     *
     * 假设环的长度是r，入口到头结点长度为a, 入口点到相遇点距离为x
     * 慢指针走的距离是s
     * s=n*r（2*s=s+n*r)
     * a+x=s
     * r=L-a
     * 得到a=(n-1)*r+(L-a-x)
     * 注意，从相遇点走L-a-x距离刚好可以在入口点相遇
     *
     * 从这个式子得到的启示，一个点从头结点走，一个点从快慢指针相遇点走，两个点正好在入口点相遇
     * @param head
     * @return
     */
    public ListNode returnEntry(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (slow != null
                && fast != null
                && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(slow == null && fast.next == null){
            return null;
        }

        ListNode prev = head;
        ListNode forward = slow;
        while (prev != forward){
            prev = prev.next;
            forward = forward.next;
        }

        return prev;
    }

    /**
     * 问题5
     * @param pInCircule：环中的目标点
     * 思路，还是快慢指针，当快指针走会原节点，慢指针刚好走一半，
     * 就是对应点
     */
    public ListNode findMirror(ListNode pInCircule){
        ListNode slow = pInCircule;
        ListNode fast = pInCircule;
        do{
            slow = slow.next;
            fast = fast.next.next;
        }while (fast != pInCircule && fast != pInCircule.next);

        return slow;
    }


}
