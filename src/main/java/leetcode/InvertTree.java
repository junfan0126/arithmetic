package leetcode;

/**
 * @author
 * @version 1.0
 * @date 2020/12/1 下午12:46
 * @description     226、反转二叉树
 **/

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}

public class InvertTree {
    public static TreeNode invertTree(TreeNode root){
        //base case
        if(root==null){
            return null;
        }
        //交换结点左右孩子的位置
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;

        //左子树右子树做同样的操作
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

}
