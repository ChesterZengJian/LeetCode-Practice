package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Main;

public class FindMinArrowShotsTest {
    @Test
    public void testFindMinArrowShots() {
        int[][] nums = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };
        int actual = Main.findMinArrowShots(nums);
        assertEquals(4, actual);
    }

    @Test
    public void testFindMinArrowShots1() {
        int[][] nums = { { 10, 16 } };
        int actual = Main.findMinArrowShots(nums);
        assertEquals(1, actual);
    }

    @Test
    public void testFindMinArrowShots2() {
        int[][] nums = { { -2147483646, -2147483645 }, { 2147483646, 2147483647 } };
        int actual = Main.findMinArrowShots(nums);
        assertEquals(2, actual);
    }
}
