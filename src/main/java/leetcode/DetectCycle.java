package leetcode;

/**
 * @author
 * @version 1.0
 * @date 2020/12/6 下午7:32
 * @description     142、环形链表2
 *                   给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 **/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast,slow;
        fast=slow=head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
