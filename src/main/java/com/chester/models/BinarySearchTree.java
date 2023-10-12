package src.main.com.chester.models;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinarySearchTree {
    private BinarySearchTreeNode root;

    public BinarySearchTree(BinarySearchTreeNode root) {
        this.root = root;
    }

    public BinarySearchTreeNode insertIntoBST(int val) {
        return insertIntoBST(root, val);
    }

    public static BinarySearchTreeNode insertIntoBST(BinarySearchTreeNode root, int val) {
        if (root == null)
            return new BinarySearchTreeNode(val);

        if (root.val == val)
            return root;

        if (root.val < val)
            root.right = insertIntoBST(root.right, val);

        if (root.val > val)
            root.left = insertIntoBST(root.left, val);

        return root;
    }

    public static BinarySearchTreeNode deleteNode(BinarySearchTreeNode root, int target) {
        if (root == null)
            return null;

        if (root.val == target) {
            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            BinarySearchTreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        } else if (root.val > target) {
            root.left = deleteNode(root.left, target);
        } else if (root.val < target) {
            root.right = deleteNode(root.right, target);
        }

        return root;
    }

    public static BinarySearchTreeNode getMin(BinarySearchTreeNode root) {
        while (root.left != null)
            root = root.left;

        return root;
    }

    public boolean isSameTree(BinarySearchTreeNode target) {
        return isSameTree(root, target);
    }

    public static boolean isSameTree(BinarySearchTreeNode root1, BinarySearchTreeNode root2) {
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        if (root1.val != root2.val)
            return false;

        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);

    }

    public boolean IsValidBST() {
        return IsValidBST(root, null, null);
    }

    public static boolean IsValidBST(BinarySearchTreeNode root, BinarySearchTreeNode min, BinarySearchTreeNode max) {
        if (root == null)
            return true;

        if (min != null && root.val <= min.val)
            return false;

        if (max != null && root.val >= max.val)
            return false;

        return IsValidBST(root.left, min, root) && IsValidBST(root.right, root, max);
    }

    public int getHeight() {
        return getHeight(root);
    }

    public static int getHeight(BinarySearchTreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public boolean container(int target) {
        return container(root, target);
    }

    public static boolean container(BinarySearchTreeNode root, int target) {
        if (root == null)
            return false;

        if (root.val == target) {
            return true;
        }

        if (root.val < target) {
            return container(root.right, target);
        }

        return container(root.left, target);
    }

    public String serialize() {
        return serialize(root);
    }

    // Encodes a tree to a single string.
    public static String serialize(BinarySearchTreeNode root) {
        if (root == null) {
            return "";
        }

        ArrayList<String> data = new ArrayList<>();
        serialize(root, data);

        return String.join(",", data);
    }

    public static void serialize(BinarySearchTreeNode root, ArrayList<String> data) {
        if (root == null) {
            data.add(null);
            return;
        }

        data.add(Integer.toString(root.val));

        serialize(root.left, data);
        serialize(root.right, data);
    }

    // Decodes your encoded data to tree.
    public static BinarySearchTreeNode deserialize(String data) {
        if (data.isEmpty()) {
            System.out.println("null");
            return null;
        }

        LinkedList<String> nodes = new LinkedList<>();
        String[] strs = data.split(",");

        for (int i = 0; i < strs.length; i++) {
            System.out.println("linked add " + strs[i]);
            nodes.addLast(strs[i]);
        }

        return deserialize(nodes);
    }

    public static BinarySearchTreeNode deserialize(LinkedList<String> data) {
        if (data.isEmpty())
            return null;

        String firstData = data.removeFirst();
        System.out.println("First data:" + firstData);
        if (firstData.equals("null"))
            return null;

        BinarySearchTreeNode root = new BinarySearchTreeNode(Integer.parseInt(firstData));
        root.left = deserialize(data);
        root.right = deserialize(data);
        return root;
    }

    public BinarySearchTreeNode lowestCommonAncestor(BinarySearchTreeNode p, BinarySearchTreeNode q) {
        return lowestCommonAncestor(root, p, q);
    }

    public static BinarySearchTreeNode lowestCommonAncestor(BinarySearchTreeNode root, BinarySearchTreeNode p,
            BinarySearchTreeNode q) {
        if (root == null)
            return null;
        if (root.val == p.val || root.val == q.val)
            return root;

        BinarySearchTreeNode left = lowestCommonAncestor(root.left, p, q);
        BinarySearchTreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;
        if (left == null && right == null)
            return null;

        return left == null ? right : left;
    }

    @Override
    public String toString() {
        return toString(root);
    }

    public String toString(BinarySearchTreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        if (root.left != null || root.right != null)
            sb.append("\n");

        if (root.left != null)
            sb.append(toString(root.left) + "\t");

        if (root.right != null)
            sb.append(toString(root.right));

        return sb.toString();
    }
}
