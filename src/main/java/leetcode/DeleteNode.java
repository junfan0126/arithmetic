package leetcode;

/**
 * @author
 * @version 1.0
 * @date 2020/12/4 下午3:47
 * @description     450、删除二叉搜索树中的结点
 **/

public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        //base case
        if (root == null) {
            return null;
        }
        //找到要删除的结点
        if (root.val == key) {
            //结点的三种情况
            //1、没有左子树
            //2、没有右子树
            //3、左子树右子树都有

            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //获取右子树最小结点
            TreeNode min = getMin(root.right);
            root.val = min.val;
            //删除最小结点
            root.right = deleteNode(root.right, min.val);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
