package leetcode;

/**
 * @author
 * @version 1.0
 * @date 2020/12/4 下午2:54
 * @description     700、二叉搜索中的搜索
 *                  类似二分查找结合搜索树左子树小于右子树的特性
 **/

public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        return null;
    }
}
