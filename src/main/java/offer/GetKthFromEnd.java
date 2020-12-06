package offer;


/**
 * @author
 * @version 1.0
 * @date 2020/12/6 下午8:34
 * @description     剑指offer22、链表中倒数第k个结点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 **/

public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast,slow;
        fast=slow=head;
        for(int i=1;i<=k;i++){
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
