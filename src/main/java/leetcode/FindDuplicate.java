package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author
 * @version 1.0
 * @date 2020/12/3 上午11:07
 * @description     652. 寻找重复的子树
 **/

public class FindDuplicate {
    //用hashmap来存储子树序列，记录出现次数
    HashMap<String, Integer> memo = new HashMap<>();
    LinkedList<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    public String traverse(TreeNode root) {
        //定义空结点为#
        if (root == null) {
            return "#";
        }

        //获取左右子树序列
        String left = traverse(root.left);
        String right = traverse(root.right);
        //采用后序顺序（左右根）拼接子树字符串序列
        String subTree = left + "," + right + "," + root.val;

        int freq = memo.getOrDefault(subTree, 0);
        //重复子树只添加一次
        if (freq == 1) {
            res.add(root);
        }
        //更新出现次数
        memo.put(subTree, freq + 1);
        return subTree;
    }
}
