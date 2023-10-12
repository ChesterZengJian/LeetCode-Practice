package src.main.com.chester.models;

public class BinarySearchTreeNode {
    public int val;
    public BinarySearchTreeNode left, right;

    public BinarySearchTreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public BinarySearchTreeNode getRight() {
        return right;
    }

    public void setRight(BinarySearchTreeNode right) {
        this.right = right;
    }

    public BinarySearchTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTreeNode left) {
        this.left = left;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
