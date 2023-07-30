package lianbiao;

public class ReverseList206 {

    /**
     * 双指针：pre、cur
     * pre在前，cur在后
     */
    public ListNode reverseList(ListNode head) {
        //判断head是否为null
        if (head == null) return head;

        ListNode pre = null; //new一个新结点pre，指向null
        ListNode cur = head;  //设置当前结点cur指向head.next

        while (cur != null){
            ListNode tmp = cur.next; //保存cur的next结点
            cur.next = pre; //反转当前结点
            pre = cur; //将当前结点作为pre
            cur = tmp; //将原来的cur.next作为cur

        }
        return pre; //返回pre

    }
}
