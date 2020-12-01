package leetcode;

/**
 * @author
 * @version 1.0
 * @date 2020/12/1 下午1:22
 * @description     116、填充每个节点的下一个右侧指针
 **/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


public class ConnectNode {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        //关键在于存在相邻的不属于同一父节点的两个结点（特殊情况）
        //这里是现将左右子树结点通过递归连接好，再递归一次来连接特殊结点
        connectTwo(root.left,root.right);
        return root;
    }

    public void connectTwo(Node node1,Node node2){
        if(node1==null||node2==null){
            return ;
        }
        node1.next=node2;

        connectTwo(node1.left,node1.right);
        connectTwo(node2.left,node2.right);
        connectTwo(node1.right,node2.left);
    }
}
