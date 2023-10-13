import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        ArrayList<String> data = new ArrayList<>();
        serialize(root, data);

        return String.join(",", data);
    }

    public void serialize(TreeNode root, ArrayList<String> data) {
        if (root == null) {
            data.add(null);
            return;
        }

        data.add(Integer.toString(root.val));

        serialize(root.left, data);
        serialize(root.right, data);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        LinkedList<String> nodes = new LinkedList<>();
        String[] strs = data.split(",");

        for (int i = 0; i < strs.length; i++) {
            nodes.addLast(strs[i]);
        }

        return deserialize(nodes);
    }

    public TreeNode deserialize(LinkedList<String> data) {
        if (data.isEmpty())
            return null;

        String firstData = data.removeFirst();
        System.out.println("First data:" + firstData);
        if (firstData.equals("null"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(firstData));
        root.left = deserialize(data);
        root.right = deserialize(data);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end
