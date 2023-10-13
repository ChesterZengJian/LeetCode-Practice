package main.java.com.chester.topic.t0055;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCase {
    @Test
    public void testCanJump() {
        int[] nums = { 2, 3, 1, 1, 4 };
        Solution solution = new Solution();
        boolean res = solution.canJump(nums);
        assertEquals(true, res);
    }

    @Test
    public void testCanJumpFalse() {
        int[] nums = { 3, 2, 1, 0, 4 };
        Solution solution = new Solution();
        boolean res = solution.canJump(nums);
        assertEquals(false, res);
    }
}
