package lianbiao;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null 。
 */
public class GetIntersectionNode07 {

    /**
     * 使用路径长度一致的方法找到相交结点
     */
    public static  ListNode getIntersectionNode(ListNode headA, ListNode headB){
        //设置两个结点分别指向headA、headB
        ListNode a = headA;
        ListNode b = headB;
        /**
         * 循环结束条件：a == b
         *  1.如果两个链表有相交的结点：假设相交之前的结点长度分别为A和B，相交之后的长度为C，则A+C+B = B +C+A，即：临时结点a和b走过相同的路径之后一定会相遇
         *  2.如果两个链表没有相交结点：两个链表的长度分别为A和B，则 A + B = B + A，最后a和b都指向null
         */
        while (a != b){

              a = a != null ? a.next : headB;
              b = b != null ? b.next : headA;
        }
        return a;
    }

    //测试
    public static void main(String[] args) {
        ListNode n4 = new ListNode(4, null);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode headA = new ListNode(1, n2);



        ListNode b3 = new ListNode(3);
        ListNode b2 = new ListNode(2, b3);
        ListNode headB = new ListNode(1, b2);

        System.out.println(getIntersectionNode(headA, headB));


    }
}
