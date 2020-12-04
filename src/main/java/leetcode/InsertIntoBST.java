package leetcode;

/**
 * @author
 * @version 1.0
 * @date 2020/12/4 下午3:14
 * @description     701、二叉搜索树中的插入操作
 *
 **/

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //找到空结点处赋值
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val<val){
            root.right=insertIntoBST(root.right,val);
        }
        if(root.val>val){
            root.left=insertIntoBST(root.left,val);
        }
        return root;
    }
}
