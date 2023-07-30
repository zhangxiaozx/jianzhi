package lianbiao;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class DetectCycle142 {
    public ListNode deteCycle(ListNode head){

        //设置两个指针slow和fast，指向head
        ListNode slow = head;
        ListNode fast = head;

        //判断走的比较快的fast指针以及fast.next是否为空，不是空就一直向前走直到相遇，是空就返回null（无环）
        //slow一次走1步，fast一次走2步
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) //如果两者相遇，则停止循环
                break;
        }

        //无环则返回null
        if (fast == null || fast.next == null) return null;

        fast = head;

        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;



    }
}
