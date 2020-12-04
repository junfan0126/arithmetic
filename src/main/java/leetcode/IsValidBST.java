package leetcode;

/**
 * @author
 * @version 1.0
 * @date 2020/12/4 下午2:04
 * @description     98、验证二叉搜索树
 **/

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);
    }
    public boolean isValidBST(TreeNode root,TreeNode min,TreeNode max) {
        //base case
        if(root==null){
            return true;
        }
        if(min!=null&&root.val<=min.val){
            return false;
        }
        if(max!=null&&root.val>=max.val){
            return false;
        }
        return isValidBST(root.left,min,root)
                &&isValidBST(root.right,root,max);
    }
}
