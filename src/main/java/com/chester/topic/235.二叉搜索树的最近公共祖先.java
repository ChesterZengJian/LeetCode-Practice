/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
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

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;

        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }

        return ancestor;
    }

    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // if (root == null)
    // return null;
    // if (root.val == p.val || root.val == q.val)
    // return root;

    // TreeNode left = lowestCommonAncestor(root.left, p, q);
    // TreeNode right = lowestCommonAncestor(root.right, p, q);

    // if (left != null && right != null)
    // return root;

    // if (left == null && right == null)
    // return null;

    // return left == null ? right : left;
    // }
}
// @lc code=end
