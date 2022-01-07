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

import javax.xml.stream.events.StartDocument;

public class Main {

    public static void main(String[] args) {
        // System.out.println(Integer.parseUnsignedInt("91283472332", 0, 4,
        // 10));jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj
        System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
        // System.out.println(threeSum(new int[] { 1, 2, -2, -1 }));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int leftPoint = i + 1, rightPoint = len - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (leftPoint < rightPoint) {
                if (leftPoint > i + 1 && nums[leftPoint] == nums[leftPoint - 1]) {
                    leftPoint++;
                    continue;
                }

                while (leftPoint < rightPoint && nums[leftPoint] + nums[rightPoint] > -nums[i]) {
                    rightPoint--;
                }

                if (leftPoint == rightPoint)
                    break;

                // System.out.println(String.format("i=%d;left=%d;right=%d", nums[i], nums[leftPoint], nums[rightPoint]));
                if (nums[i] + nums[leftPoint] + nums[rightPoint] == 0) {
                    List<Integer> arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[leftPoint]);
                    arr.add(nums[rightPoint]);
                    res.add(arr);
                }
                leftPoint++;
            }
        }

        return res;
    }
}
