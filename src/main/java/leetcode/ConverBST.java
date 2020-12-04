package leetcode;

/**
 * @author
 * @version 1.0
 * @date 2020/12/4 上午11:17
 * @description     538、把二叉搜索树转化为累加树
 *                  二叉搜索树特性左子树小于右子树，中序遍历结果是升序，
 *                  这里采用先访问右子树再访问左子树，使其结果为降序
 *                  也就是说每次访问的都是当前结点中的最大值，然后sum来保存累加和
 *                  最后转化为累加树
 **/

public class ConverBST {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
    public void traverse(TreeNode root){
        if(root==null){
            return;
        }

        traverse(root.right);
        //更新已经遍历过结点的累加和
        sum += root.val;
        //更新结点，转换为累加树
        root.val=sum;
        traverse(root.left);
    }
}
