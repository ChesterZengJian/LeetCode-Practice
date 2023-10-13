package main.java.com.chester.topic.t0435;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCase {
    @Test
    public void testEraseOverlapIntervals() {
        int[][] nums = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        Solution solution = new Solution();
        int actual = solution.eraseOverlapIntervals(nums);
        assertEquals(1, actual);
    }

    @Test
    public void testEraseOverlapIntervals2() {
        int[][] nums = { { 1, 2 }, { 1, 2 }, { 1, 2 } };
        Solution solution = new Solution();
        int actual = solution.eraseOverlapIntervals(nums);
        assertEquals(2, actual);
    }

    @Test
    public void testEraseOverlapIntervals0() {
        int[][] nums = { { 1, 2 }, { 2, 4 } };
        Solution solution = new Solution();
        int actual = solution.eraseOverlapIntervals(nums);
        assertEquals(0, actual);
    }
}
