package main.java.com.chester.topic.t0300;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCase {
    @Test
    public void testLengthOfLIS4() {
        int[] nums = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };
        Solution solution = new Solution();
        int actual = solution.lengthOfLIS(nums);
        assertEquals(4, actual);
    }

    @Test
    public void testLengthOfLIS1() {
        int[] nums = new int[] { 7, 7, 7, 7, 7, 7, 7 };
        Solution solution = new Solution();
        int actual = solution.lengthOfLIS(nums);
        assertEquals(1, actual);
    }
}
