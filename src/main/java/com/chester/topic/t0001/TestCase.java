package main.java.com.chester.topic.t0001;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

import main.java.com.chester.common.FormatPrint;

public class TestCase {
    @Test
    public void testTwoNum01() {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        Solution solution = new Solution();
        int[] result = solution.twoSum(nums, target);

        FormatPrint.print(result);

        assertArrayEquals(new int[] { 1, 0 }, result);
    }
}
