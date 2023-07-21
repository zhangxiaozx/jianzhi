package leetcode.year2022.jianzhioffer_1.lianbiao;

/**
 * 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 */
public class GetKthFromEnd_22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        //如果链表为null，则返回null
        if(head == null) return null;
        int len = 0;
        ListNode p = head;
        //计算链表的长度
        while(p != null){
            p = p.next;
            len = len + 1;
        }
        //倒数第k个节点，从头往后数就是第len-k+1个节点,由于头指针在第1个节点、因此需要从头往后走len-k步即可到达
        int step = len - k;
        ListNode q = head;
        while(step > 0 && q != null){
            q = q.next;
            step--;
        }
        return q;
    }


    public class ListNode {
      int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

}
