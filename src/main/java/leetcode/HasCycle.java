package leetcode;

/**
 * @author
 * @version 1.0
 * @date 2020/12/6 下午6:20
 * @description     141、环形链表
 *                  判断链表是否有环，使用快慢指针
 *                  如果有环，快指针则比慢指针多走一圈，也就是两指针最终相等
 **/


 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
     }
  }


public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast,slow;
        fast=slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;

    }
}
