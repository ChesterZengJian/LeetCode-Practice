package main.java.com.chester.topic.t0354;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCase {
    @Test
    public void testMaxEnvelopes3() {
        int[][] nums = new int[][] { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
        Solution solution = new Solution();
        int actual = solution.maxEnvelopes(nums);
        assertEquals(3, actual);
    }

    @Test
    public void testMaxEnvelopes7() {
        int[][] nums = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 3, 5 }, { 4, 5 }, { 5, 5 }, { 5, 6 }, { 6, 7 },
                { 7, 8 } };
        Solution solution = new Solution();
        int actual = solution.maxEnvelopes(nums);
        assertEquals(7, actual);
    }
}
