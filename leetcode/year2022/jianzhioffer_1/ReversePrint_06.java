package leetcode.year2022.jianzhioffer_1;

import java.util.Arrays;
import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class ReversePrint_06 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static  int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        //因为stack.size()是变量，所以在下面这行代码中使用stack.size()会导致结果错误

        for (int i =0; i<size; i++){
            res[i] = stack.pop().val;
        }

        return res;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next =new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        int[] res = reversePrint(listNode);

        System.out.println(Arrays.toString(res));

    }


}
