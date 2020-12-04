package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @version 1.0
 * @date 2020/12/4 下午5:06
 * @description     897、递归顺序查找树
 *                    中序遍历+构建新的子树
 **/

public class IncreasingBST {
    public TreeNode increasingBST(TreeNode root) {
        //1.创建一个新动态数组
        List<Integer> vals = new ArrayList();
        //2.调用方法
        inorder(root,vals);
        //3.定义一个树结点ans，以及cur指针
        TreeNode ans = new TreeNode(0), cur = ans;
        for(int v : vals) {
            //4.遍历生成新树
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }

    public void inorder(TreeNode node, List<Integer> vals) {
        //base case
        if(node == null) {
            return;
        }
        //先左后右
        //2.递归调用该结点的左结点，并在动态数组中加入新结点
        inorder(node.left,vals);
        vals.add(node.val);
        //2.递归调用该结点的右结点，并在动态数组中加入新结点
        inorder(node.right,vals);
    }
}
