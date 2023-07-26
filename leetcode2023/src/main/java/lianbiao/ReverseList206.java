package lianbiao;

public class ReverseList206 {

    public ListNode reverseList(ListNode head) {
        //判断head是否为null
        if (head == null) return head;

        ListNode pre = head; //new一个新结点pre，指向head
        ListNode cur = head.next;  //设置当前结点cur指向head.next
        pre.next = null;   //反转：pre的next指向null

        while (cur != null){
            ListNode tmp = cur.next; //保存cur的next结点
            cur.next = pre; //反转当前结点
            pre = cur; //将当前结点作为pre
            cur = tmp; //将原来的cur.next作为cur

        }
        return pre; //返回pre

    }
}
