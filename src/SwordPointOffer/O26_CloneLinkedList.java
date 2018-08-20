package SwordPointOffer;

import BaseDataStructure.RandomListNode;

public class O26_CloneLinkedList {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null){
            return null;
        }
        cloneNodes(pHead);
        connectRandom(pHead);
        return separate(pHead);

    }

    private static void cloneNodes(RandomListNode pHead){
        //复制节点
        RandomListNode cursor = pHead;
        while (cursor != null){
            RandomListNode cloneNode = new RandomListNode(cursor.label);
            cloneNode.next = cursor.next;
            cursor.next = cloneNode;
            cursor = cloneNode.next;
        }
    }

    private static void connectRandom(RandomListNode pHead){
        RandomListNode cursor = pHead;
        while (cursor != null){
            RandomListNode cloneNode = cursor.next;
//            cloneNode.random = (cursor.random == null)?null:cursor.random.next;
            if(cursor.random != null)
                cloneNode.random = cursor.random.next;
            cursor = cloneNode.next;
        }
    }

    private static RandomListNode separate(RandomListNode pHead){
        RandomListNode cursor = pHead;
        RandomListNode cloneHead = null;
        RandomListNode cloneNode = null;

        if(cursor != null){
            cloneHead = pHead.next;
            cloneNode = cloneHead;
            cursor.next = cloneHead.next;
            cursor = cursor.next;
        }

        while (cursor != null){
            cloneNode.next = cursor.next;
            cloneNode = cursor.next;
            cursor.next = cloneNode.next;
            cursor = cursor.next;
        }

        return cloneHead;
    }

    public static void main(String[] args){
        RandomListNode head = new RandomListNode(0);
        RandomListNode cursor = head;
        for(int i = 1; i<5; i++){
            cursor.next = new RandomListNode(i);
            cursor = cursor.next;
        }

        O26_CloneLinkedList a = new O26_CloneLinkedList();
        a.Clone(head);
    }
}
