package lianbiao;
import lianbiao.ListNode;

/**
 * 使用虚拟头结点解决问题
 */
public class RemoveElements203 {
    public static ListNode removeElements(ListNode head, int val) {
        //创建一个虚拟头结点
        ListNode dummy = new ListNode(val-1);
        dummy.next = head;
        ListNode pre = dummy;

        //确保当前结点之后还有结点
        while (pre.next != null){
            if (pre.next.val == val){ //符合条件，则当前结点指向当前结点下一个结点的下一个结点
                pre = pre.next.next;
            }else {
                //不满足条件、则继续遍历链表
                pre = pre.next;
            }
        }
        return dummy.next; //需要返回dummy.next，不能返回head，因为head可能已经被删除了

    }

}



