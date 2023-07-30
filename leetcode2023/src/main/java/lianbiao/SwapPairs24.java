package lianbiao;

import java.util.Arrays;

/**
 *https://leetcode.cn/problems/swap-nodes-in-pairs/
 *
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class SwapPairs24 {
    public static ListNode swapPairs(ListNode head) {

        //边界判断
        if (head == null || head.next == null) return head;

        //设置虚拟头结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode curNode = dummyHead; //设置一个当前结点，使其指向虚拟头结点
        //对curNode的下一个结点以及下下一个结点做交换，先判断是否为null
        while (curNode.next != null && curNode.next.next != null){
            //使用临时结点存储要交换的结点
            ListNode node1 = curNode.next;
            ListNode node2 = curNode.next.next;

            //开始交换，curNode的下一个结点指向下下一个结点
            curNode.next= node2;

            //node1的next结点指向node2的next结点
            node1.next = node2.next;

            //node2的next结点指向node1
            node2.next = node1;

            //交换完成，将curNode往前移动
            curNode = node1;
        }

        return dummyHead.next; //返回虚拟头结点的next结点
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(4,null);
        ListNode n3 = new ListNode(3,n4);
        ListNode n2 = new ListNode(2,n3);
        ListNode n1 = new ListNode(1,n2);

          swapPairs(n1);
          while (n1 != null ){
              System.out.println(n1.val);
              n1 =n1.next;
          }

    }

}
