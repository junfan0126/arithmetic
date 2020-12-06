package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @version 1.0
 * @date 2020/12/6 下午2:35
 * @description     589、N叉树的前序遍历
 **/
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Preorder {
    public List<Integer> preorder(Node root) {
        List<Integer> stack=new ArrayList<>();
        taverse(root,stack);
        return stack;
    }
    public void taverse(Node node,List<Integer> stack){
        if(node==null){
            return;
        }
        stack.add(node.val);
        for(Node root:node.children){
            taverse(root,stack);
        }
    }
}

