package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author
 * @version 1.0
 * @date 2020/11/3 下午4:26
 * @description
 *                      输入一个链表，按链表从尾到头的顺序返回一个ArrayList
 *        输入{67,0,24,58}        输出[68,24,0,67]
 **/

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class PrintArrayList {

    //头插法
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();
        if(listNode==null){
            return list;
        }
        while(listNode.next!=null){
            list.add(0,listNode.val);
            listNode=listNode.next;
        }
        return list;
    }

    //栈实现
    public ArrayList<Integer> printListFromTailToHeadByStack(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();
        if(listNode==null){
            return list;
        }
        Stack<Integer> stack=new Stack<Integer>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

}

