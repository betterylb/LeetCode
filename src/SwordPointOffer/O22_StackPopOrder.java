package SwordPointOffer;

import java.util.Stack;

public class O22_StackPopOrder {
    public boolean isPopOrder(int [] pushA,int [] popA) {
        int n = pushA.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushA[pushIndex]);
            while (popIndex < n && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
