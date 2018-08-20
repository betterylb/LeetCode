package SwordPointOffer;

import BaseDataStructure.ListNode;

public class O17_MergeSortedList {

    /**
     * 递归的做法
     * @param list1
     * @param list2
     * @return
     */
    public ListNode reduceMerge(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        ListNode mergList = null;

        if(list1.val < list2.val){
            mergList = list1;
            mergList.next = reduceMerge(list1.next, list2);
        }
        else {
            mergList = list2;
            mergList.next = reduceMerge(list1, list2.next);
        }
        return mergList;
    }

    /**
     * 遍历的解决方案，要注意，null不在堆上，将入对象A是null,将另一个对象B = A;
     * 当A被赋值之后，A和B就不在同一个位置了
     * @param list1
     * @param list2
     * @return
     */
    public ListNode iterMerge(ListNode list1, ListNode list2){
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        ListNode mergList = new ListNode(0);
        ListNode mergCursor = mergList;
        ListNode cursor1 = list1;
        ListNode cursor2 = list2;

        while (cursor1 != null && cursor2 != null){
            if(cursor1.val < cursor2.val){
                mergCursor.next = cursor1;
                cursor1 = cursor1.next;
            }
            else {
                mergCursor.next = cursor2;
                cursor2 = cursor2.next;
            }
            mergCursor = mergCursor.next;
        }

        if(cursor1 != null)
            mergCursor.next = cursor1;
        if (cursor2 != null)
            mergCursor.next = cursor2;

        return mergList.next;
    }

    public static void main(String[] args){
        ListNode target1 = null;
        ListNode target2 = null;
        System.out.println(target1 == target2);
    }
}
