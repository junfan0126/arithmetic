package leetcode;

/**
 * @author
 * @version 1.0
 * @date 2020/12/4 上午10:28
 * @description     230、寻找第K小元素
 *                  采用中序遍历，因为在二叉搜索树中，中序遍历的结果是升序排序
 *                  所以直接从前找第n个就可以了
 **/

public class KthSmallest {
    //记录最小值
    int res=0;
    //记录当前位置排名
    int rank=0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root,k);
        return res;
    }

    public void traverse(TreeNode root,int k){
        if(root==null){
            return;
        }
        traverse(root.left,k);
        rank++;
        if(k==rank){
            res=root.val;
            return;
        }
        traverse(root.right,k);
    }
}
