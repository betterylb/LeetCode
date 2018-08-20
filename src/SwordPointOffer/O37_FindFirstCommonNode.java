package SwordPointOffer;

import BaseDataStructure.ListNode;

import java.util.Stack;

public class O37_FindFirstCommonNode {
    public ListNode withStack(ListNode list1, ListNode list2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        for(ListNode l = list1; l != null; l = l.next){
            stack1.push(l);
        }

        for(ListNode l = list2; l != null; l = l.next){
            stack2.push(l);
        }

        ListNode target1 = null;
        ListNode target2 = null;
        ListNode common = null;

        while (!stack1.isEmpty() && !stack2.isEmpty()){
            target1 = stack1.pop();
            target2 = stack2.pop();
            if(target1 == target2){
                common = target1;
            }
            else {
                break;
            }
        }

        return common;
    }

    public ListNode withoutStack(ListNode list1, ListNode list2){
        int len1 = length(list1);
        int len2 = length(list2);

        int lenDiff = len1>len2?(len1 - len2):(len2-len1);

        ListNode longer = len1>len2?list1:list2;
        ListNode shorter = len1>len2?list2:list1;

        for(int i=0; i<lenDiff; i++){
            longer = longer.next;
        }

        while (longer != null
                && shorter != null
                && longer != shorter){
            shorter = shorter.next;
            longer = longer.next;
        }
        return longer;
    }

    private static int length(ListNode head){
        int len = 0;
        for(ListNode l = head; l != null; l = l.next){
            len++;
        }

        return len;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(0);
        ListNode index = head;
        for(int i = 1; i < 5; i++){
            index.next = new ListNode(i);
            index = index.next;
        }
        ListNode p = null;

        System.out.println(length(p));
    }
}
