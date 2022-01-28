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
import models.MonotonicQueue;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[] { -7,-8,7,5,7,1,6,0 };
        int k = 4;
        int[] result = maxSlidingWindow(nums, k);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        // MonotonicQueue q = new MonotonicQueue();

        // for (int i = 0; i < 3; i++) {
        // q.push(nums[i]);
        // }

        // q.getMax();
        // q.print();
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> tmpResult = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
                continue;
            }

            window.push(nums[i]);
            tmpResult.add(window.getMax());
            // System.out.println(String.format("current max: %d", window.getMax()));
            window.pop(nums[i - k + 1]);
        }

        int[] result = new int[tmpResult.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = tmpResult.get(i);
        }

        return result;
    }
}
