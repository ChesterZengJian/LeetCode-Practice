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
import java.util.logging.LogManager;

import javax.sql.rowset.serial.SerialArray;
import javax.swing.plaf.synth.SynthButtonUI;
import javax.xml.stream.events.StartDocument;

import models.ListNode;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[] { 6 };
        // System.out.println(searchLeftRange(nums, 8));
        // System.out.println(searchrightRange(nums, 8));
        int[] res = searchRange(nums, 6);
        System.out.println("[" + res[0] + "," + res[1] + "]");
    }

    public static int[] searchRange(int[] nums, int target) {
        return new int[] { searchLeftRange(nums, target), searchrightRange(nums, target) };
    }

    public static int searchLeftRange(int[] nums, int target) {
        if (nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        if (left >= nums.length || nums[left] != target) {
            return -1;
        }

        return left;
    }

    public static int searchrightRange(int[] nums, int target) {
        if (nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }

        return right;
    }
}
