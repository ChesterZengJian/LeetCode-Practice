import java.io.Console;
import java.lang.Thread.State;
import java.lang.reflect.Array;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.LogManager;

import javax.imageio.ImageReadParam;
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
        int[] nums1 = new int[] { 4, 1, 2 };
        int[] nums2 = new int[] { 1, 3, 4, 2 };
        int[] result = nextGreaterElement(nums1, nums2);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>(nums2.length);
        int[] nums2NextGreaterElements = new int[nums2.length];
        int[] result = new int[nums1.length];

        for (int i = nums2.length - 1; i >= 0; i--) {
            map.put(nums2[i], i);
            while (!stack.empty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            nums2NextGreaterElements[i] = stack.empty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            int numIds = map.get(nums1[i]);
            result[i] = nums2NextGreaterElements[numIds];
        }

        return result;
    }
}
