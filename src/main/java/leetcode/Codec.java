package leetcode;

import javax.swing.plaf.SeparatorUI;
import java.util.LinkedList;
import java.util.List;

/**
 * @author
 * @version 1.0
 * @date 2020/12/1 下午4:19
 * @description 297、二叉树的序列化和反序列化(困难，采用前序遍历)
 **/

public class Codec {
    String NULL = "#";
    String SEP = ",";

    // Encodes a tree to a single string.
    //前序遍历格式
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        sb.append(root.val).append(SEP);

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    //前序遍历格式
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);

    }

    public TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

        String first = nodes.removeFirst();
        if (first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}