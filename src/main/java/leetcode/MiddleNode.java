package leetcode;

/**
 * @author
 * @version 1.0
 * @date 2020/12/6 下午8:23
 * @description     876、链表的中间结点
 *                  利用快慢指针，快指针到达表的尽头时，慢指针就是中间结点
 **/

public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode fast,slow;
        fast=slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
