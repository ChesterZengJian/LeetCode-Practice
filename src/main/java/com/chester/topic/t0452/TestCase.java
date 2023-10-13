package main.java.com.chester.topic.t0452;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCase {
    @Test
    public void testFindMinArrowShots() {
        int[][] nums = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };
        Solution solution = new Solution();
        int actual = solution.findMinArrowShots(nums);
        assertEquals(4, actual);
    }

    @Test
    public void testFindMinArrowShots1() {
        int[][] nums = { { 10, 16 } };
        Solution solution = new Solution();
        int actual = solution.findMinArrowShots(nums);
        assertEquals(1, actual);
    }

    @Test
    public void testFindMinArrowShots2() {
        int[][] nums = { { -2147483646, -2147483645 }, { 2147483646, 2147483647 } };
        Solution solution = new Solution();
        int actual = solution.findMinArrowShots(nums);
        assertEquals(2, actual);
    }

}
