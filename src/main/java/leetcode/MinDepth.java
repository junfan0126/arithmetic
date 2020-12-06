package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author
 * @version 1.0
 * @date 2020/12/6 下午5:13
 * @description     111、二叉树最小深度(BFS)
 *                  从根结点到叶子结点的最小距离
 *                  起始为根结点，终点为叶子结点
 **/

public class MinDepth {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> q=new LinkedList<>();
        //添加根结点，起点
        q.offer(root);
        //根结点也算一层，所以初始化深度为1
        int depth=1;

        while (!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                TreeNode cur=q.poll();
                //判断是否到达叶子结点
                if(cur.left==null&&cur.right==null){
                    return depth;
                }
                //将cur相邻结点加入队列
                if(cur.left!=null){
                    q.offer(cur.left);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                }
            }
            //每次操作结束后深度+1
            depth++;
        }
        return depth;
    }
}
