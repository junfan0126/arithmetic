package leetcode;

/**
 * @author
 * @version 1.0
 * @date 2020/12/6 下午6:20
 * @description     141、环形链表
 *                  判断链表是否有环
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
            fast=head.next.next;
            slow=head.next;
            if(fast==slow){
                return true;
            }
        }
        return false;

    }
}
