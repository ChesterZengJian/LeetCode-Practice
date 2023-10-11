package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Main;

public class MaxEnvelopesTest {
    @Test
    public void testMaxEnvelopes3() {
        int[][] nums = new int[][] { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
        int actual = Main.maxEnvelopes(nums);
        assertEquals(3, actual);
    }

    @Test
    public void testMaxEnvelopes7() {
        int[][] nums = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 3, 5 }, { 4, 5 }, { 5, 5 }, { 5, 6 }, { 6, 7 },
                { 7, 8 } };
        int actual = Main.maxEnvelopes(nums);
        assertEquals(7, actual);
    }
}
