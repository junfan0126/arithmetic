package leetcode;

/**
 * @author
 * @version 1.0
 * @date 2020/12/1 下午1:56
 * @description     114、二叉树展开为链表
 **/

public class Flatten {
    public static void flatten(TreeNode root) {
        if(root==null){
            return;
        }

        //拉平左右子树
        flatten(root.left);
        flatten(root.right);

        //把拉平后的子树单独拎出来
        TreeNode left = root.left;
        TreeNode right = root.right;

        //把左子树放到右子树的位置
        root.left = null;
        root.right = left;

        //寻找原先的左子树的最右边结点
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        //把右子树与原来左子树最右边结点相连
        p.right = right;

    }
}
