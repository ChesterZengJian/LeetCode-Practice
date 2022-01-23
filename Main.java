import java.io.Console;
import java.lang.reflect.Array;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.LogManager;

import javax.management.ValueExp;
import javax.sql.rowset.serial.SerialArray;
import javax.swing.RootPaneContainer;
import javax.swing.plaf.synth.SynthButtonUI;
import javax.xml.stream.events.StartDocument;

import models.BinarySearchTree;
import models.BinarySearchTreeNode;
import models.ListNode;

public class Main {

    public static void main(String[] args) {
        BinarySearchTreeNode root = new BinarySearchTreeNode(3);
        root.setLeft(new BinarySearchTreeNode(5));
        root.setRight(new BinarySearchTreeNode(1));
        root.getRight().setLeft(new BinarySearchTreeNode(0));
        root.getRight().setRight(new BinarySearchTreeNode(8));
        BinarySearchTree bst = new BinarySearchTree(root);
        // bst.insertIntoBST(21);
        // bst.insertIntoBST(25);

        // ArrayList<String> arr = new ArrayList<>();
        // arr.add(null);
        // arr.add("1");
        // String str = String.join(";", arr);
        // System.out.println(str);
        // String serializeStr = bst.serialize();
        // System.out.println(serializeStr);
        // BinarySearchTreeNode treeNode = BinarySearchTree.deserialize("");
        // BinarySearchTree desBst = new BinarySearchTree(treeNode);
        // System.out.println(desBst.toString());
        BinarySearchTreeNode lcaNode = bst.lowestCommonAncestor(new BinarySearchTreeNode(5),
                new BinarySearchTreeNode(1));
        System.out.println(lcaNode.val);

        // int treeHeight = bst.getHeight();

        // System.out.println(String.format("Tree height=%d; Total height=%d; Total
        // weight=%d", treeHeight,
        // treeHeight * 2 - 1, (2 << (treeHeight - 1)) * 3 + 1));
        // System.out.println(bst.toString());
        // System.out.println(bst.IsValidBST());
        // System.out.println(bst.container(6));
    }

}
