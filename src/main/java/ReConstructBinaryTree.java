import java.util.Arrays;

/**
 * @author
 * @version 1.0
 * @date 2020/10/31 下午3:11
 * @description     根据前序遍历和中序遍历重建二叉树
 **/


public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //判断前序遍历长度不为0
        if (pre.length == 0) {
            return null;
        }

        if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }

        int rootVal = pre[0];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = 0;
        //确定根结点在中序遍历的位置
        for (int i = 0; i < in.length; i++) {
            if (rootVal == in[i]) {
                rootIndex = i;
                break;
            }
        }
        //分别递归左子树和右子树，相当于把找到的子树进行拼接
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootIndex + 1), Arrays.copyOfRange(in, 0, rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootIndex + 1, pre.length), Arrays.copyOfRange(in, rootIndex, in.length));
        return root;
    }

    public static void main(String[] args) {
        ReConstructBinaryTree s=new ReConstructBinaryTree();
        int[] pre={1,2,3,4,5,6,7};
        int[] in={3,2,4,1,6,5,7};
       System.out.println(s.reConstructBinaryTree(pre,in));
    }
}
