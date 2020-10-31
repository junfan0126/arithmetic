/**
 * @author
 * @version 1.0
 * @date 2020/10/31 下午3:18
 * @description
 **/

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val +
                ", " + left +
                ", " + right;
    }
}