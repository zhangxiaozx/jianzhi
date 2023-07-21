package leetcode.year2022.jianzhioffer_1;

import java.util.ArrayDeque;
import java.util.Deque;

public class CQueue_09 {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public CQueue_09() {
        inStack = new ArrayDeque<Integer>();
        outStack = new ArrayDeque<>();
    }

    public void appendTail(int val) {
        inStack.push(val);
    }

    public int deleteHead() {
        if (outStack.isEmpty()){
            if (inStack.isEmpty()){
                return -1;
            }
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        return  outStack.pop();
    }
}
