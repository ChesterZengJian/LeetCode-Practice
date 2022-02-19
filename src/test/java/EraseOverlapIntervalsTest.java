package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Main;

public class EraseOverlapIntervalsTest {
    @Test
    public void testEraseOverlapIntervals() {
        int[][] nums = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        int actual = Main.eraseOverlapIntervals(nums);
        assertEquals(1, actual);
    }

    @Test
    public void testEraseOverlapIntervals2() {
        int[][] nums = { { 1, 2 }, { 1, 2 }, { 1, 2 } };
        int actual = Main.eraseOverlapIntervals(nums);
        assertEquals(2, actual);
    }

    @Test
    public void testEraseOverlapIntervals0() {
        int[][] nums = { { 1, 2 }, { 2, 4 } };
        int actual = Main.eraseOverlapIntervals(nums);
        assertEquals(0, actual);
    }
}
