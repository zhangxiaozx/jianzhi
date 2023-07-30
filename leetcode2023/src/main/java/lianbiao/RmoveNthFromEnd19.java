package lianbiao;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * 19. 删除链表的倒数第 N 个结点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RmoveNthFromEnd19 {
    /**
     * 删除链表的倒数第n个结点，则需要找到它的倒数第n+1和结点
     * 第一个想到的方法是循环
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //边界条件判断
        if (head == null) return  head;

        //设置一个虚拟头结点(要考虑删除head结点的情况)，并设置两个快、慢指针，均指向虚拟头结点
        ListNode dummyHead = new ListNode(-1,head);
        ListNode slowIndex = dummyHead;
        ListNode fastIndex = dummyHead;

        //先让快指针走n+1步（最后快指针走到null、慢指针指向的就是倒数第n+1个结点，可以直接删除倒数第n个结点）

        for (int i = 0; i <= n; i++) {
            fastIndex = fastIndex.next;
        }

        //接下来快、慢指针同时向前走
        //快指针走到null的时候，慢指针指向的就是倒数第n+1个结点(快、慢指针始终相差n+1个结点)
        while (fastIndex != null){
            slowIndex = slowIndex.next;
            fastIndex = fastIndex.next;
        }

        //删除倒数第n+1个结点
        slowIndex.next = slowIndex.next.next;

        return dummyHead.next;


    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(4, null);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode head = new ListNode(1, n2);

        removeNthFromEnd(head, 2);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
